package com.msedcl.main.repository;

import java.util.List;

import com.msedcl.main.entity.Product;

public interface ProductRepository {
	
	Product addNewProduct(Product product);
	//Product updateProduct(Product Product);
//	Product getProductByProductId(int ProductId);
//	boolean deleteProductByProductId(int ProductId);
	//List<Product> getAllProducts();
	Product getProductByName(String name);
//	Long getCountOfProducts();
//	Product getMaxSalaryOfProduct();


}
