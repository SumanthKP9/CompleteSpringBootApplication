package io.skp.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;


import io.skp.springboot.beans.Topic;
import io.skp.springboot.exception.CourseAPIErrorDetails;
import io.skp.springboot.exception.CourseAPIException;
import io.skp.springboot.service.TopicService;

@RestController
public class TopicController {
	//Logger logger=LoggerFactory.getLogger(TopicController.class);
	
	@Autowired
	private TopicService topicService;

	@RequestMapping("topics")
	public List<Topic> getAllTopics(){
		
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id){
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void addTopic(@RequestBody Topic topic){
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id){
		topicService.updateTopic(id,topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) throws CourseAPIException{
		topicService.deleteTopic(id);
	}
	
	@ExceptionHandler(CourseAPIException.class)
	public ResponseEntity<CourseAPIErrorDetails> exceptionHandler(CourseAPIException e,WebRequest request){
		CourseAPIErrorDetails apiException=new CourseAPIErrorDetails("E001", e.getMessage());
		return new ResponseEntity<>(apiException,HttpStatus.NOT_FOUND);
	}
	
	/*@RequestMapping("topics")
	public List<Topic> getTopics(){
		List<Topic> list=Arrays.asList(
				new Topic("spring","Spring FrameWork","Spring FrameWork Description"),
				new Topic("java","Core Java","Core Java Description"),
				new Topic("javascript","JavaScript","JavaScript Description")
				);
		return list;
	}*/
}
