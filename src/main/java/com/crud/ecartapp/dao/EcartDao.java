package com.crud.ecartapp.dao;

import java.util.List;

import com.crud.ecartapp.model.Brand;
import com.crud.ecartapp.model.Category;
import com.crud.ecartapp.model.Product;

public interface EcartDao {

	Brand addNewBrand(Brand brand);

	Category addNewCategory(Category category);

	Product addNewProduct(Product product);

	List<Product> fetchAllProducts();

	String updateProduct(Product product, int productId);

	void deleteProduct(int productId);

	Product findProductById(int productId);

	List<Product> fetchAllProductsByName(String productName);

	List<Product> fetchProductByCategoryName(String categoryName);

	List<Product> filterProductBetweenPriceRange(double minPrice, double maxPrice);
}
