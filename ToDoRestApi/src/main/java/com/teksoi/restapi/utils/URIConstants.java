package com.teksoi.restapi.utils;

public final class URIConstants {
	
	public URIConstants() {
		
	}
	
	public static final String API = "/api";
	private static final String VERSION = "/v1";
	
	public static class Category{
		public static final String ROOT = API+VERSION;
		public static final String GETALL = "/catagories";
		public static final String CREATE = "/add";
		public static final String UPDATE = "/update/{id}";
		public static final String DELETEBYID = "/delete/{id}";
		public static final String DELETE = "/delete";
		public static final String PAGENO = "/page";
		
		
	}
	
	public static class ProductURL{
		public static final String ROOT = API+VERSION;
		public static final String GETALL = "/products";
		public static final String CREATE = "/add_product";
		public static final String UPDATE = "/update_product/{id}";
		public static final String DELETEBYID = "/delete_product/{id}";
		public static final String DELETE = "/delete_product";
		
	}

	public static class ShopURL{
		public static final String ROOT = API+VERSION;
		public static final String GETALL = "/shops";
		public static final String CREATE = "/add_shop";
		public static final String UPDATE = "/update_shop/{id}";
		public static final String DELETEBYID = "/delete_shop/{id}";
		public static final String DELETE = "/delete_shop";
		
	}
}
