package com.pvpmanager.springboot.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Price>> getPrices() {
		logger.info("getPrices method invoked");
		List<Price> prices = priceService.getPrices();
		if (prices == null) {
			return new ResponseEntity<List<Price>>(HttpStatus.NOT_FOUND);
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(prices);
		}
		
	}
	
	@PostMapping(value="price")
	public ResponseEntity<Price> addPrice(@RequestBody Price price)  {
		logger.info("addPrice method invoked");
		Price p = priceService.addPrice(price);
		if (p == null) {
			return new ResponseEntity<Price>(HttpStatus.NOT_FOUND);
		}
		else {
			return ResponseEntity.status(HttpStatus.CREATED).body(p);
		}
	}
	
	@PutMapping(value="price")
	public ResponseEntity<Price> updatePrice(@RequestBody Price price)  {
		logger.info("updatePrice method invoked");
		Price p = priceService.addPrice(price);
		if (p == null) {
			return new ResponseEntity<Price>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(p);
		}
	}
	
	@DeleteMapping(value="price/{brandId}/{productId}/{priceList}" )
	public ResponseEntity<Boolean> deletePrice(
			@PathVariable(value="brandId") Integer brandId, 
			@PathVariable(value="productId") Integer productId,
			@PathVariable(value="priceList") Integer priceList) {
		logger.info("deletePrice method invoked");
		logger.info("parameters received => "
				+ "\"brandId\" = " + brandId + ", "
				+ "\"productId\" = " + productId + ", "
				+ "\"priceList\" = " + priceList);
		Boolean deleted = priceService.removePrice(brandId, productId, priceList);
		if (!deleted) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(deleted);
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(deleted);
		}
	}

}
