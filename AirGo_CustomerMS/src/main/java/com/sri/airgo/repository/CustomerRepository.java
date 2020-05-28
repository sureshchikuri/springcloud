package com.sri.airgo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.airgo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
