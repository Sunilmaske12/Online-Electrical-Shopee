package com.codeo.shop.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart extends Product{

	private List<Product> products;
     public Cart() {
        products = new ArrayList<>();
     }//prod_id, prod_name, prod_description, prod_price, prod_discount, prod_quantity, prod_imageName, cid
	 public void addProduct(Product product, String Prod_quantity) {
        boolean productExists = false;
        for (Product p : products) {
            if (p.getId().equals(product.getId())) {
                p.setProd_quantity(p.getProd_quantity() + Prod_quantity);
                productExists = true;
                break;
            }   }
        if (!productExists) {
            product.setProd_quantity(Prod_quantity);
            products.add(product);
        }  }
    public void removeProduct(Product product) {
        products.remove(product);
    }  public List<Product> getProducts() {
        return products;
    }  public void setProducts(List<Product> products) {
        this.products = products;
    }
	
}
