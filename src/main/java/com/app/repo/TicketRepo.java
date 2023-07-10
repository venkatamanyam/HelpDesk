package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.TicketInfo;

public interface TicketRepo extends JpaRepository<TicketInfo, Integer> {

	TicketInfo findByticketId(Integer id);

}
