package com.rspcb.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rspcb.project.service.DropdownMasterService;

@RestController
@RequestMapping("/api/dropdowns")
@CrossOrigin(origins = "http://localhost:4200")
public class DropdownMasterController {
	@Autowired
	private DropdownMasterService service;
	@GetMapping("/{type}")
	public List<String>getDropdownValues(@PathVariable String type ){
		return service.getValuesByType(type.toUpperCase());
		
	}
	
	
	

}
