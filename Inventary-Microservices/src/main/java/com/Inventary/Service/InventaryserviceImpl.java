package com.Inventary.Service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Inventary.Models.Inventary;
import com.Inventary.Repository.InventaryRepo;


//defining the business logic
@Service
public class InventaryserviceImpl implements Inventaryservice {
	
	@Autowired
	InventaryRepo inventaryRepo;

	public InventaryserviceImpl(InventaryRepo repo) {
		this.inventaryRepo=repo;
	}
	
	

	//inserting a specific record 
	@Override
	public Inventary addInventary(Inventary inv) {
		// TODO Auto-generated method stub
		return inventaryRepo.insert(inv);
	}
	
	
	
	//getting all Inventory record by using the method findaAll() of MongoRepository  
	@Override
	public List<Inventary> getAllInventary() {
		// TODO Auto-generated method stub
		return inventaryRepo.findAll();
	}

	
	
	//getting a specific record by using the method findById() of  MongoRepository 
	@Override
	public Optional<Inventary> getInventary(long parseLong) {
		// TODO Auto-generated method stub
		return inventaryRepo.findById( parseLong);
	}
	
	
	
//	//saving a specific record by using the method save() of  MongoRepository  
//	@Override
//	public Inventary updateInventary(Inventary inv) {
//		// TODO Auto-generated method stub
//		return inventaryRepo.save(inv);
//	}
//	
	
	
	@Override
	public Inventary updateInventary(Inventary inv,long id) {
		inv.setInventaryId(id);
			return inventaryRepo.save(inv);
	}
	
	

	//deleting a specific record by using the method deleteById() of MongoRepository  
	@Override
	public String deleteInventary(long parseLong) {
		inventaryRepo.deleteById(parseLong);
		return "Deleted employee with ID :" + parseLong;
	}

	
}
