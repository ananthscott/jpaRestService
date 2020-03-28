package com.example.demo.topic;



import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	@Autowired
	private TopicService topicService;
	

	@GetMapping("/topics")
	public List<Topic> listOfTopics() {
		
		return topicService.getAllTopics();
	}
	
	@GetMapping("/topics/{topicId}")
	public Topic getTopic(@PathVariable String topicId) {
		
		return topicService.getTopic(topicId);
	}
	
	
	@PostMapping("/topics")
	public void addTopic(@RequestBody Topic topic) {
		
		topicService.addTopic(topic);
	}
	
	@PutMapping("/topics")
	public void updateTopic(@RequestBody Topic topic) {
		
		topicService.updateTopic(topic);
	}
	
	
	@DeleteMapping("/topics/{topicId}")
	public void deleteTopic(@PathVariable String topicId) {
		
		topicService.deleteTopic(topicId);
	}
	
	
	
}
