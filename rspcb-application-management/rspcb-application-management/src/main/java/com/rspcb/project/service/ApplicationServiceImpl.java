package com.rspcb.project.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import com.rspcb.project.dto.ApplicationCreateDto;
import com.rspcb.project.dto.ApplicationResponseDto;
import com.rspcb.project.entity.Application;
import com.rspcb.project.repository.ApplicationRepository;
@Service
public class ApplicationServiceImpl implements ApplicationService {
	
	@Autowired
	public ApplicationRepository appRepo;

	@Override
	public ApplicationResponseDto createApplication(ApplicationCreateDto dto) {
		Application app = new Application();
		app.setRoho(dto.getRoho());
		app.setIndustryType(dto.getIndustryType());
		app.setApplicationType(dto.getApplicationType());
		app.setApplicationFor(dto.getApplicationFor());
		//app.setIndustryType(dto.getIndustryType());
		app.setCreatedDate(LocalDate.now());
		Application saved = appRepo.save(app);
		
		ApplicationResponseDto dt = new ApplicationResponseDto();
		dt.setId(saved.getId());
		dt.setRoho(saved.getRoho());
		dt.setIndustryType(saved.getIndustryType());
		dt.setApplicationType(saved.getApplicationType());
		dt.setCreateDate(LocalDate.now());
		dt.setApplicationFor(saved.getApplicationFor());
		
		
		// TODO Auto-generated method stub
		return dt;
	}

//	@Override
//	public List<ApplicationResponseDto> searchApplication(String roho, String industryType, String applicationType,
//			String applicationFor, LocalDate fromDate, LocalDate toDate, int page, int size, String sortBy, String sortDir) {
	@Override
	public List<ApplicationResponseDto> searchApplication(String roHo, String industryType,
			String applicationType, String applicationFor, LocalDate fromDate, LocalDate toDate, int page,
			int size, String sortBy, String sortDir) {
		// sorting setup
		Sort sort = sortDir.equalsIgnoreCase("desc")
				? Sort.by(sortBy).descending():Sort.by(sortBy).ascending();
		// pageination
		
		Pageable pageable = PageRequest.of(page, size, sort);
		
		 // ✅ Pagination data fetch (all records page-wise)
		
		Page<Application> list = appRepo.findAll(pageable);
		//List<Application> list = appRepo.findAll();
//		return list.stream().filter(
//				a -> roho == null || a.getRoho().equalsIgnoreCase(roho)).filter(
//						a -> industryType == null || a.getIndustryType().equalsIgnoreCase(industryType)).filter(
//				a -> applicationType == null || a.getApplicationType().equalsIgnoreCase(applicationType)).filter(
//						a -> applicationFor == null || a.getApplicationType().equalsIgnoreCase(applicationFor)).filter(
//								a -> fromDate == null || a.getCreatedDate().isBefore(fromDate)).filter(
//										a -> toDate == null || a.getCreatedDate().isAfter(toDate)).map(a ->{
//											ApplicationResponseDto dto = new ApplicationResponseDto();
//											dto.setId(a.getId());
//											dto.setRoho(a.getRoho());
//											dto.setIndustryType(a.getIndustryType());
//											dto.setApplicationType(a.getApplicationType());
//											dto.setApplicationFor(a.getApplicationFor());
//											dto.setCreateDate(a.getCreatedDate());
//											return dto;
//										}).collect(Collectors.toList());
		return list.stream()
			    .filter(a -> roHo == null || (a.getRoho() != null && a.getRoho().equalsIgnoreCase(roHo)))
			    .filter(a -> industryType == null || (a.getIndustryType() != null && a.getIndustryType().equalsIgnoreCase(industryType)))
			    .filter(a -> applicationType == null || (a.getApplicationType() != null && a.getApplicationType().equalsIgnoreCase(applicationType)))
			    .filter(a -> applicationFor == null || (a.getApplicationFor() != null && a.getApplicationFor().equalsIgnoreCase(applicationFor)))
			    .filter(a -> fromDate == null || (a.getCreatedDate() != null && !a.getCreatedDate().isBefore(fromDate)))
			    .filter(a -> toDate == null || (a.getCreatedDate() != null && !a.getCreatedDate().isAfter(toDate))).map(a ->{
					ApplicationResponseDto dto = new ApplicationResponseDto();
					dto.setId(a.getId());
					dto.setRoho(a.getRoho());
					dto.setIndustryType(a.getIndustryType());
					dto.setApplicationType(a.getApplicationType());
					dto.setApplicationFor(a.getApplicationFor());
					dto.setCreateDate(a.getCreatedDate());
					return dto;
				
				
					// TODO Auto-generated method stub
					//return null;
				}).collect(Collectors.toList());
	
		
		
		
		
	}

}
