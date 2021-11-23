package com.j2ee.tdspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j2ee.tdspring.entities.Projects;
import com.j2ee.tdspring.repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired 
	 private ProjectRepository projectRepository; 

	
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
}
