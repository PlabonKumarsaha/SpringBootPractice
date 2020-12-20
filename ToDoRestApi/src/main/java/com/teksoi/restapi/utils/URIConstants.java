package com.teksoi.restapi.utils;

public class URIConstants {
	
	private static final String API = "/api";
	private static final String VERSION = "/v1";
	
	public static class category{
		public static final String ROOT = API+VERSION;
		public static final String GETALL = ROOT + "/catagories";
		public static final String CREATE = ROOT + "/add";
		public static final String UPDATE = ROOT + "/update/{id}";
		public static final String DELETE = ROOT + "/delete/{id}";
		
		
		
		
	}

}
