package com.msedcl.main.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.msedcl.main.configuaration.SpringConfiguration;
import com.msedcl.main.entity.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final SpringConfiguration springConfiguration;

	private JdbcTemplate jdbcTemplate;
	
	private static final String ADD_NEW_PRODUCT = "INSERT INTO product_details(name,price) VALUES(?,?)";
	
//	private static final String UPDATE_product = "UPDATE product_details set name = ?, salary = ? WHERE product_id = ? ";
//	
//	private static final String DELETE_product = "DELETE FROM product_details WHERE product_id = ? ";
//	
	private static final String SELECT_PRODUCT_BY_PRODUCT_NAME = "SELECT * FROM product_details WHERE name = ? ";
	
	//private static final String SELECT_ALL_productS = "SELECT * FROM product_details ";
	
	public ProductRepositoryImpl(JdbcTemplate jdbcTemplate, SpringConfiguration springConfiguration) {
		super();
		System.out.println("Overloaded Constructor called - productRepositoryImpl.");
		this.jdbcTemplate = jdbcTemplate;
		this.springConfiguration = springConfiguration;
	}

	@Override
	public Product addNewProduct(Product product) {
		// TODO Auto-generated method stub
		int rowInserted = jdbcTemplate.update(ADD_NEW_PRODUCT, product.getName(),product.getPrice());
		if(rowInserted > 0)
			return product;
		else
		return null;
		
	}

	@Override
	public Product getProductByName(String name) {
		
//		return jdbcTemplate.queryForObject(SELECT_PRODUCT_BY_PRODUCT_NAME, 
//				(rs,row) -> new Product(rs.getInt(1),
//				rs.getString(2),
//				rs.getDouble(3)),
//		name);
		System.out.println("---"+name);
		
		
		
		RowMapper<Product> employeeRowMapper=(rs,rowCnt)->
		new Product(rs.getInt("product_id"),rs.getString("name"),rs.getDouble("price"));
		return jdbcTemplate.queryForObject(SELECT_PRODUCT_BY_PRODUCT_NAME,employeeRowMapper,name);

	}

//	@Override
//	@Transactional
//	public product addNewproduct(product product) {
//		// TODO Auto-generated method stub
//		int rowInserted = jdbcTemplate.update(ADD_NEW_product, product.getName(),product.getSalary());
//		if(rowInserted > 0)
//			return product;
//		else
//		return null;
//	}

//	@Override
//	public product updateproduct(product product) {
//		// TODO Auto-generated method stub
//		int rowUpdated = jdbcTemplate.update(UPDATE_product, product.getName(), product.getSalary(), product.getproductId());
//		if(rowUpdated > 0)
//			return product;
//		else
//		return null;
//	}

//	@Override
//	public product getproductByproductId(int productId) {
//		
//		return jdbcTemplate.queryForObject(SELECT_product_BY_product_ID, 
//				(rs,row) -> new product(rs.getInt(1),
//						rs.getString(2),
//						rs.getDouble(3)),
//				productId);
//	}

//	@Override
//	public boolean deleteproductByproductId(int productId) {
//		int rowDeleted = jdbcTemplate.update(DELETE_product, productId);
//		if(rowDeleted > 0) {
//			System.out.println("product Deleted.");
//			return true;
//		}
//		else
//		return false;
//	}

//	@Override
//	public List<product> getAllproducts() {
//		// TODO Auto-generated method stub
////		RowMapper<product> productRowMapper = (rs, row) -> 
////		new product(
////				rs.getInt(1), 
////				rs.getString(2), 
////				rs.getDouble(3));
////		
////		
////		return jdbcTemplate.query(SELECT_ALL_product, productRowMapper);
//
//		return jdbcTemplate.query(SELECT_ALL_productS,
//				(rs, rowCount) -> new product(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
//	}

//	@Override
//	public List<product> getAllproductByName(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public Long getCountOfproducts() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public product getMaxSalaryOfproduct() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
	
}
