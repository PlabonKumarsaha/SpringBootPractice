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
		
	}

}
