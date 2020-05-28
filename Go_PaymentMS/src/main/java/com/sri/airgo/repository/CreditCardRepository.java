package com.sri.airgo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.airgo.entity.CreditCardDetails;

public interface CreditCardRepository extends JpaRepository<CreditCardDetails, String>{

}
