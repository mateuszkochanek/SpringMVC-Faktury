package com.invoicedemo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.invoicedemo.dao.interfaces.CustomerDAO;
import com.invoicedemo.entity.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	
	private ArrayList<Customer> customers;
	
	public ArrayList<Customer> getCustomers() {
		if(customers == null)
			this.openCustomers();
		return customers;
	}

	public void saveCustomers(Customer customer) {
		try {
			FileOutputStream f = new FileOutputStream(new File("Customers.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			customer.setID(customers.size());
			customers.add(customer);
			// Write objects to file
			o.writeObject(customers);
			
			o.close();
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
	}

	public ArrayList<Customer> openCustomers() {
		try {
			FileInputStream f = new FileInputStream(new File("Customers.txt"));
			ObjectInputStream o = new ObjectInputStream(f);
			
			this.customers = (ArrayList<Customer>) o.readObject();
			
			o.close();
			f.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
