package com.invoicedemo.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.invoicedemo.dao.interfaces.CustomerDAO;
import com.invoicedemo.entity.Customer;

@Controller
public class AppController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
	
	@RequestMapping("/showcustomers")
	public String showCustomersPage(Model theModel) {
		
		ArrayList<Customer> theCustomers = customerDAO.getCustomers();
		
		theModel.addAttribute("customers", theCustomers);
		
		return "show-customers";
	}
	
	@RequestMapping("/addcustomer")
	public String showAddCustomerPage(Model theModel) {
		
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer",theCustomer);
		
		return "add-customer";
	}
	
	@PostMapping("/savecustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerDAO.saveCustomers(theCustomer);
		return "redirect:/";
	}
}
