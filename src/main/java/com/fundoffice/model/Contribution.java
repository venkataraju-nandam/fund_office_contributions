package com.fundoffice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contribution {
 
	Integer contribution = 0;

	public Integer getContribution() {
		return contribution;
	}

	public void setContribution(Integer contribution) {
		this.contribution = contribution;
	}
}
