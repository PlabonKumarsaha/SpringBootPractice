package com.teksoi.restapi.service;

import com.teksoi.restapi.dto.Response;
import com.teksoi.restapi.dto.ShopDto;
import com.teksoi.restapi.model.Shop;

public interface ShopService {

	Response createShop(ShopDto shopdto);
	Response getAll();
	Response updateShop(Long id);
	Response updateShop(Long id, ShopDto shopdto);
	Response deletetShop(int id);
	Response deleteAll();
	
	
}
