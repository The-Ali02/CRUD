package com.example.demo.controller;

import java.util.*;
import javax.validation.*;

import com.example.demo.model.Load;
import com.example.demo.repository.LoadsRepository;
import com.example.demo.exception.ResourceNotFoundException;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1")
public class MyController {

	@Autowired
	private LoadsRepository loadsRepository;
	
	@GetMapping("/load")
	public List<Load> getAllLoads(){
		return this.loadsRepository.findAll();
	}
	@GetMapping("/load/{loadId}")
	public ResponseEntity<Load> getLoadById(@PathVariable(value = "loadId") Long loadId) 
			throws ResourceNotFoundException {
		Load load = loadsRepository.findById(loadId)
				.orElseThrow(() -> new ResourceNotFoundException("Load record not found for this id ::" + loadId));
		return ResponseEntity.ok().body(load);
	}
	
	@PostMapping("/load")
	public Load createLoad(@RequestBody Load load) {
		return this.loadsRepository.save(load);
	}
	
	@PutMapping("/load/{loadId}")
	public ResponseEntity<Load> updateLoad(@PathVariable(value = "loadId") Long loadId,
			@Valid @RequestBody Load loadDetails) throws ResourceNotFoundException{
		Load load = loadsRepository.findById(loadId)
				.orElseThrow(() -> new ResourceNotFoundException("Load record not found for this id ::" + loadId));
		
		load.setLoadingPoint(loadDetails.getLoadingPoint());
		load.setUnloadingPoint(loadDetails.getUnloadingPoint());
		load.setProductType(loadDetails.getProductType());
		load.setTruckType(loadDetails.getTruckType());
		load.setNoOfTrucks(loadDetails.getNoOfTrucks());
		load.setWeight(loadDetails.getWeight());
		load.setComment("");
		//load.setComment(loadDetails.getComment());
		load.setDate(loadDetails.getDate());
		
		final Load updatedLoad= loadsRepository.save(load);
		return ResponseEntity.ok(updatedLoad);
		
	}
	@DeleteMapping("/load/{loadId}")
	public Map<String, Boolean> deleteLoad(@PathVariable(value = "loadId") Long loadId)
			throws ResourceNotFoundException {
		Load load= loadsRepository.findById(loadId)
				.orElseThrow(() -> new ResourceNotFoundException("Load record not found for this id :: " + loadId));

		loadsRepository.delete(load);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;
	}	
}
