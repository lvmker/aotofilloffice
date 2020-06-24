package com.bgi.ms.engine.base.bean.product;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * 计算方式
 * @author yeyuanchun
 *
 */
public class Calculation {
	@SerializedName("CALCULATION_CODE")
	private String calculationCode;//算法编码
	@SerializedName("CONDITIONS")
	private List<Condition> conditions;//算法生效条件
	
	public String getCalculationCode() {
		return calculationCode;
	}
	public void setCalculationCode(String calculationCode) {
		this.calculationCode = calculationCode;
	}
	public List<Condition> getConditions() {
		return conditions;
	}
	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}
	
}
