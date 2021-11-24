package com.j2ee.tdspring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.j2ee.tdspring.entities.Patients;
import com.j2ee.tdspring.entities.Users;
import com.j2ee.tdspring.services.PatientService;

import io.swagger.v3.oas.annotations.Operation;

@RestController 
public class PatientController {
	@Autowired 
	 private PatientService patientService;
	
	@Operation(summary = "Créer un patient") 
    @Valid
    @RequestMapping(path = "/add/patient", method = RequestMethod.POST) 
     public void addUser(@RequestBody Users userReceive) { 
      Patients patient = new Patients(); 
      patient.setFirstname(userReceive.getFirstname()); 
      patient.setLastname(userReceive.getLastname()); 
      patient.setTelephone(userReceive.getTelephone());
      
      patientService.createOrUpdate(patient); 
     }
	
	@Operation(summary = "Récupération d'un patient par son id") 
	@RequestMapping(path = "/patient", method = RequestMethod.GET) 
	 public Patients getPatient(@RequestParam(value = "id") int id) { 
	  return patientService.getPatientById(id); 
	 }
	
	 @Operation(summary = "Suppression d'un patient à partir de son identifiant") 
	 @RequestMapping(path = "/patient", method = RequestMethod.DELETE) 
	 public void deletePatient(@RequestParam(value = "id") int id) { 
		 patientService.deleteById(id);
	 } 
	 
	 @Operation(summary = "Récupération de tous les patients") 
	 @RequestMapping(path = "/patient/all", method = RequestMethod.GET) 
	  public List<Patients> getPatients() { 
		 return patientService.getAllPatients();
	  }
	 
	 @Operation(summary = "Création ou mise à jour d'un patient") 
	 @RequestMapping(path = "/patient", method = RequestMethod.PUT)
	 @Valid
	 public Patients addOrUpdatePatient(@RequestBody Patients patient) {
		  return patientService.createOrUpdate(patient); 
	 }
}