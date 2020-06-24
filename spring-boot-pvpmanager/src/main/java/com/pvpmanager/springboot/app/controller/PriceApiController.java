package com.pvpmanager.springboot.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pvpmanager.springboot.app.model.entitys.Price;
import com.pvpmanager.springboot.app.model.service.IPriceService;

@RestController
@RequestMapping (value="pvp-manager")
public class PriceApiController implements PriceApi {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IPriceService priceService;
	
	@GetMapping(value="price")
	public List<Price> getPrices() {
		logger.info("getPrices method invoked");
		return priceService.getPrices();
	}
	
	@PostMapping(value="price")
	public Price addPrice(@RequestBody Price price)  {
		logger.info("addPrice method invoked");
		return priceService.addPrice(price);
	}
	
	@PutMapping(value="price")
	public Price updatePrice(@RequestBody Price price)  {
		logger.info("updatePrice method invoked");
		return priceService.addPrice(price);
	}
	
	@DeleteMapping(value="price/{brandId}/{productId}/{priceList}" )
	public boolean deletePrice(
			@PathVariable(value="brandId") Integer brandId, 
			@PathVariable(value="productId") Integer productId,
			@PathVariable(value="priceList") Integer priceList) {
		logger.info("deletePrice method invoked");
		logger.info("parameters received => "
				+ "\"brandId\" = " + brandId + ", "
				+ "\"productId\" = " + productId + ", "
				+ "\"priceList\" = " + priceList);
		boolean deleted = priceService.removePrice(brandId, productId, priceList);
		return deleted;
	}

}
