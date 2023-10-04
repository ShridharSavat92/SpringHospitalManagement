package com.spring.hospitalManagement.SpringHospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.hospitalManagement.SpringHospitalManagement.model.Patient;
@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {

}
