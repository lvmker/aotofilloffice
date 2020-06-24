package com.bgi.ms.engine.base.bean;

import java.util.Map;

public class OpenofficeRequestParamer {
	private String fileName;//
	private String formatFileName;//
	private Map<String, Object> attributes;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFormatFileName() {
		return formatFileName;
	}
	public void setFormatFileName(String formatFileName) {
		this.formatFileName = formatFileName;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	
}
