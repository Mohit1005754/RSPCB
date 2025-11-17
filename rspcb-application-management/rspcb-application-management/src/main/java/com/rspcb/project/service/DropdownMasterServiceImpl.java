package com.rspcb.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rspcb.project.repository.DropdownMasterRepository;
@Service
public class DropdownMasterServiceImpl implements DropdownMasterService {
	@Autowired
	private DropdownMasterRepository DropdownRepo;

	@Override
	public List<String> getValuesByType(String type) {
		
		return DropdownRepo.findByType(type).stream().map(d -> d.getValue()).toList();
	}

}
