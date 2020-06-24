package com.bgi.ms.engine.base.bean.email;

import com.google.gson.annotations.SerializedName;

public class EmailConfig {
	@SerializedName("EMAIL_HOST")
	private String host;//邮箱服务器IP
	@SerializedName("EMAIL_PORT")
	private String port;//邮箱服务器端口
	@SerializedName("dicItemCode")
	private String email;//邮箱账号
	@SerializedName("dicItemName")
	private String desc;//邮箱描述
	@SerializedName("EMAIL_PWD")
	private String password;//邮箱密码（QQ等邮箱为授权码）
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "EmailConfig [host=" + host + ", port=" + port + ", email=" + email + ", desc=" + desc + ", password="
				+ password + "]";
	}
	
}
