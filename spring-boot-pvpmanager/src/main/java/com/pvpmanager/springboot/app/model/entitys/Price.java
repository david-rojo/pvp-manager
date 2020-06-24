package com.pvpmanager.springboot.app.model.entitys;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@IdClass(PriceId.class)
@Table(name="PRICES")
public class Price implements Serializable {

	private static final long serialVersionUID = -4552391064110119266L;

	@Schema(description = "Id of the priceList.", 
            example = "2", required = true)
	@Id
	@Column(name="PRICE_LIST")
	private Integer priceList;
	
	@Schema(description = "Id of the brandId.", 
            example = "1", required = true)
	@Id
	@Column(name="BRAND_ID")
	private Integer brandId;
	
	@Schema(description = "Id of the productId.", 
            example = "35455", required = true)
	@Id
	@Column(name="PRODUCT_ID")
	private Integer productId;
	
	@Schema(description = "Start date of the priceList.", 
            example = "2020-06-14-15.00.00", required = true)
	@Column(name="START_DATE")
	private LocalDateTime startDate;
	
	@Schema(description = "End date of the priceList.", 
            example = "2020-12-31-23.59.59", required = true)
	@Column(name="END_DATE")
	private LocalDateTime endDate;
	
	@Schema(description = "Priority of the priceList (the higher value, the more priority.", 
            example = "1", required = true)
	@Column(name="PRIORITY")
	private Integer priority;
	
	@Schema(description = "Final sale price", 
            example = "25.45", required = true)
	@Column(name="PRICE")
	private Double price;
	
	@Schema(description = "Currency ISO code", 
            example = "EUR", required = true)
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
