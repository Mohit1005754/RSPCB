package com.rspcb.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rspcb.project.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long>{
	

}
