package com.bgi.ms.engine.base.bean.email;

import java.util.Arrays;
import java.util.Map;
/**
 * 发送邮件入参
 * @author yeyuanchun
 *
 */
public class EmailParameter {
	private String email;//已在数据字典配置的邮箱账号
	private EmailConfig emailConfig;//未在数据字典配置的完整邮箱账号信息
	private String[] toEmails;//邮箱收件人列表
	private String[] ccEmails;//抄送收件人列表
	private String[] bccEmails;//秘密抄送收件人列表
	private String subject;//邮件标题
	private String context;//邮件内容
	private String templateId;//邮件模板ID
	private Map<String, Object> object;//邮件模板参数对象
	private String[] attachments;//邮件附件列表
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EmailConfig getEmailConfig() {
		return emailConfig;
	}
	public void setEmailConfig(EmailConfig emailConfig) {
		this.emailConfig = emailConfig;
	}
	public String[] getToEmails() {
		return toEmails;
	}
	public void setToEmails(String[] toEmails) {
		this.toEmails = toEmails;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public Map<String, Object> getObject() {
		return object;
	}
	public void setObject(Map<String, Object> object) {
		this.object = object;
	}
	public String[] getAttachments() {
		return attachments;
	}
	public void setAttachments(String[] attachments) {
		this.attachments = attachments;
	}
	public String[] getCcEmails() {
		return ccEmails;
	}
	public void setCcEmails(String[] ccEmails) {
		this.ccEmails = ccEmails;
	}
	public String[] getBccEmails() {
		return bccEmails;
	}
	public void setBccEmails(String[] bccEmails) {
		this.bccEmails = bccEmails;
	}
	@Override
	public String toString() {
		return "EmailParameter [email=" + email + ", emailConfig=" + emailConfig + ", toEmails="
				+ Arrays.toString(toEmails) + ", ccEmails=" + Arrays.toString(ccEmails) + ", bccEmails="
				+ Arrays.toString(bccEmails) + ", subject=" + subject + ", context=" + context + ", templateId="
				+ templateId + ", object=" + object + ", attachments=" + Arrays.toString(attachments) + "]";
	}
	
}
