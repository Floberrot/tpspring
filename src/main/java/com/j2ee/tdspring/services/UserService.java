package com.j2ee.tdspring.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.j2ee.tdspring.entities.Users;
import com.j2ee.tdspring.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired 
	 private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Users createOrUpdate(Users user) { 
		  return userRepository.save(user); 
	} 
		 
	public Users getUserById(String username) { 
		  return userRepository.findById(username).orElse(null); 
	}
	
	public void deleteById(String username) {
		userRepository.deleteById(username);
	}
	
	public List<Users> getAllUsers() { 
		  return userRepository.findAll(); 
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findById(username).orElse(null);
		
		if (user != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
		}
		throw new UsernameNotFoundException("User '" + username + "' not foundor inactive");
	}
	
	public void setPassword(String userName, String oldPassword, String newPassword) throws IllegalAccessException {
		Users user = userRepository.findById(userName).orElse(null);
		
		if (user != null) {
			String encodedOldPassword = passwordEncoder.encode(oldPassword);
			String encodedNewPassword = passwordEncoder.encode(newPassword);
			
			if (StringUtils.isEmpty(user.getPassword()) || StringUtils.equals(user.getPassword(), encodedOldPassword)) {
				user.setPassword(encodedNewPassword);
				userRepository.save(user);
			} else {
				throw new IllegalAccessException("Invalid old password");
			}
		}
	}
}
