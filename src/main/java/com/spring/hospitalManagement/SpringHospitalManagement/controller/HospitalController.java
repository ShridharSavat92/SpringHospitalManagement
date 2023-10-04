package com.spring.hospitalManagement.SpringHospitalManagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.hospitalManagement.SpringHospitalManagement.model.Hospital;
import com.spring.hospitalManagement.SpringHospitalManagement.service.HospitalService;

@RestController
public class HospitalController {
	@Autowired
	HospitalService hospitalService;
	
	@PostMapping("/SaveHospital")
	public Hospital saveHospitalInfo(@RequestBody Hospital hospital) {
		return hospitalService.saveHospital(hospital);
	}
	
	@GetMapping("/GetHospitalInfo")
	public Optional<Hospital> getHospitalRecords(@RequestParam int id) {
		return hospitalService.getHospital(id);
	}
	
	@DeleteMapping("/DeleteHospital")
	public String deleteHospital(@RequestParam int id) {
		Optional<Hospital> hospitalRes=hospitalService.getHospital(id);
		if( hospitalRes.isPresent()) {
			hospitalService.deleteHospital(id);
			return "Hospital Records successfully deleted";
		}else {
			return "Hospital record not found";
		}
	}
	
	@PutMapping("/UpdateHospital")
	public Hospital updateHospitalInfo(@RequestBody Hospital hospital) {
		return saveHospitalInfo(hospital);
	}

}
