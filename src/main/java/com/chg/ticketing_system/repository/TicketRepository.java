package com.chg.ticketing_system.repository;

import com.chg.ticketing_system.entity.Ticket;  // FIX THIS IMPORT
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByStatus(String status);
}