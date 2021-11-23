package com.j2ee.tdspring.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Patients")
public class Projects {
	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name="name", nullable=false)
    @NotNull
    private String name;
	
	@Column(name="author", nullable=false)
    @NotNull
    private String author;

    @Column(name="description", nullable=false)
    @NotNull
    private String description;
    
    @Column(name="created_at", nullable=false)
    @NotNull
    private Date created_at;
    
    @Column(name="closed_at", nullable=false)
    @NotNull
    private Date closed_at;
    
    @Column(name="wishing_patient", nullable=false)
    private int wishing_patient;
    
    @Column(name="number_patient", nullable=false)
    private int number_patient;
    
    @Column(name="messages", nullable=false)
    private int messages;
    
    @Column(name="keywords", nullable=false)
    private int keywords;
    
    @Column(name="query", nullable=false)
    private int query;
    
    @Column(name="users", nullable=false)
    private int users;
    
    @Column(name="followers", nullable=false)
    private int followers;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	public int getMessages() {
		return messages;
	}

	public void setMessages(int messages) {
		this.messages = messages;
	}

	public int getKeywords() {
		return keywords;
	}

	public void setKeywords(int keywords) {
		this.keywords = keywords;
	}

	public int getQuery() {
		return query;
	}

	public void setQuery(int query) {
		this.query = query;
	}

	public int getUsers() {
		return users;
	}

	public void setUsers(int users) {
		this.users = users;
	}

	public int getFollowers() {
		return followers;
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}
}
