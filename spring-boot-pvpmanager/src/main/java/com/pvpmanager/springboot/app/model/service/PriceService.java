package com.pvpmanager.springboot.app.model.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pvpmanager.springboot.app.model.dao.IPriceDao;
import com.pvpmanager.springboot.app.model.entitys.Price;
import com.pvpmanager.springboot.app.model.entitys.PriceId;
import com.pvpmanager.springboot.app.model.entitys.PvpResponse;

@Service
public class PriceService implements IPriceService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${pvpmanager.date.format.pattern}")
	private String dateFormatPattern;
	
	@Autowired
	private IPriceDao priceDao;

	@Override
	public PvpResponse getPvp(Integer brandId, Integer productId, String date) {
		PvpResponse pvpResponse = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatPattern); 
		LocalDateTime ldtDate = LocalDateTime.parse(date, formatter);
		
		Price p = priceDao.getPvp(brandId, productId, ldtDate);
		
		if (p != null) {
			pvpResponse = new PvpResponse(
					p.getPriceList(), 
					p.getBrandId(),
					p.getProductId(),
					p.getStartDate(),
					p.getEndDate(),
					p.getPrice(),
					p.getCurrency());
		}
		else {
			logger.warn("Any price found in database");
		}
		return pvpResponse;
	}
	
	@Override
	public List<Price> getPrices() {
		return (List<Price>) priceDao.findAll();
	}

	@Override
	public Price addPrice(Price price) {
		return priceDao.save(price);
	}

	@Override
	public void removePrice(Integer brandId, Integer productId, Integer priceList) {
		priceDao.deleteById(new PriceId(brandId, productId, priceList));
	}

	@Override
	public Price updatePrice(Price price) {
		return priceDao.save(price);
	}



}
