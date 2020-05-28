package com.sri.airgo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.airgo.entity.Customer;
import com.sri.airgo.exception.AirGoServiceException;
import com.sri.airgo.repository.CustomerRepository;

/**
 * The Class AadharService.
 */
@Service
public class RegistrationService {

	@Autowired
	private CustomerRepository customerRepository;

	public Boolean insertUser(Customer customer) throws AirGoServiceException {

		Customer cust = customerRepository.saveAndFlush(customer);

		if (cust == null) {
			throw new AirGoServiceException("User record not found");
		} else {
			return true;
		}

	}

}
