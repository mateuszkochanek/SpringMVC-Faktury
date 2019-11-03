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

import com.invoicedemo.dao.interfaces.ProductDAO;
import com.invoicedemo.entity.Customer;
import com.invoicedemo.entity.Product;

@Component
public class ProductDAOImpl implements ProductDAO {

  private ArrayList<Product> products = new ArrayList<Product>();

  public ArrayList<Product> getProducts() {
    if (products.isEmpty())
      this.openProducts();
    return products;
  }

  public void saveProducts(Product product) {
    this.openProducts();
    try {
      FileOutputStream f = new FileOutputStream(
          new File("C:/Users/User/Desktop/Faktury_Program/InvoiceMaker/src/main/resources/Products.ser"));
      ObjectOutputStream o = new ObjectOutputStream(f);

      product.setId(products.size());
      products.add(product);
      // Write objects to file
      o.writeObject(products);

      o.close();
      f.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    } catch (IOException e) {
      System.out.println("Error initializing stream save");
    }
  }

  public void openProducts() {
    try {
      FileInputStream f = new FileInputStream(
          new File("C:/Users/User/Desktop/Faktury_Program/InvoiceMaker/src/main/resources/Products.ser"));
      ObjectInputStream o = new ObjectInputStream(f);

      this.products = (ArrayList<Product>) o.readObject();
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

  public Product getProduct(int productId) {
    for (Product tempProduct : products) {
      if (tempProduct.getId() == productId)
        return tempProduct;
    }
    return null;

  }

}
