package com.asellion.assignment.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.asellion.assignment.product.model.Product;

@Service
public interface ProductService {

	List<Product> listAllProducts();

	Product getProductById(long id);

	Product saveProduct(Product product);
	
	Product updateProduct(long id,Product product);

}
