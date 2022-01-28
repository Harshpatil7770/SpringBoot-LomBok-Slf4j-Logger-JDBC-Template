package com.crud.ecartapp.utility;

public class DBquries {

	public static final String ADD_NEW_BRAND = "insert into brands values(?,?)";

	public static final String ADD_NEW_CATEGORY = "insert into categories values(?,?)";

	public static final String ADD_NEW_PRODUCT = "insert into products values(?,?,?,?,?,?,?,?)";

	public static final String FETCH_ALL_PRODUCTS = "select * from products p inner join brands b on p.brand_id=b.brand_id inner join categories c on p.category_id=c.category_id";

	public static final String UPDATE_PRODUCTS = "update products set product_name=?,product_price=?,quantity=?,description=?,keywords=? where product_id=?";

	public static final String DELETE_PRODUCT = "delete from products where product_id=?";

	public static final String FIND_PRODUCT_BY_ID = "select * from products p inner join brands b on p.brand_id=b.brand_id inner join categories c on p.category_id=c.category_id where p.product_id=?";

	public static final String FIND_PRODUCT_BY_NAME = "select * from products p inner join brands b on p.brand_id=b.brand_id inner join categories c on p.category_id=c.category_id where p.product_name=?";

	public static final String FIND_PRODUCT_BY_CATEGORY_NAME = "select * from products p inner join brands b on p.brand_id=b.brand_id inner join categories c on p.category_id=c.category_id where c.category_title=?";

	public static final String FILTER_PRODUCT_BY_PRICE_RANGE = "select * from products p inner join brands b on p.brand_id=b.brand_id inner join categories c on p.category_id=c.category_id where p.product_price>=? and p.product_price<=?";
}
