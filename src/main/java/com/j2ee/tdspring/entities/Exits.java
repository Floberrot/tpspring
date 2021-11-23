package com.j2ee.tdspring.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Exits")
public class Exits {

     	@Id
        @Column(name="id")
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer id;

		@Column(name="exitname", nullable=false)
		@NotNull
        private String exitname;

        @Column(name="exitdescription", nullable=false)
        private String exitdescription;
        
        @Column(name="exitdate", nullable=false)
        @NotNull
        private Date exitdate;
        
        @Column(name="duration", nullable=false)
        private int duration;
        
        @Column(name="complexity", nullable=false)
        private int complexity;
        
        @Column(name="location", nullable=false)
        private String location;
        
        @ManyToMany
        @JoinTable(name="users_exits",joinColumns=@JoinColumn(name = "exits_id"),inverseJoinColumns=@JoinColumn(name = "users_id"))
        private List<Users> users;
       

		public String getExitname() {
			return exitname;
		}

		public void setExitname(String exitname) {
			this.exitname = exitname;
		}

		public String getExitdescription() {
			return exitdescription;
		}

		public void setExitdescription(String exitdescription) {
			this.exitdescription = exitdescription;
		}

		public Date getExitdate() {
			return exitdate;
		}

		public void setExitdate(Date exitdate) {
			this.exitdate = exitdate;
		}

		public int getDuration() {
			return duration;
		}

		public void setDuration(int duration) {
			this.duration = duration;
		}

		public int getComplexity() {
			return complexity;
		}

		public void setComplexity(int complexity) {
			this.complexity = complexity;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public List<Users> getUsers() {
			return users;
		}

		public void setUsers(List<Users> users) {
			this.users = users;
		}  
}