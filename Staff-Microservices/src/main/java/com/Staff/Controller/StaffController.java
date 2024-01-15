package com.Staff.Controller;


import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Staff.Models.Staff;
import com.Staff.Models.StaffList;
import com.Staff.Service.Staffservice;


//mark class as Controller  
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/staff")
public class StaffController {
		
	//autowire the StaffService class  
	@Autowired
	Staffservice staffService;
	
	
	
	//creating post mapping that post the Staff detail in the database 
	@PostMapping("/addEmp")
	public Staff addEmployee(@RequestBody Staff emp)
	{
		return this.staffService.addEmp(emp);
	}
	
	
	@GetMapping("/getAllEmp")
	public StaffList getAllEmployee(){
		StaffList list=new StaffList();
		list.setAllEmp(this.staffService.getAllEmp());
		return list;
	}
	
	
	
	
	//creating a get mapping that retrieves all the Staff detail from the database 
	@GetMapping("/getByEmp/{id}")
	public Optional<Staff> getEmployee(@PathVariable("id") String id)
	{
		return this.staffService.getEmp(Long.parseLong(id));
	}
	
	
	
	
	//creating put mapping that updates the Staff detail

	
	
	@PutMapping("/update/{id}")
	public void updateEmployee(@RequestBody Staff emp, @PathVariable long id) {
	
		 staffService.updateEmp(emp,id);
	}

	
	
	
	
	
	
	//creating a delete mapping that deletes a specified Staff 
	@DeleteMapping("/deleteByEmp/{id}")
	public String deleteEmployee(@PathVariable("id") String id)
	{
		return this.staffService.deleteEmp(Long.parseLong(id));
	}
	
	
	
	
	

}
