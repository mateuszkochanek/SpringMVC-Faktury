package com.invoicedemo.dao.interfaces;

import java.util.ArrayList;

import com.invoicedemo.entity.Customer;

public interface CustomerDAO {
  public ArrayList<Customer> getCustomers();

  public void saveCustomers(Customer customer);

  public void openCustomers();

  public Customer getCustomer(int theId);
}
