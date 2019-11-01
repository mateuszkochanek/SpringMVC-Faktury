package com.invoicedemo.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.invoicedemo.dao.interfaces.CustomerDAO;
import com.invoicedemo.dao.interfaces.ProductDAO;
import com.invoicedemo.entity.Customer;
import com.invoicedemo.entity.Product;

@Controller
public class AppController {
	
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private ProductDAO productDAO;
	
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
	//change to product
	@RequestMapping("/addproduct")
	public String showProductsPage(Model theModel) {
		
		Product theProduct = new Product();
		theModel.addAttribute("product",theProduct);
		
		return "add-product";
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

	@PostMapping("/saveproduct")
	public String saveProduct(@ModelAttribute("product") Product theProduct) {
		productDAO.saveProducts(theProduct);
		return "redirect:/";
	}
}
