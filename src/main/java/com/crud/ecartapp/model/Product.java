package com.crud.ecartapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private int productId;

	private String productName;

	private double productPrice;

	private int quantity;

	private String description;

	private String keywords;

	private Brand brand;

	private Category category;

}
