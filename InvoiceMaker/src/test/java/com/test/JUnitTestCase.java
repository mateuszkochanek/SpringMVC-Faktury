package com.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.invoicedemo.entity.Invoice;
import com.invoicedemo.entity.InvoiceSubject;
import com.invoicedemo.entity.Product;

public class JUnitTestCase{
 
  private Invoice testerInvoice;
  
  @Before
  public void beforeClass () {
    testerInvoice = new Invoice();
    testerInvoice.setCustomerId(0);
    testerInvoice.setDate(java.time.LocalDateTime.now().toString());
    testerInvoice.setId(0);
    ArrayList<InvoiceSubject> invoiceSubjects = new ArrayList<InvoiceSubject>();
    Product product1 = new Product(0,"A",(float)4.9);
    Product product2 = new Product(1,"B",2);
    InvoiceSubject invoiceSubject1 = new InvoiceSubject(0, 0, product1, 2,(float) (2.0*4.2));
    InvoiceSubject invoiceSubject2 = new InvoiceSubject(1, 1, product2, 3,(float) (3.0*2));
    InvoiceSubject invoiceSubject3 = new InvoiceSubject(2, 1, product2, 4,(float) (4.0*2));
    invoiceSubjects.add(invoiceSubject1);
    invoiceSubjects.add(invoiceSubject2);
    invoiceSubjects.add(invoiceSubject3);
    testerInvoice.setInvoiceSubjects(invoiceSubjects);
  }
  
  @Test
  public void sumShouldBeEqual() {
      assertEquals(22.4 , testerInvoice.getSumPrice(), 0.001);
  }

  @Test
  public void testAdd() {
     String str = "Junit is working fine";
     assertEquals("Junit is working fine",str);
  }
      
}
