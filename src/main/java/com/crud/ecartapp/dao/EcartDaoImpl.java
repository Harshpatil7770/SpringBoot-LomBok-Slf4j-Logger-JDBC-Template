package com.crud.ecartapp.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.crud.ecartapp.model.Brand;
import com.crud.ecartapp.model.Category;
import com.crud.ecartapp.model.Product;
import com.crud.ecartapp.utility.CommonMethods;
import com.crud.ecartapp.utility.DBquries;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class EcartDaoImpl implements EcartDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Brand addNewBrand(Brand brand) {

		int result = jdbcTemplate.update(DBquries.ADD_NEW_BRAND, CommonMethods.getBrandId(), brand.getBrandName());
		if (result != 0) {
			log.info("addNewBrand () called");
			return brand;
		}
		return null;
	}

	@Override
	public Category addNewCategory(Category category) {

		int result = jdbcTemplate.update(DBquries.ADD_NEW_CATEGORY, CommonMethods.getCategoryId(),
				category.getCategoryName());
		if (result != 0) {
			log.info("addNewCategory () called");
			return category;
		}
		return null;
	}

	@Override
	public Product addNewProduct(Product product) {

		int result = jdbcTemplate.update(DBquries.ADD_NEW_PRODUCT, CommonMethods.getProductId(),
				product.getProductName(), product.getProductPrice(), product.getQuantity(), product.getDescription(),
				product.getKeywords(), product.getBrand().getBrandId(), product.getCategory().getCategoryId());

		if (result != 0) {
			log.info("addNewProduct () called");
			return product;
		}
		return null;
	}

	@Override
	public List<Product> fetchAllProducts() {

		return jdbcTemplate.query(DBquries.FETCH_ALL_PRODUCTS, (ResultSet rs) -> {
			List<Product> products = new ArrayList<Product>();
			while (rs.next()) {
				Product product = new Product();
				Brand brand = new Brand();
				Category category = new Category();

				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductPrice(rs.getDouble(3));
				product.setQuantity(rs.getInt(4));
				product.setDescription(rs.getString(5));
				product.setKeywords(rs.getString(7));

				brand.setBrandId(rs.getInt(1));
				brand.setBrandName(rs.getString(2));

				category.setCategoryId(rs.getInt(1));
				category.setCategoryName(rs.getString(2));

				product.setBrand(brand);
				product.setCategory(category);

				products.add(product);
			}
			log.info("fetchAllProducts () called");
			return products;
		});
	}

	@Override
	public String updateProduct(Product product, int productId) {

		int result = jdbcTemplate.update(DBquries.UPDATE_PRODUCTS, product.getProductName(), product.getProductPrice(),
				product.getQuantity(), product.getDescription(), product.getKeywords(), productId);
		if (result != 0) {
			log.info("updateProduct () called");
			return " Product updated Succesfully";
		}
		return null;
	}

	@Override
	public void deleteProduct(int productId) {

		int result = jdbcTemplate.update(DBquries.DELETE_PRODUCT, productId);
		if (result != 0) {
			log.info("deleteProduct () called");
			System.out.println("Delete Product Succesfully");
		} else {
			System.out.println("Product not deleted Succesfully");
			;
		}
	}

	@Override
	public Product findProductById(int productId) {

		return jdbcTemplate.query(DBquries.FIND_PRODUCT_BY_ID, (ResultSet rs) -> {
			if (rs.next()) {

				Product product = new Product();
				Brand brand = new Brand();
				Category category = new Category();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductPrice(rs.getDouble(3));
				product.setQuantity(rs.getInt(4));
				product.setDescription(rs.getString(5));
				product.setKeywords(rs.getString(6));

				brand.setBrandId(rs.getInt("brand_id"));
				brand.setBrandName(rs.getString("brand_title"));

				category.setCategoryId(rs.getInt("category_id"));
				category.setCategoryName(rs.getString("category_title"));
				product.setBrand(brand);
				product.setCategory(category);
				log.info("findProductById () called");
				return product;
			}
			return null;
		}, productId);
	}

	@Override
	public List<Product> fetchAllProductsByName(String productName) {

		return jdbcTemplate.query(DBquries.FIND_PRODUCT_BY_NAME, (ResultSet rs) -> {
			List<Product> lists = new ArrayList<Product>();
			while (rs.next()) {
				Product product = new Product();
				Brand brand = new Brand();
				Category category = new Category();

				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductPrice(rs.getDouble(3));
				product.setQuantity(rs.getInt(4));
				product.setDescription(rs.getString(5));
				product.setKeywords(rs.getString(6));

				brand.setBrandId(rs.getInt("brand_id"));
				brand.setBrandName(rs.getString("brand_title"));

				category.setCategoryId(rs.getInt("category_id"));
				category.setCategoryName(rs.getString("category_title"));

				product.setBrand(brand);
				product.setCategory(category);

				lists.add(product);

			}
			log.info("fetchAllProductsByName () called");
			return lists;
		}, productName);
	}

	@Override
	public List<Product> fetchProductByCategoryName(String categoryName) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(DBquries.FIND_PRODUCT_BY_CATEGORY_NAME, (ResultSet rs) -> {
			List<Product> lists = new ArrayList<Product>();
			while (rs.next()) {
				Product product = new Product();
				Brand brand = new Brand();
				Category category = new Category();

				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductPrice(rs.getDouble(3));
				product.setQuantity(rs.getInt(4));
				product.setDescription(rs.getString(5));
				product.setKeywords(rs.getString(6));

				brand.setBrandId(rs.getInt("brand_id"));
				brand.setBrandName(rs.getString("brand_title"));

				category.setCategoryId(rs.getInt("category_id"));
				category.setCategoryName(rs.getString("category_title"));

				product.setBrand(brand);
				product.setCategory(category);

				lists.add(product);

			}
			log.info("fetchProductByCategoryName () called");
			return lists;
		}, categoryName);
	}

	@Override
	public List<Product> filterProductBetweenPriceRange(double minPrice, double maxPrice) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(DBquries.FILTER_PRODUCT_BY_PRICE_RANGE, (ResultSet rs) -> {
			List<Product> lists = new ArrayList<Product>();
			while (rs.next()) {
				Product product = new Product();
				Brand brand = new Brand();
				Category category = new Category();

				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductPrice(rs.getDouble(3));
				product.setQuantity(rs.getInt(4));
				product.setDescription(rs.getString(5));
				product.setKeywords(rs.getString(6));

				brand.setBrandId(rs.getInt("brand_id"));
				brand.setBrandName(rs.getString("brand_title"));

				category.setCategoryId(rs.getInt("category_id"));
				category.setCategoryName(rs.getString("category_title"));

				product.setBrand(brand);
				product.setCategory(category);

				lists.add(product);

			}
			log.info("filterProductBetweenPriceRange () called");
			return lists;
		}, minPrice, maxPrice);

	}
}
