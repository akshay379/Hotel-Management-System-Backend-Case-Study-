package com.Staff.Service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Staff.Models.Staff;
import com.Staff.Repository.StaffMongodbRepo;



//defining the business logic
@Service
public class StaffserviceImpl implements Staffservice{
	
	
	@Autowired
	StaffMongodbRepo staffmongodbRepo;


	public StaffserviceImpl(StaffMongodbRepo repo) {
	   this.staffmongodbRepo= repo;
	}

	//inserting a specific record 
	@Override
	public Staff addEmp(Staff emp) {
		
		return staffmongodbRepo.insert(emp);
	}

	
	//getting all Staff record by using the method findaAll() of MongoRepository  
	@Override
	public List<Staff> getAllEmp() {
		
		return staffmongodbRepo.findAll();
	}

	
	@Override//getting a specific record by using the method findById() of  MongoRepository  
	public Optional<Staff> getEmp(long parseLong) {
		
		return staffmongodbRepo.findById(parseLong);
	}

	//saving a specific record by using the method save() of  MongoRepository








	//deleting a specific record by using the method deleteById() of MongoRepository  
	@Override
	public String deleteEmp(long parseLong) {
		staffmongodbRepo.deleteById(parseLong);
		return "Deleted employee with ID :" + parseLong;
	}

	@Override
	public void updateEmp(Staff emp, long id) {
		emp.setEmpId(id);
		return;
	}

}
