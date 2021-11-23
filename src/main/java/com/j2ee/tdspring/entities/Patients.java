package com.j2ee.tdspring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Patients")
public class Patients {

	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name="firstname", length=30, nullable=false)
    @NotNull
    private String firstname;

    @Column(name="lastname",length=30, nullable=false)
    @NotNull
    private String lastname;
    
    @Column(name="telephone",length=30, nullable=false)
    private int telephone;
    
    /*
    @ManyToMany(mappedBy="users")
    @JsonIgnore
    private List<Exits> exits;

    public List<Exits> getExits() {
		return exits;
	}
	
	public void setExits(List<Exits> users) {
		this.exits = users;
	}
	*/

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

}