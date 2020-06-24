package com.bgi.ms.engine.base.bean.product;

import java.util.List;

import com.google.gson.annotations.SerializedName;
/**
 * 模板信息
 * @author yeyuanchun
 *
 */
public class TemplateInfo {
	@SerializedName("TEMPLATE_ID")
	private String templateId;//模板ID
	@SerializedName("CONDITIONS")
	private List<Condition> conditions;//模板生效条件
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public List<Condition> getConditions() {
		return conditions;
	}
	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}
	
}
