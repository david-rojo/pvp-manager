package com.pvpmanager.springboot.app.model.service;

import java.util.List;

import com.pvpmanager.springboot.app.model.entitys.Price;
import com.pvpmanager.springboot.app.model.entitys.PvpResponse;

public interface IPriceService {

	public PvpResponse getPvp(Integer brandId, Integer productId, String date);
	
	public List<Price> getPrices();
	
	public Price addPrice(Price price);
	
	public void removePrice(Integer brandId, Integer productId, Integer priceList);
	
	public Price updatePrice(Price price);
}
