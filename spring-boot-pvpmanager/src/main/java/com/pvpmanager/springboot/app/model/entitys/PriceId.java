package com.pvpmanager.springboot.app.model.entitys;

import java.io.Serializable;

public class PriceId implements Serializable {

	private static final long serialVersionUID = 3565353301766953423L;

	private Integer priceList;
	private Integer productId;
	private Integer brandId;
	
	public PriceId() {
		
	}
	
	public PriceId(Integer brandId, Integer productId, Integer priceList) {
		this.brandId = brandId;
		this.productId = productId;
		this.priceList = priceList;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brandId == null) ? 0 : brandId.hashCode());
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        result = prime * result + ((priceList == null) ? 0 : priceList.hashCode());
        return result;
    }
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PriceId other = (PriceId) obj;
        if (brandId == null) {
            if (other.brandId != null)
                return false;
        } else if (!brandId.equals(other.brandId))
            return false;
        if (productId == null) {
            if (other.productId != null)
                return false;
        } else if (!productId.equals(other.productId))
            return false;
        if (priceList == null) {
            if (other.priceList != null)
                return false;
        } else if (!priceList.equals(other.priceList))
            return false;
        return true;
    }
	
}
