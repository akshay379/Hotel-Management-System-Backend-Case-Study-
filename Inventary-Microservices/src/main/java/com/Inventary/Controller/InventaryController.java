package com.Inventary.Controller;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inventary.Models.Inventary;
import com.Inventary.Models.InventaryList;
import com.Inventary.Service.Inventaryservice;

//mark class as Controller  
@RestController
@RequestMapping("/Inventary")
public class InventaryController {
	
	//autowire the InventoryService class  
	@Autowired
	Inventaryservice inventaryService;
	
	
	//creating post mapping that post the Inventory detail in the database  
	@PostMapping("/addInv")
	public Inventary addInventary(@RequestBody Inventary inv)
	{
		return this.inventaryService.addInventary(inv);
	}
	
	//creating a get mapping that retrieves all the Inventory detail from the database
	@GetMapping("/getAllInv")
	public InventaryList getAllInventary(){
		InventaryList list=new InventaryList();
		list.setAllstaff(this.inventaryService.getAllInventary());
		return list;
	}
	
	
	//creating a get mapping that retrieves the detail of a specific inventory
	@GetMapping("/getByInv/{id}")
	public Optional<Inventary> getInventary(@PathVariable("id") String id)
	{
		return this.inventaryService.getInventary(Long.parseLong(id));
	}
	

	//creating put mapping that updates the Inventary detail   
	@PutMapping("/update/{id}")
	public void updateInventary(@RequestBody Inventary inv, @PathVariable long id) {
	
    inventaryService.updateInventary(inv,id);
	}
	
	
	//creating a delete mapping that deletes a specified Inventory
	@DeleteMapping("/deleteByInv/{id}")
	public String deleteInventary(@PathVariable("id") String id)
	{
		return this.inventaryService.deleteInventary(Long.parseLong(id));
	}
	
	
	

}
