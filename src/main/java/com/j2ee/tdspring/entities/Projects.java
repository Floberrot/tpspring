package com.j2ee.tdspring.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Projects")
public class Projects {
	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

	@Column(name="name", nullable=false)
    @NotNull
    private String name;

	@ManyToOne(optional = false)
	@JoinColumn(name="username", nullable=false)
    @NotNull
    private Users author;

    @Column(name="description", nullable=false)
    @NotNull
    private String description;
    
    @Column(name="created_at", nullable=false)
    @NotNull
    private Date created_at;
    
    @Column(name="closed_at", nullable=false)
    private Date closed_at;
    
    @Column(name="wishing_patient", nullable=false)
    private int wishing_patient;
    
    @Column(name="number_patient", nullable=false)
    private int number_patient;
        
    @OneToMany(mappedBy = "project")
    private List<Messages> messages;
    
    @OneToMany(mappedBy = "project")
    private List<Keywords> keywords;
    
    @ManyToMany
    @JoinTable(name="participants",joinColumns=@JoinColumn(name = "project_id"),inverseJoinColumns=@JoinColumn(name = "users_id"))
    private List<Users> participants;
    
    @ManyToMany
    @JoinTable(name="followers",joinColumns=@JoinColumn(name = "project_id"),inverseJoinColumns=@JoinColumn(name = "users_id"))
    private List<Users> followers;

	@ManyToMany
    @JoinTable(name="requests",joinColumns=@JoinColumn(name = "project_id"),inverseJoinColumns=@JoinColumn(name = "users_id"))
    private List<Users> requests;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getClosed_at() {
		return closed_at;
	}

	public void setClosed_at(Date closed_at) {
		this.closed_at = closed_at;
	}

	public int getWishing_patient() {
		return wishing_patient;
	}

	public void setWishing_patient(int wishing_patient) {
		this.wishing_patient = wishing_patient;
	}

	public int getNumber_patient() {
		return number_patient;
	}

	public void setNumber_patient(int number_patient) {
		this.number_patient = number_patient;
	}

	public List<Messages> getMessages() {
		return messages;
	}

	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}

	public List<Keywords> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<Keywords> keywords) {
		this.keywords = keywords;
	}

	public List<Users> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Users> participants) {
		this.participants = participants;
	}

	public List<Users> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Users> followers) {
		this.followers = followers;
	}

	public Users getAuthor() {
		return author;
	}

	public void setAuthor(Users author) {
		this.author = author;
	}

	public List<Users> getRequests() {
		return requests;
	}

	public void setRequests(List<Users> requests) {
		this.requests = requests;
	}
}
