package com.asellion.assignment.product.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asellion.assignment.product.model.Product;
import com.asellion.assignment.product.repository.ProductRepository;
import com.asellion.assignment.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> listAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(long id) {

		Optional<Product> result = productRepository.findById(id);
		Product theProduct = null;
		if (result.isPresent()) {
			theProduct = result.get();
		} else {
			throw new RuntimeException("ProductId not found:" + id);
		}
		return theProduct;

	}

	@Override
	public Product saveProduct(Product product) {
		product.setLastupdate(LocalDateTime.now());
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(long id, Product product) {
		Optional<Product> result = productRepository.findById(id);
		Product theProduct = null;
		if (result.isPresent()) {
			product.setId(id);
			product.setLastupdate(LocalDateTime.now());
			theProduct =  productRepository.save(product);
		} else {
			throw new RuntimeException("ProductId not found:" + id);
		}
		return theProduct;
	}
}
