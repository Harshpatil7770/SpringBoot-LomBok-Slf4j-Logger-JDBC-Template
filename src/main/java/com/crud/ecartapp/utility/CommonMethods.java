package com.crud.ecartapp.utility;

public class CommonMethods {

	public static String BRAND_ID;

	public static String CATEGORY_ID;

	public static String PRODUCT_ID;

	public static int getBrandId() {
		String str = "10";
		int random = (int) (Math.random() * (1000 - 100 + 1) + 100);
		str = str + Integer.toString(random);
		BRAND_ID = str;
		return Integer.parseInt(BRAND_ID);
	}

	public static int getCategoryId() {
		String str = "20";
		int random = (int) (Math.random() * (1000 - 100 + 1) + 100);
		str = str + Integer.toString(random);
		CATEGORY_ID = str;
		return Integer.parseInt(CATEGORY_ID);
	}

	public static int getProductId() {
		String str = "30";
		int random = (int) (Math.random() * (1000 - 100 + 1) + 100);
		str = str + Integer.toString(random);
		PRODUCT_ID = str;
		return Integer.parseInt(PRODUCT_ID);

	}
}
