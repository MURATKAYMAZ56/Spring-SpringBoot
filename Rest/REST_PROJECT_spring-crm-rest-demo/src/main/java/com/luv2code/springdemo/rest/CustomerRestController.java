package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowired CustimerService to inject dependencies
	@Autowired
	private CustomerService customerService;

	// add Mapping

	@GetMapping("/customers")
	public List<Customer> getCustomers() {

		return customerService.getCustomers();

	}

	// add mapping to get customer
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {

		Customer theCustomer = customerService.getCustomer(customerId);
		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);

		}
		return theCustomer;

	}

	/// add mapping for POST/customers --- add new Customer

	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {

		// also just in case the pass id in JOSN ...set id=0
		// this is force a save

		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);

		return theCustomer;

	}

	// update Customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {

		customerService.saveCustomer(theCustomer);

		return theCustomer;

	}

	// Delete Customer

	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {

		Customer tempCustomer = customerService.getCustomer(customerId);
		
		if (tempCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);

		}
		
		customerService.deleteCustomer(customerId);
		
		return "Deleted customer id - " + customerId;

	}

}
