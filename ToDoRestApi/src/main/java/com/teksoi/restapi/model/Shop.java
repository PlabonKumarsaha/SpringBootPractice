package com.teksoi.restapi.model;

import javax.persistence.Entity;

@Entity
public class Shop extends BaseModel {

	private String address;
	private int shopNumber;
}
