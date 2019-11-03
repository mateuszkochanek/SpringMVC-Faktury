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
import com.invoicedemo.dao.interfaces.InvoiceDAO;
import com.invoicedemo.entity.Customer;
import com.invoicedemo.entity.Invoice;

@Component
public class InvoiceDAOImpl implements InvoiceDAO {

  private ArrayList<Invoice> invoices = new ArrayList<Invoice>();

  public ArrayList<Invoice> getInvoices() {
    if (invoices.isEmpty()) {
      this.openInvoices();
    }
    return invoices;
  }

  public void saveInvoices(Invoice invoice) {
    this.openInvoices();
    try {
      FileOutputStream f = new FileOutputStream(
          new File("C:/Users/User/Desktop/Faktury_Program"
              + "/InvoiceMaker/src/main/resources/Invoices.ser"));
      ObjectOutputStream o = new ObjectOutputStream(f);

      invoice.setId(invoices.size());
      invoices.add(invoice);
      // Write objects to file
      o.writeObject(invoices);

      o.close();
      f.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    } catch (IOException e) {
      System.out.println("Error initializing stream save");
    }
  }

  public void openInvoices() {
    try {
      FileInputStream f = new FileInputStream(
          new File("C:/Users/User/Desktop/Faktury_Program"
              + "/InvoiceMaker/src/main/resources/Invoices.ser"));
      ObjectInputStream o = new ObjectInputStream(f);

      this.invoices = (ArrayList<Invoice>) o.readObject();
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

  // returns invoices with the same customer ID as theId
  public ArrayList<Invoice> getInvoices(int theId) {
    ArrayList<Invoice> tempInvoices = new ArrayList<Invoice>();
    for (Invoice tempInvoice : invoices) {
      if (tempInvoice.getCustomerId() == theId) {
        tempInvoices.add(tempInvoice);
      }
    }
    return tempInvoices;
  }

  // returns invoice with the same invoice ID as theId
  public Invoice getInvoice(int theId) {
    for (Invoice tempInvoice : invoices) {
      if (tempInvoice.getId() == theId) {
        return tempInvoice;
      }
    }
    return null;
  }

}
