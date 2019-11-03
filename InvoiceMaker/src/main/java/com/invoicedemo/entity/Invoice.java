package com.invoicedemo.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Invoice implements Serializable {

  private static final long serialVersionUID = 1L;
  private int id;
  private int customerId;
  private String date;
  private ArrayList<InvoiceSubject> invoiceSubjects;

  public Invoice() {
    invoiceSubjects = new ArrayList<InvoiceSubject>();
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

  public ArrayList<InvoiceSubject> getInvoiceSubjects() {
    return invoiceSubjects;
  }

  public void setInvoiceSubjects(ArrayList<InvoiceSubject> invoiceSubjects) {
    this.invoiceSubjects = invoiceSubjects;
  }

  @Override
  public String toString() {
    return "Invoice [id=" + id + ", customerId=" + customerId 
        + ", invoiceSubjects=" + invoiceSubjects + "]";
  }

  public float getSumPrice() {
    float sum = 0;
    for (InvoiceSubject tempSubject : invoiceSubjects) {
      sum += tempSubject.getFinalPrice();
    }
    return sum;
  }

}
