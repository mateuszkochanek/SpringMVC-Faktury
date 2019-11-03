package com.invoicedemo.entity;

import java.io.Serializable;

public class InvoiceSubject implements Serializable {

  private static final long serialVersionUID = 1L;
  private int id;
  private int productId;
  private Product product;
  private int count;
  private float finalPrice;

  public InvoiceSubject() {

  }
  
  public InvoiceSubject(int id, int productId, Product product, int count, float finalPrice) {
    this.id = id;
    this.productId = productId;
    this.product = product;
    this.count = count;
    this.finalPrice = finalPrice;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public float getFinalPrice() {
    return finalPrice;
  }

  public void setFinalPrice(float finalPrice) {
    this.finalPrice = finalPrice;
  }

  @Override
  public String toString() {
    return "InvoiceSubject [id=" + id + ", product=" + product + ", count=" + count + "]";
  }

}