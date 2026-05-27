package com.msedcl.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.main.entity.Product;
import com.msedcl.main.repository.ProductRepository;
import com.msedcl.main.repository.ProductRepositoryImpl;

@Service
public class ProductServiceImpl implements ProductService {
	
private  ProductRepository ProductRepository;

	public ProductServiceImpl(ProductRepository ProductRepository) {
	super();
	this.ProductRepository = ProductRepository;
}

	@Override
	public Product addNewProduct(Product Product) {
		// TODO Auto-generated method stub
		return ProductRepository.addNewProduct(Product);
	}

	@Override
	public Product getProductByName(String name) {
		// TODO Auto-generated method stub
		return ProductRepository.getProductByName(name);
	}

//	@Override
//	public Product addNewProduct(Product Product) {
//		// TODO Auto-generated method stub
//		return ProductRepository.addNewProduct(Product);
//	}
//
//	@Override
//	public Product updateProduct(Product Product) {
//		// TODO Auto-generated method stub
//		return ProductRepository.updateProduct(Product);
//	}
//
//	@Override
//	public Product getProductByProductId(int ProductId) {
//		// TODO Auto-generated method stub
//		return ProductRepository.getProductByProductId(ProductId);
//	}
//
//	@Override
//	public boolean deleteProductByProductId(int ProductId) {
//		// TODO Auto-generated method stub
//		return ProductRepository.deleteProductByProductId(ProductId);
//	}
//
//	@Override
//	public List<Product> getAllProducts() {
//		// TODO Auto-generated method stub
//		return ProductRepository.getAllProducts();
//	}
//
//	@Override
//	public List<Product> getAllProductByName(String name) {
//		// TODO Auto-generated method stub
//		return ProductRepository.getAllProductByName(name);
//	}
//
//	@Override
//	public Long getCountOfProducts() {
//		// TODO Auto-generated method stub
//		return ProductRepository.getCountOfProducts();
//	}
//
//	@Override
//	public Product getMaxSalaryOfProduct() {
//		// TODO Auto-generated method stub
//		return ProductRepository.getMaxSalaryOfProduct();
//	}

}
