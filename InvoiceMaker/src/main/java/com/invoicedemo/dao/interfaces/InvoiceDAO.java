package com.invoicedemo.dao.interfaces;

import java.util.ArrayList;

import com.invoicedemo.entity.Customer;
import com.invoicedemo.entity.Invoice;

public interface InvoiceDAO {
	public ArrayList<Invoice> getInvoices();
	public void saveInvoices(Invoice invoice);
	public void openInvoices();
	public ArrayList<Invoice> getInvoices(int theId);
	public Invoice getInvoice(int theId);
}
