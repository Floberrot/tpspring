package com.j2ee.tdspring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.j2ee.tdspring.entities.Users;
import com.j2ee.tdspring.services.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController 
public class UserController {
	@Autowired 
	 private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Operation(summary = "Créer un utilisateur") 
    @Valid
    @RequestMapping(path = "/add-test-user", method = RequestMethod.POST) 
     public void addUser(@RequestBody Users userReceive) { 
      Users user = new Users(); 
      user.setUsername(userReceive.getUsername()); 
      user.setFirstname(userReceive.getFirstname()); 
      user.setLastname(userReceive.getLastname()); 
      user.setTelephone(userReceive.getTelephone());
      user.setRole(userReceive.getRole());
      if (StringUtils.isNotEmpty(user.getPassword())) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
      }
      userService.createOrUpdate(user); 
     }
	
	@Operation(summary = "Récupération d'un utilisateur par son id") 
	@RequestMapping(path = "/user", method = RequestMethod.GET) 
	 public Users getUser(@RequestParam(value = "id") String username) { 
	  return userService.getUserById(username); 
	 }
	
	 @Operation(summary = "Suppression d'un utilisateur à partir de son identifiant") 
	 @RequestMapping(path = "/user", method = RequestMethod.DELETE) 
	 public void deleteUser(@RequestParam(value = "id") String username) { 
	   userService.deleteById(username);
	 } 
	 
	 @Operation(summary = "Récupération de tous les utilisateurs") 
	 @RequestMapping(path = "/users/all", method = RequestMethod.GET) 
	  public List<Users> getUsers() { 
		 return userService.getAllUsers();
	  }
	 
	 @Operation(summary = "Création ou mise à jour d'un utilisateur") 
	 @RequestMapping(path = "/user", method = RequestMethod.PUT)
	 @Valid
	 public Users addOrUpdateUser(@RequestBody Users user) {
		  return userService.createOrUpdate(user); 
	 }
	 
	 @Operation(summary = "Mise à jour du mot de passe d'un utilisateur")
	 @RequestMapping(path = "/user/updatePassword", method = RequestMethod.POST)
	 public void setPassword(@RequestParam(value = "userName") String userName, @RequestParam(value = "old") String oldPassword, @RequestParam(value = "new") String newPassword) throws IllegalAccessException {
		 userService.setPassword(userName, oldPassword, newPassword);
	 }
}