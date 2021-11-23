package com.j2ee.tdspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j2ee.tdspring.entities.Patients;
import com.j2ee.tdspring.repositories.PatientRepository;

@Service
public class PatientService {
	
	@Autowired 
	 private PatientRepository patientRepository; 

	
	public Patients createOrUpdate(Patients patient) { 
		  return patientRepository.save(patient); 
	} 
		 
	public Patients getPatientById(Integer id) { 
		  return patientRepository.findById(id).orElse(null); 
	}
	
	public void deleteById(Integer id) {
		patientRepository.deleteById(id);
	}
	
	public List<Patients> getAllPatients() { 
		  return patientRepository.findAll(); 
	}

	
}