package com.pvpmanager.springboot.app.model.entitys;

import java.time.LocalDateTime;

public class PvpResponse {

	private Integer priceList;
	private Integer brandId;	
	private Integer productId;	
	private LocalDateTime startDate;	
	private LocalDateTime endDate;	
	private Double price;	
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
