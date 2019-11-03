package com.invoicedemo.dao.interfaces;

import java.util.ArrayList;

import com.invoicedemo.entity.Customer;
import com.invoicedemo.entity.Invoice;

public interface InvoiceDAO {
  public ArrayList<Invoice> getInvoices();
  
  public ArrayList<Invoice> getInvoices(int theId);

  public void saveInvoices(Invoice invoice);

  public void openInvoices();

  public Invoice getInvoice(int theId);
}
