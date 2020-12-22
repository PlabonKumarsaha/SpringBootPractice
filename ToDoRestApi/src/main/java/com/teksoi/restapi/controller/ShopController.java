package com.teksoi.restapi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teksoi.restapi.dto.Response;
import com.teksoi.restapi.dto.ShopDto;
import com.teksoi.restapi.service.ShopService;
import com.teksoi.restapi.utils.URIConstants;
import com.teksoi.restapi.utils.URIConstants.ShopURL;

@RestController
@CrossOrigin
@RequestMapping(URIConstants.API)
public class ShopController {

	public final ShopService shopservice;
	
	@Autowired
	public ShopController(ShopService shopservice) {
		this.shopservice = shopservice;
	}
	
	@PostMapping(ShopURL.CREATE)
	@ResponseBody
	Response create(@RequestBody ShopDto shopDto,HttpServletResponse httpServletResponse, HttpServletRequest request) {
		
		Response response = shopservice.createShop(shopDto);
		httpServletResponse.setStatus(response.getStatusCode());
		return response;
	}
	
	@PostMapping(ShopURL.GETALL)
	@ResponseBody
	Response getAll(HttpServletResponse httpServletResponse) {
		
		Response response = shopservice.getAll();
		response.setStatus(response.getStatus());
		return response;
	}
	//update 
	@PostMapping(ShopURL.UPDATE)
	@ResponseBody
	Response update(@PathVariable("id")Long id, @RequestBody ShopDto shopDto, HttpServletResponse httpServletResponse,  HttpServletRequest request) {
		Response response = shopservice.updateShop(id);
		httpServletResponse.setStatus(response.getStatusCode());
		return response;
	}
	
	// delete 
	@DeleteMapping(ShopURL.DELETEBYID)
	@ResponseBody
	Response delete(@PathVariable("id")Long id, @RequestBody ShopDto shopDto, HttpServletResponse httpServletResponse,  HttpServletRequest request) {
	
		Response response = shopservice.deletetShop(id);
		httpServletResponse.setStatus(response.getStatusCode());
		return response;
	}
	
	
	
	
	
	
}
