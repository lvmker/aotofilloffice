package com.bgi.ms.engine.base.bean;

import java.util.Map;

public class ReportRequestParameter {
	/**
	 * 模板编号
	 */
	private String templateId;
	/**
	 * 模板描述
	 */
	private String templateDesc;
	/**
	 * 模板路径
	 */
	private String templateURL;
	/**
	 * 定义文件路径
	 */
	private String definitionURL;
	private Map<String, Object> paramsObject;
	public ReportRequestParameter() {
	}
	public ReportRequestParameter(String templateId,Map<String, Object> paramsObject) {
		this.templateId=templateId;
		this.paramsObject=paramsObject;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplateDesc() {
		return templateDesc;
	}

	public void setTemplateDesc(String templateDesc) {
		this.templateDesc = templateDesc;
	}

	public String getTemplateURL() {
		return templateURL;
	}

	public void setTemplateURL(String templateURL) {
		this.templateURL = templateURL;
	}

	public String getDefinitionURL() {
		return definitionURL;
	}

	public void setDefinitionURL(String definitionURL) {
		this.definitionURL = definitionURL;
	}

	public Map<String, Object> getParamsObject() {
		return paramsObject;
	}
	public void setParamsObject(Map<String, Object> paramsObject) {
		this.paramsObject = paramsObject;
	}

	
}
