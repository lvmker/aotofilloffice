package com.bgi.ms.engine.base.bean;

public interface ReportState {
	public static String UNAUDITED="UNAUDITED";//已生成，未复核
	public static String AUDIT_PASS="AUDIT_PASS";//审核已通过
	public static String AUDIT_FAILED="AUDIT_FAILED";//审核未通过
	public static String SENT="SENT";//报告已发放
	public static String ABANDON="ABANDON";//报告废弃
}
