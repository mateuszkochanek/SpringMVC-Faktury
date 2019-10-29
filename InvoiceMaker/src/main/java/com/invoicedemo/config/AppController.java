package com.invoicedemo.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
	
	@RequestMapping("/showcustomers")
	public String showCustomersPage() {
		return "show-customers";
	}
	
	@RequestMapping("/addcustomer")
	public String showAddCustomerPage() {
		return "add-customer";
	}
}
