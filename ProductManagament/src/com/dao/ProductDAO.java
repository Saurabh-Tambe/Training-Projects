package com.dao;

import java.util.List;

import com.pojo.Product;

public interface ProductDAO {
	int addProduct(Product product);
	boolean updateProductPrice(int productId, double price);
	boolean updateProductQuantity(int productId,int quantity);

	//boolean updateProduct(int productId, int quantity);
	Product findById(int productId);
	List<Product> findAll();
	List<Product> findAllByCategory(String category);
	boolean deleteById(int productId);
}
