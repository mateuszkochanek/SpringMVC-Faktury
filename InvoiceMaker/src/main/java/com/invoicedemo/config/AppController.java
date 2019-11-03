package com.invoicedemo.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.invoicedemo.dao.interfaces.CustomerDAO;
import com.invoicedemo.dao.interfaces.InvoiceDAO;
import com.invoicedemo.dao.interfaces.ProductDAO;
import com.invoicedemo.entity.Customer;
import com.invoicedemo.entity.Invoice;
import com.invoicedemo.entity.InvoiceSubject;
import com.invoicedemo.entity.Product;

@Controller
public class AppController {
	
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private InvoiceDAO invoiceDAO;
	private ArrayList<InvoiceSubject> subjects = new ArrayList<InvoiceSubject>();
	
	@RequestMapping("/")
	public String showPage() {
		customerDAO.openCustomers();
		productDAO.openProducts();
		invoiceDAO.openInvoices();
		return "main-menu";
	}
	
	@RequestMapping("/showcustomers")
	public String showCustomersPage(Model theModel) {
		
		ArrayList<Customer> theCustomers = customerDAO.getCustomers();
		
		theModel.addAttribute("customers", theCustomers);
		
		return "show-customers";
	}
	@RequestMapping("/showcustomers/showinvoices")
	public String showInvoicesPage(@RequestParam("customerId") int theId,Model theModel) {
		
		ArrayList<Invoice> invoices = new ArrayList<Invoice>();
		invoices = invoiceDAO.getInvoices(theId);
		theModel.addAttribute("invoices",invoices);
		theModel.addAttribute("customer",customerDAO.getCustomer(theId));
		
		return "show-invoices";
	}
	@RequestMapping("/showcustomers/showinvoices/showinvoice")
	public String showInvoicePage(@RequestParam("customerId") int theCustomerId,@RequestParam("invoiceId") int theInvoiceId,Model theModel) {
		
		theModel.addAttribute("invoice",invoiceDAO.getInvoice(theInvoiceId));
		theModel.addAttribute("customer",customerDAO.getCustomer(theCustomerId));
		
		return "show-invoice";
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
	
	@RequestMapping("/showcustomers/addinvoice")
	public String showAddInvoicePage(@RequestParam("customerId") int theId,Model theModel) {
		
		Invoice invoice = new Invoice();
		InvoiceSubject newInvoiceSubject = new InvoiceSubject();
		theModel.addAttribute("customer",customerDAO.getCustomer(theId));
		theModel.addAttribute("invoice",invoice);
		theModel.addAttribute("subject",newInvoiceSubject);
		theModel.addAttribute("products",productDAO.getProducts());
		theModel.addAttribute("subjects",subjects);
		
		return "add-invoice";
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
	
	@PostMapping("/showcustomers/saveinvoicesubject")
	public String saveInvoiceSubject(@ModelAttribute("subject") InvoiceSubject theInvoiceSubject,@RequestParam("customerId") int theId,Model theModel) {
		
		Product product = productDAO.getProduct(theInvoiceSubject.getProductId());
		theInvoiceSubject.setProduct(product);
		theInvoiceSubject.setFinalPrice(theInvoiceSubject.getCount()*product.getPrice());
		subjects.add(theInvoiceSubject);
		
		return "redirect:/showcustomers/addinvoice?customerId=" + theId;
	}
	
	@PostMapping("/showcustomers/saveinvoice")
	public String saveInvoice(@ModelAttribute("invoice") Invoice theInvoice) {
		theInvoice.setInvoiceSubjects(subjects);
		subjects = new ArrayList<InvoiceSubject>();
		System.out.println(theInvoice.getCustomerId());
		theInvoice.setDate(java.time.LocalDateTime.now().toString());
		invoiceDAO.saveInvoices(theInvoice);
		return "redirect:/";
	}
}
