package com.pvpmanager.springboot.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pvpmanager.springboot.app.model.entitys.PvpResponse;
import com.pvpmanager.springboot.app.model.service.IPriceService;

@RestController
@RequestMapping (value="pvp-manager")
public class PvpApiController implements PvpApi {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IPriceService priceService;
	
	
	@GetMapping(value="pvp/{brandId}/{productId}/{date}" )
	public PvpResponse getPvp(
				@PathVariable(value="brandId") Integer brandId, 
				@PathVariable(value="productId") Integer productId,			
				@PathVariable(value="date") String date) {
		logger.info("getPvp method invoked");
		logger.info("parameters received => "
				+ "\"brandId\" = " + brandId + ", "
				+ "\"productId\" = " + productId + ", "
				+ "\"date\" = " + date);
		return priceService.getPvp(brandId, productId, date);
	}
	
		
}
