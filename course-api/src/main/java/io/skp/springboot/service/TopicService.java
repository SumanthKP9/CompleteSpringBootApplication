package io.skp.springboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.skp.springboot.beans.Topic;
import io.skp.springboot.exception.CourseAPIException;

@Service
public class TopicService {

	Logger logger=LoggerFactory.getLogger(TopicService.class);
	private List<Topic> topics=new ArrayList<>(Arrays.asList(
			new Topic("spring","Spring FrameWork","Spring FrameWork Description"),
			new Topic("java","Core Java","Core Java Description"),
			new Topic("javascript","JavaScript","JavaScript Description")
			));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id){
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		logger.debug("Start of getTopics");
		topics.add(topic);
		logger.debug("Start of getTopics");
	}

	public void updateTopic(String id,Topic topic) {
		for(int i=0;i<topics.size();i++){
			Topic t=topics.get(i);
			if(t.getId().equals(id)){
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) throws CourseAPIException {
		if(topics.removeIf(t->t.getId().equals(id))){
			
		}else{
			throw new CourseAPIException(id +" Not Found");
		}
		
	}
}
