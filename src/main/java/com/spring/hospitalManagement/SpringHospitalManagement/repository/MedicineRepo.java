package com.spring.hospitalManagement.SpringHospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.hospitalManagement.SpringHospitalManagement.model.Medicine;
@Repository
public interface MedicineRepo extends JpaRepository<Medicine, Integer> {

}
