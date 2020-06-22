package com.pvpmanager.springboot.app.model.dao;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pvpmanager.springboot.app.model.entitys.Price;
import com.pvpmanager.springboot.app.model.entitys.PriceId;

public interface IPriceDao extends CrudRepository<Price, PriceId> {

	@Query(value = "SELECT * FROM PRICES where BRAND_ID=:brandId AND PRODUCT_ID=:productId AND :date >= START_DATE AND :date <= END_DATE ORDER BY PRIORITY DESC LIMIT 1",
            nativeQuery = true)
	public Price getPvp(
			@Param("brandId") Integer brandId, 
			@Param("productId") Integer productId,
			@Param("date") LocalDateTime date);

}