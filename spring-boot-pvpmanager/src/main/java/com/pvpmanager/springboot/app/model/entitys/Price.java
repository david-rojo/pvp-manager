package com.pvpmanager.springboot.app.model.entitys;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(PriceId.class)
@Table(name="PRICES")
public class Price implements Serializable {

	private static final long serialVersionUID = -4552391064110119266L;

	@Id
	@Column(name="PRICE_LIST")
	private Integer priceList;
	
	@Id
	@Column(name="BRAND_ID")
	private Integer brandId;
	
	@Id
	@Column(name="PRODUCT_ID")
	private Integer productId;
	
	@Column(name="START_DATE")
	private LocalDateTime startDate;
	
	@Column(name="END_DATE")
	private LocalDateTime endDate;
	
	@Column(name="PRIORITY")
	private Integer priority;
	
	@Column(name="PRICE")
	private Double price;
	
	@Column(name="CURR")
	private String currency;

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

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
