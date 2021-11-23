package com.j2ee.tdspring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.j2ee.tdspring.entities.Exits;
import com.j2ee.tdspring.entities.Users;
import com.j2ee.tdspring.services.ExitService;
import com.j2ee.tdspring.services.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController 
public class ExitController {
	
	@Autowired
	 private ExitService exitService;
	@Autowired
	 private UserService userService; 
	
	@Operation(summary = "Créer une sortie") 
    @Valid
    @RequestMapping(path = "/add/exit", method = RequestMethod.POST) 
     public void addExit(@RequestBody Exits exitReceive) { 
      Exits exit = new Exits();       
      exit.setExitname(exitReceive.getExitname()); 
	  exit.setExitdescription(exitReceive.getExitdescription()); 
	  exit.setLocation(exitReceive.getLocation());
	  exit.setDuration(exitReceive.getDuration());
	  exit.setComplexity(exitReceive.getComplexity());
	  exit.setExitdate(exitReceive.getExitdate());
	  exit.setUsers(exitReceive.getUsers());
	  exitService.createOrUpdate(exit);
     }
	
	@Operation(summary = "Récupération d'une sortie par son id") 
	@RequestMapping(path = "/exit", method = RequestMethod.GET) 
	 public Exits getExitById(@RequestParam(value = "id") Integer id) { 
	  return exitService.getExitById(id); 
	 }
	
	 @Operation(summary = "Suppression d'une sortie à partir de son identifiant") 
	 @RequestMapping(path = "/exit", method = RequestMethod.DELETE) 
	 public void deleteUser(@RequestParam(value = "id") Integer id) { 
	   exitService.deleteById(id);
	 } 
	 
	 @Operation(summary = "Récupération de toutes les sorties") 
	 @RequestMapping(path = "/exits/all", method = RequestMethod.GET) 
	  public List<Exits> getExits() { 
		 return exitService.getAllExits();
	  }
	 
	 @Operation(summary = "Création ou mise à jour d'une sortie") 
	 @RequestMapping(path = "/exit", method = RequestMethod.PUT) 
	 public Exits addOrUpdateUser(@RequestBody Exits exit) {
		  return exitService.createOrUpdate(exit); 
	 }
	 
	 @Operation(summary = "Ajout d'un utilisateur à une sortie") 
	 @RequestMapping(path = "/add/user/exit", method = RequestMethod.GET) 
	 public Exits addUserToExit(@RequestParam(value = "exit_id") Integer id, @RequestParam(value = "username") String username) {
		 Exits exit = exitService.getExitById(id); 
		 Users user = userService.getUserById(username);
		 
		 exit.getUsers().add(user);
		 return exitService.createOrUpdate(exit);
	 }
	 
	 @Operation(summary = "Suppression d'un utilisateur d'une sortie") 
     @RequestMapping(path = "/user/exit", method = RequestMethod.DELETE) 
     public void deleteUserInExit(@RequestParam(value = "id") Integer id, @RequestParam(value = "username") String username) { 
         Exits exitById = exitService.getExitById(id);
        List<Users> listUsers = exitById.getUsers();
         for(Users user : listUsers) {
               if (user.getUsername().equals(username)) {
                   listUsers.remove(user);
                   exitService.createOrUpdate(exitById);
               }
            }
     }
	 
}