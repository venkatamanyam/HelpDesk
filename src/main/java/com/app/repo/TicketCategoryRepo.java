package com.app.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.TicketCategory;

public interface TicketCategoryRepo extends JpaRepository<TicketCategory, Integer>{
	
	
	

}
