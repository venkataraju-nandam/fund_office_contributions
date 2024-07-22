package com.fundoffice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDiscount {
 
     public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	Integer discount = 0;
}
