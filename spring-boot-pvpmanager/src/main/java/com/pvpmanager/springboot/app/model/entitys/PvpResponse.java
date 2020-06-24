package com.pvpmanager.springboot.app.model.entitys;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

public class PvpResponse {

	@Schema(description = "Id of the priceList.", 
            example = "2", required = true)
	private Integer priceList;
	
	@Schema(description = "Id of the brandId.", 
            example = "1", required = true)
	private Integer brandId;	
	
	@Schema(description = "Id of the productId.", 
            example = "35455", required = true)
	private Integer productId;	
	
	@Schema(description = "Start date of the priceList.", 
            example = "2020-06-14-15.00.00", required = true)
	private LocalDateTime startDate;	
	
	@Schema(description = "End date of the priceList.", 
            example = "2020-12-31-23.59.59", required = true)
	private LocalDateTime endDate;	
	
	@Schema(description = "Final sale price", 
            example = "25.45", required = true)
	private Double price;	
	
	@Schema(description = "Currency ISO code", 
            example = "EUR", required = true)
	private String currency;
	
	
	public PvpResponse(Integer priceList, Integer brandId, Integer productId, LocalDateTime startDate,
			LocalDateTime endDate, Double price, String currency) {
		this.priceList = priceList;
		this.brandId = brandId;
		this.productId = productId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.currency = currency;
	}

	public Integer getPriceList() {
		return priceList;
	}
	
	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}
	
	public Integer getBrandId() {
		return brandId;
	}
	
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	
	public Integer getProductId() {
		return productId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public LocalDateTime getStartDate() {
		return startDate;
	}
	
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	
	public LocalDateTime getEndDate() {
		return endDate;
	}
	
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}	
	
}
