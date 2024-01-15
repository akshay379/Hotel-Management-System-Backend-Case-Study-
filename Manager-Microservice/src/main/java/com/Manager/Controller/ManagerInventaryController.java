package com.Manager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Manager.Models.Inventary;
import com.Manager.Models.InventaryList;
import com.Manager.Models.Room;

//mark class as Controller
@RestController
@RequestMapping("/manager/inventary")
public class ManagerInventaryController {
	
	//Autowiring the rest Template
	@Autowired
	private RestTemplate restTemplate;
	
	
	//creating a get mapping that retrieves all the Inventory detail from the database 
	@GetMapping("/getAllInv")
	public InventaryList getInventary() 
	{
		return restTemplate.getForObject("http://Inventary-Microservice/Inventary/getAllInv/", InventaryList.class);
	}
	
	
	
	//creating a get mapping that retrieves the detail of a specific Inventory
	@GetMapping("/getByInv/{id}")
	public Inventary getInventary(@PathVariable("id") String id) 
	{
		return restTemplate.getForObject("http://Inventary-Microservice/Inventary/getByInv/"+id, Inventary.class);
	}
	
	
	
	//creating post mapping that post the Inventory detail in the database  
	@PostMapping("/addInv")
	public Inventary addInventary(@RequestBody Inventary inv) {
		return restTemplate.postForObject("http://Inventary-Microservice/Inventary/addInv/", inv, Inventary.class);
	}
	
	
	
	//creating put mapping that updates the Inventory detail 
	@PutMapping("/update/{id}")
	public void updateInventary(@RequestBody Inventary inv, @PathVariable long id)
	{
		restTemplate.put("http://Inventary-Microservice/Inventary/update/"+id,inv, Inventary.class);
		
	}
	
	
	
	
	
	
	//creating a delete mapping that deletes a specified Inventory
	@DeleteMapping("/deleteByInv/{id}")
	public String deleteInventary(@PathVariable("id") String id) {
		 restTemplate.delete("http://Inventary-Microservice/Inventary/deleteByInv/"+id);
		return "Deleted room "+id;
	}
	
	
	

}
