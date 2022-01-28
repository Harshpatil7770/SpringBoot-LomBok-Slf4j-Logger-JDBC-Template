package com.crud.ecartapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.ecartapp.dao.EcartDao;
import com.crud.ecartapp.model.Brand;
import com.crud.ecartapp.model.Category;
import com.crud.ecartapp.model.Product;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EcartServiceImpl implements EcartService {

	@Autowired
	EcartDao ecartDao;

	@Override
	public Brand addNewBrand(Brand brand) {
		log.info("addNewBrand() called");
		return ecartDao.addNewBrand(brand);
	}

	@Override
	public Category addNewCategory(Category category) {
		log.info("addNewCategory() called");
		return ecartDao.addNewCategory(category);
	}

	@Override
	public Product addNewProduct(Product product) {
		log.info("addNewProduct() called");
		return ecartDao.addNewProduct(product);
	}

	@Override
	public List<Product> fetchAllProducts() {
		log.info("fetchAllProducts() called");
		return ecartDao.fetchAllProducts();
	}

	@Override
	public String updateProduct(Product product, int productId) {
		log.info("updateProduct() called");
		return ecartDao.updateProduct(product, productId);
	}

	@Override
	public void deleteProduct(int productId) {
		log.info("deleteProduct() called");
		ecartDao.deleteProduct(productId);
	}

	@Override
	public Product findProductById(int productId) {
		log.info("findProductById() called");
		return ecartDao.findProductById(productId);
	}

	@Override
	public List<Product> fetchAllProductsByName(String productName) {
		log.info("fetchAllProductsByName() called");
		return ecartDao.fetchAllProductsByName(productName);
	}

	@Override
	public List<Product> fetchProductByCategoryName(String categoryName) {
		log.info("fetchProductByCategoryName() called");
		return ecartDao.fetchProductByCategoryName(categoryName);
	}

	@Override
	public List<Product> filterProductBetweenPriceRange(double minPrice, double maxPrice) {
		log.info("filterProductBetweenPriceRange() called");
		return ecartDao.filterProductBetweenPriceRange(minPrice, maxPrice);
	}

}
