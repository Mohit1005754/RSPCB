package com.rspcb.project.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rspcb.project.dto.ApplicationCreateDto;
import com.rspcb.project.dto.ApplicationResponseDto;
import com.rspcb.project.service.ApplicationService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
	@Autowired
	public ApplicationService AppService;
	
	@PostMapping("/create")
		public ResponseEntity<ApplicationResponseDto> createApplication(@RequestBody ApplicationCreateDto dto){
		
			return ResponseEntity.ok(AppService.createApplication(dto));
		}

@GetMapping("/search")
public ResponseEntity<List<ApplicationResponseDto>> searchApplication(
		@RequestParam(required = false) String roho,
		@RequestParam(required = false) String industryType,
		@RequestParam(required = false) String applicationType,
		@RequestParam(required = false) String applicationFor,
		@RequestParam(required = false) LocalDate fromDate,
		@RequestParam(required = false) LocalDate toDate,
		@RequestParam(defaultValue = "0") int page,
		@RequestParam(defaultValue = "0") int size,
		@RequestParam(defaultValue = "createdDate") String sortBy,
		@RequestParam(defaultValue = "desc") String sortDir){
			
	
	return ResponseEntity.ok(AppService.searchApplication(roho, industryType, applicationType, applicationFor, fromDate, toDate,page,size,sortBy,sortDir));
	
	
	
}
}
	
	


