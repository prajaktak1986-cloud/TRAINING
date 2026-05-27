package com.msedcl.main.service;

import java.util.List;

import com.msedcl.main.entity.Product;

public interface ProductService {
	Product addNewProduct(Product product);
	//Product updateProduct(Product Product);
//	Product getProductByProductId(int ProductId);
//	boolean deleteProductByProductId(int ProductId);
	//List<Product> getAllProducts();
	Product getProductByName(String name);
//	Long getCountOfProducts();
//	Product getMaxSalaryOfProduct();

}
