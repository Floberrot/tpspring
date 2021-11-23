package com.j2ee.tdspring.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Users")
public class Users {

     	@Id
        @Column(name="username")
     	@NotNull
        private String username;

        @Column(name="firstname", length=30, nullable=false)
        @NotNull
        private String firstname;

        @Column(name="lastname",length=30, nullable=false)
        @NotNull
        private String lastname;
        
        @Column(name="telephone",length=30, nullable=false)
        private int telephone;
        
        @Column(name="role", length=30, nullable=false)
        @NotNull
        private String role;
        
        @Column(name="password", length=30, nullable=false)
        @NotNull
        @JsonIgnore
        private String password;
        
        @ManyToMany(mappedBy="followers")
        @JsonIgnore
        private List<Projects> project_follower;
        
        @ManyToMany(mappedBy="participants")
        @JsonIgnore
        private List<Projects> project_participants;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public int getTelephone() {
			return telephone;
		}

		public void setTelephone(int telephone) {
			this.telephone = telephone;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public List<Projects> getProject_follower() {
			return project_follower;
		}

		public void setProject_follower(List<Projects> project_follower) {
			this.project_follower = project_follower;
		}

		public List<Projects> getProject_participants() {
			return project_participants;
		}

		public void setProject_participants(List<Projects> project_participants) {
			this.project_participants = project_participants;
		}
        
       
}