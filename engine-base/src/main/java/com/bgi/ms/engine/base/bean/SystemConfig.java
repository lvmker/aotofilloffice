package com.bgi.ms.engine.base.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 对接系统配置信息
 * @author yeyuanchun
 *
 */
public class SystemConfig {
	private String systemCode;//系统编号
	private String systemName;//系统名称
	private String secret;//系统秘钥
	private String cron;//推送计划
	private String scanType;//推送类型
	private String routingKey;//推送路由
	private String status;//系统状态
	public interface STATUS{
		public static String FROZEN="-1";//停用状态
		public static String CLOSED="0";//普通状态（关闭主动推送）
		public static String OPEN="1";//开启主动推送状态
	}
	private Date updateTime;//最后更新时间
	private String orderUpdateTime;//订单更新时间
	private List<String> roles=new ArrayList<>();
	private List<String> citys=new ArrayList<>();//权限-城市  1-城市  2-客户编码 3-数据来源 4-产品线  5 产品编码
	private List<String> customerCodes=new ArrayList<>();//权限-城市 1-城市  2-客户编码 3-数据来源 4-产品线  5 产品编码
	private List<String> dataSources=new ArrayList<>();//权限-城市 1-城市  2-客户编码 3-数据来源 4-产品线  5 产品编码
	private List<String> productLines=new ArrayList<>();//权限-城市 1-城市  2-客户编码 3-数据来源 4-产品线  5 产品编码
	private List<String> productCodes=new ArrayList<>();//权限-城市 1-城市  2-客户编码 3-数据来源 4-产品线  5 产品编码
	private Date startTime;//结束时间
	private Date endTime;//开始时间
	
	/**
	 * 报告推送地址--客户端的接口地址
	 * 用于当用户需要我们主动推送报告文件
	 */
	private String pushURL;
	
	public void addRole(String type,String role) {
		if("1".equals(type)) {
			citys.add(role);
		}else if("2".equals(type)) {
			customerCodes.add(role);
		}else if("3".equals(type)) {
			dataSources.add(role);
		}else if("4".equals(type)) {
			productLines.add(role);
		}else if("5".equals(type)) {
			productCodes.add(role);
		}
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public List<String> getCitys() {
		return citys;
	}
	public void setCitys(List<String> citys) {
		this.citys = citys;
	}
	public List<String> getCustomerCodes() {
		return customerCodes;
	}
	public void setCustomerCodes(List<String> customerCodes) {
		this.customerCodes = customerCodes;
	}
	public List<String> getDataSources() {
		return dataSources;
	}
	public void setDataSources(List<String> dataSources) {
		this.dataSources = dataSources;
	}
	public List<String> getProductLines() {
		return productLines;
	}
	public void setProductLines(List<String> productLines) {
		this.productLines = productLines;
	}
	public List<String> getProductCodes() {
		return productCodes;
	}
	public void setProductCodes(List<String> productCodes) {
		this.productCodes = productCodes;
	}
	public String getSystemCode() {
		return systemCode;
	}
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getCron() {
		return cron;
	}
	public void setCron(String cron) {
		this.cron = cron;
	}
	public String getScanType() {
		return scanType;
	}
	public void setScanType(String scanType) {
		this.scanType = scanType;
	}
	public String getRoutingKey() {
		return routingKey;
	}
	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getOrderUpdateTime() {
		return orderUpdateTime;
	}
	public void setOrderUpdateTime(String orderUpdateTime) {
		this.orderUpdateTime = orderUpdateTime;
	}
	
	public String getPushURL() {
		return pushURL;
	}
	public void setPushURL(String pushURL) {
		this.pushURL = pushURL;
	}
	@Override
	public String toString() {
		return "SystemConfig [systemCode=" + systemCode + ", systemName=" + systemName + ", secret=" + secret
				+ ", cron=" + cron + ", scanType=" + scanType + ", routingKey=" + routingKey + ", status=" + status
				+ ", updateTime=" + updateTime + ", orderUpdateTime=" + orderUpdateTime + ", roles=" + roles
				+ ", citys=" + citys + ", customerCodes=" + customerCodes + ", dataSources=" + dataSources
				+ ", productLines=" + productLines + ", productCodes=" + productCodes + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", pushURL=" + pushURL + "]";
	}
	
}
