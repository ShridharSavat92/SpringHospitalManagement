package com.spring.hospitalManagement.SpringHospitalManagement.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hospitalManagement.SpringHospitalManagement.model.Address;
import com.spring.hospitalManagement.SpringHospitalManagement.model.Branch;
import com.spring.hospitalManagement.SpringHospitalManagement.model.Hospital;
import com.spring.hospitalManagement.SpringHospitalManagement.model.Medicine;
import com.spring.hospitalManagement.SpringHospitalManagement.model.Patient;
import com.spring.hospitalManagement.SpringHospitalManagement.repository.AddressRepo;
import com.spring.hospitalManagement.SpringHospitalManagement.repository.BranchRepo;
import com.spring.hospitalManagement.SpringHospitalManagement.repository.HospitalRepo;
import com.spring.hospitalManagement.SpringHospitalManagement.repository.MedicineRepo;
import com.spring.hospitalManagement.SpringHospitalManagement.repository.PatientRepo;
import com.spring.hospitalManagement.SpringHospitalManagement.service.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService {
	@Autowired
	HospitalRepo hospitalRepo;
	
	@Autowired
	BranchRepo branchRepo;
	
	@Autowired
	PatientRepo patientRepo;
	
	@Autowired
	AddressRepo addressRepo;
	
	@Autowired
	MedicineRepo medicineRepo;
	
	public Hospital saveHospital(Hospital hospital) {
		List<Branch> listOfBranches=hospital.getBranches();
		List<Branch> resultBranch=new ArrayList<Branch>();
		
		if(listOfBranches.isEmpty()) {
			hospital=hospitalRepo.save(hospital);
		}else {
			hospital=hospitalRepo.save(hospital);
			for(Branch branch:listOfBranches) {
				branch.setHospital(hospital);
				resultBranch.add(branchRepo.save(branch));
				
				List<Patient> listOfPatients=branch.getPatients();
				List<Patient> resultPatient=new ArrayList<Patient>();
				Address address=branch.getAddress();
				if(address!=null) {
					
					addressRepo.save(address);
				}
				
				if(listOfPatients.isEmpty()) {
					branch=branchRepo.save(branch);
				}else
				{
					branch=branchRepo.save(branch);
					for(Patient patient:listOfPatients){
						patient.setBranch(branch);
						patientRepo.save(patient);
						
						Medicine medicine= patient.getMedicine();
						if(medicine!=null) {
							medicineRepo.save(medicine);
						}
					}
					
					branch.setPatients(resultPatient);
				
				}
			}
			hospital.setBranches(resultBranch);
		}
		
		return hospital;
	}
	
	public Optional<Hospital> getHospital(int id){
		return hospitalRepo.findById(id);
	}
	
	public Hospital updateHospital(Hospital hospital) {
		return saveHospital(hospital);
	}
	
	public void deleteHospital(int id) {
		hospitalRepo.deleteById(id);
	}

	
}
