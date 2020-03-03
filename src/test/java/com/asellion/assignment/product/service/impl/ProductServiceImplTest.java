package com.asellion.assignment.product.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.asellion.assignment.product.model.Product;
import com.asellion.assignment.product.repository.ProductRepository;

public class ProductServiceImplTest {

	@InjectMocks
	ProductServiceImpl productServiceImpl;

	@Mock
	ProductRepository productRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllproducts() throws Exception {
		List<Product> productList = new ArrayList<>();
		Product product = new Product("Name", new BigDecimal(1000), "description");
		Product product2 = new Product("Name2", new BigDecimal(100), "description1");
		productList.add(product);
		productList.add(product2);
		when(productRepository.findAll()).thenReturn(productList);
		assertEquals(productServiceImpl.listAllProducts().size(), productList.size());
	}

	@Test
	public void testGetProductById() {
		Product product = new Product("Name", new BigDecimal(1000), "description");
		product.setId(1l);
		Optional<Product> productOptional = Optional.of(product);
		when(productRepository.findById(1l)).thenReturn(productOptional);
		assertThat(productServiceImpl.getProductById(1l).equals(product));

	}

	@Test(expected = RuntimeException.class)
	public void testGetProductById_NotFound() {
		Optional<Product> productOptional = Optional.empty();
		when(productRepository.findById(1l)).thenReturn(productOptional);
		// ID not found error
		productServiceImpl.getProductById(1l);
	}

	@Test
	public void testSaveProduct() {
		Product product1 = new Product("Name", new BigDecimal(100), "description1");
		LocalDateTime lastupdate = LocalDateTime.now();
		product1.setLastupdate(lastupdate);
		when(productRepository.save(product1)).thenReturn(product1);
		assertThat(productServiceImpl.saveProduct(product1).equals(product1));
	}

	@Test
	public void testUpdateProduct() {
		Product product = new Product("Name", new BigDecimal(1000), "description");
		product.setId(1l);
		Optional<Product> productOptional = Optional.of(product);
		when(productRepository.findById(1l)).thenReturn(productOptional);

		// update the description
		product.setDescription("Description Updated");
		when(productRepository.save(product)).thenReturn(product);

		assertThat(productServiceImpl.updateProduct(1l, product).equals(product));
		assertEquals("Description Updated", product.getDescription());

	}

	@Test(expected = RuntimeException.class)
	public void testUpdateProductId_NotFound() {
		Product product = new Product("Name", new BigDecimal(1000), "description");
		product.setId(1l);
		Optional<Product> productOptional = Optional.of(product);
		when(productRepository.findById(1l)).thenReturn(productOptional);

		// update the description
		product.setDescription("Description Updated");
		when(productRepository.save(product)).thenReturn(product);

		productServiceImpl.updateProduct(2l, product);

	}

}
