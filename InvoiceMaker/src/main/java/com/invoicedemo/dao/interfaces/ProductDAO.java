package com.invoicedemo.dao.interfaces;

import java.util.ArrayList;

import com.invoicedemo.entity.Customer;
import com.invoicedemo.entity.Product;

public interface ProductDAO {
	public ArrayList<Product> getProducts();
	public void saveProducts(Product product);
	public void openProducts();
	public Product getProduct(int productId);
}
