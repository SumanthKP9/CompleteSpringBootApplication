package io.skp.springboot.test;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import io.skp.springboot.beans.Topic;
import io.skp.springboot.controller.TopicController;
import io.skp.springboot.service.TopicService;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings("deprecation")
public class CourseAPITest {

	@Mock
	TopicService topicService;
	
	
	@InjectMocks
	TopicController topicController;
	
	
	@Test
	public void testGetAllTopics(){
		List<Topic> topics=new ArrayList<>(Arrays.asList(new Topic("java","Core Java","Core Java Description")));
		when(topicService.getAllTopics()).thenReturn(topics);
		assertEquals(topics, topicController.getAllTopics());
	}
	
	@Test
	public void testGetTopic(){
		Topic topic=new Topic("java","Core Java","Core Java Description");
		when(topicService.getTopic(any(String.class))).thenReturn(topic);
		assertEquals(topic, topicController.getTopic("1234"));
		
	}
}
