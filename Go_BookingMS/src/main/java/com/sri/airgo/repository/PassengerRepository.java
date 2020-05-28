package com.sri.airgo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sri.airgo.entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
