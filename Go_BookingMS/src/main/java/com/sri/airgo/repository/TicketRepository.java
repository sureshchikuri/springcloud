package com.sri.airgo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sri.airgo.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Double> {

}
