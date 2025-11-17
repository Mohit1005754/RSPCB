package com.rspcb.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rspcb.project.entity.DropdownMaster;

public interface DropdownMasterRepository extends JpaRepository<DropdownMaster, Long> {
	List<DropdownMaster> findByType(String type);

}
