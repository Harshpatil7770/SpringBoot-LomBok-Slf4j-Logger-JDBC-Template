package com.crud.ecartapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.ecartapp.model.Brand;
import com.crud.ecartapp.model.Category;
import com.crud.ecartapp.model.Product;
import com.crud.ecartapp.service.EcartService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/ecart")
@Slf4j
public class EcartController {

	@Autowired
	EcartService ecartService;

	@PostMapping("/addNewBrand")
	public Brand addNewBrand(@RequestBody Brand brand) {
		log.info("addNewBrand() called");
		return ecartService.addNewBrand(brand);
	}

	@PostMapping("/addNewCategory")
	Category addNewCategory(@RequestBody Category category) {
		log.info("addNewCategory() called");
		return ecartService.addNewCategory(category);
	}

	@PostMapping("/addNewProduct")
	public Product addNewProduct(@RequestBody Product product) {
		log.info("addNewProduct() called");
		return ecartService.addNewProduct(product);
	}

	@GetMapping("/fetchAllProducts")
	public List<Product> fetchAllProducts() {
		log.info("fetchAllProducts() called");
		return ecartService.fetchAllProducts();
	}

	@GetMapping("/updateProduct/{productId}")
	public String updateProduct(@RequestBody Product product, @PathVariable int productId) {
		log.info("updateProduct() called");
		return ecartService.updateProduct(product, productId);
	}

	@DeleteMapping("/deleteProduct/{productId}")
	public void deleteProduct(@PathVariable int productId) {
		log.info("deleteProduct() called");
		ecartService.deleteProduct(productId);
	}

	@GetMapping("/findProductById/{productId}")
	public Product findProductById(@PathVariable int productId) {
		log.info("findProductById() called");
		return ecartService.findProductById(productId);
	}

	@GetMapping("/fetchAllProductsByName/{productName}")
	List<Product> fetchAllProductsByName(@PathVariable String productName){
		log.info("fetchAllProductsByName() called");
		return ecartService.fetchAllProductsByName(productName);
	}
	
	@GetMapping("/fetchProductByCategoryName/{categoryName}")
	public List<Product> fetchProductByCategoryName(@PathVariable String categoryName) {
		log.info("fetchProductByCategoryName() called");
		return ecartService.fetchProductByCategoryName(categoryName);
	}
	
	@GetMapping("/filterProductBetweenPriceRange/{minPrice}/{maxPrice}")
	public List<Product> filterProductBetweenPriceRange(@PathVariable double minPrice,@PathVariable double maxPrice) {
		log.info("filterProductBetweenPriceRange() called");
		return ecartService.filterProductBetweenPriceRange(minPrice, maxPrice);
	}
}
