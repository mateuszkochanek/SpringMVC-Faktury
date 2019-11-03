package com.invoicedemo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.invoicedemo.dao.interfaces.CustomerDAO;
import com.invoicedemo.entity.Customer;

@Component
public class CustomerDAOImpl implements CustomerDAO {
	
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public ArrayList<Customer> getCustomers() {
		if(customers.isEmpty())
			this.openCustomers();
		return customers;
	}

	public void saveCustomers(Customer customer) {
		this.openCustomers();
		try {
			FileOutputStream f = new FileOutputStream(new File("C:/Users/User/Desktop/Faktury_Program/InvoiceMaker/src/main/resources/Customers.ser"));
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			customer.setId(customers.size());
			customers.add(customer);
			// Write objects to file
			o.writeObject(customers);
			
			o.close();
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream save");
		}
	}

	public void openCustomers() {
		try {
			FileInputStream f = new FileInputStream(new File("C:/Users/User/Desktop/Faktury_Program/InvoiceMaker/src/main/resources/Customers.ser"));
			ObjectInputStream o = new ObjectInputStream(f);
			
			this.customers = (ArrayList<Customer>) o.readObject();
			o.close();
			f.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream open");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Customer getCustomer(int theId) {
		
		for(Customer tempCustomer : customers) {
			if(tempCustomer.getId() == theId)
				return tempCustomer;
		}
		return null;
	}
}
