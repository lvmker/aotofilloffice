package com.bgi.ms.engine.base.bean;

import java.util.Map;

public class BaseRequestParameter {
	private SystemParams systemParams;//系统参数
	private Map<String, Object> applicationParams;//应用参数
	
	public SystemParams getSystemParams() {
		return systemParams;
	}
	public void setSystemParams(SystemParams systemParams) {
		this.systemParams = systemParams;
	}
	public Map<String, Object> getApplicationParams() {
		return applicationParams;
	}
	public void setApplicationParams(Map<String, Object> applicationParams) {
		this.applicationParams = applicationParams;
	}
	
	
}
