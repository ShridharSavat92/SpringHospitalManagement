package com.spring.hospitalManagement.SpringHospitalManagement.service;

import java.util.List;
import java.util.Optional;

import com.spring.hospitalManagement.SpringHospitalManagement.model.Hospital;

public interface HospitalService {
	public Hospital saveHospital(Hospital hospital);
	public Optional<Hospital> getHospital(int id);
	public void deleteHospital(int id);
	public Hospital updateHospital(Hospital hospital);

}
