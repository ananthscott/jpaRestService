package com.example.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
		
		private List<Topic> topicsList =  new ArrayList<>(
				Arrays.asList(
						
						new Topic("Spring","Spring Boot","Detailed Explanation"),
						new Topic("java","Java 8","Lmbda expressions"),
						new Topic("javascript","JS","Node and React...")
						
						));
		//Get all Topics
		public List<Topic> getAllTopics(){
			List<Topic> topics = new ArrayList<Topic>();
			topicRepository.findAll()
			.forEach(topics :: add);
			return topics;
		}
		
		//Get Single Topic based on Topic Id
		public Topic getTopic(String topicId) {
			//return topicsList.stream().filter(t -> t.getId().equals(topicId)).findFirst().get();
			return topicRepository.findById(topicId).get();
		}
		
		//Adds New Topic
		public void addTopic(Topic topic) {
			 topicRepository.save(topic);
		}
		
		//Update Existing Topic
		public void updateTopic(Topic topic) {
			topicRepository.save(topic);
		}
		
		//delete Existing Topic
		public void deleteTopic(String topicId) {
			topicRepository.deleteById(topicId);
		}
	
}
