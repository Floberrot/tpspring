package com.j2ee.tdspring.services;

import java.util.ArrayList;
import java.util.List;

import com.j2ee.tdspring.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j2ee.tdspring.entities.Projects;
import com.j2ee.tdspring.repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired 
	 private ProjectRepository projectRepository;
	@Autowired
	 private UserService userService;

	
	public Projects createOrUpdate(Projects project) { 
		  return projectRepository.save(project); 
	} 
		 
	public Projects getPatientById(Integer id) { 
		  return projectRepository.findById(id).orElse(null); 
	}
	
	public void deleteById(Integer id) {
		projectRepository.deleteById(id);
	}
	
	public List<Projects> getAllPatients() { 
		  return projectRepository.findAll(); 
	}

	public List<Users> getFollowers(List<String> followers) {
		List<Users> listFollowers = new ArrayList<Users>();
		for (String follower : followers) {
			listFollowers.add(userService.getUserById(follower));
		}
		return listFollowers;
	}

	public List<Users> getParticipants(List<String> participants) {
		List<Users> listParticipants = new ArrayList<Users>();
		for (String participant : participants) {
			listParticipants.add(userService.getUserById(participant));
		}
		return listParticipants;
	}
}
