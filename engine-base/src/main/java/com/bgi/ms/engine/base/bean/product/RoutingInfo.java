package com.bgi.ms.engine.base.bean.product;

import java.util.List;

import com.google.gson.annotations.SerializedName;
/**
 * 工艺路线信息
 * @author yeyuanchun
 *
 */
public class RoutingInfo {
	@SerializedName("ROUTING")
	private String routing;//工艺路线
	@SerializedName("CONDITIONS")
	private List<Condition> conditions;//工艺路线生效条件
	
	public String getRouting() {
		return routing;
	}
	public void setRouting(String routing) {
		this.routing = routing;
	}
	public List<Condition> getConditions() {
		return conditions;
	}
	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}
}
