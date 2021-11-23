package com.j2ee.tdspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.j2ee.tdspring.entities.Patients;

@Repository 
public interface PatientRepository extends JpaRepository<Patients, Integer> { 
 
}