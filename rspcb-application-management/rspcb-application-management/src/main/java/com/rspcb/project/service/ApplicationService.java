package com.rspcb.project.service;

import java.time.LocalDate;
import java.util.List;

import com.rspcb.project.dto.ApplicationCreateDto;
import com.rspcb.project.dto.ApplicationResponseDto;

public interface ApplicationService {
	public ApplicationResponseDto createApplication(ApplicationCreateDto dto);
	public List<ApplicationResponseDto>searchApplication(
			String roHo,
            String industryType,
            String applicationType,
            String applicationFor,
            LocalDate fromDate,
            LocalDate toDate,
            int page,
            int size,
            String sortBy,
            String sortDir
    );
	
		
	}


