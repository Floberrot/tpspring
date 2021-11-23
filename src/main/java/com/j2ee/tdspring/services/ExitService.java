package com.j2ee.tdspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j2ee.tdspring.entities.Exits;
import com.j2ee.tdspring.repositories.ExitRepository;

@Service
public class ExitService {
	
	@Autowired 
	 private ExitRepository exitRepository; 

	
	public Exits createOrUpdate(Exits exit) { 
		  return exitRepository.save(exit); 
	} 
		 
	public Exits getExitById(Integer id) { 
		  return exitRepository.findById(id).orElse(null); 
	}
	
	public void deleteById(Integer id) {
		exitRepository.deleteById(id);
	}
	
	public List<Exits> getAllExits() { 
		  return exitRepository.findAll(); 
	}

	
}