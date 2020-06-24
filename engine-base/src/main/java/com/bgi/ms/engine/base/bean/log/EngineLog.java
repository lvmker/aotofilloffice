package com.bgi.ms.engine.base.bean.log;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class EngineLog {
	public EngineLog(String logType,String operationType,String operator,String logTime) {
		this.logType=logType;
		this.logTime=logTime;
		this.operator=operator;
		this.operationType=operationType;
	}
	public EngineLog() {
		
	}
	public EngineLog(String logType,String operationType,String logTime,String operator,String SAMPLE_NUM,String sampleNumber,String currentTask,String TASK_ORDER_NUM,String handingType) {
		this.logType=logType;
		this.logTime=logTime;
		this.operator=operator;
		this.operationType=operationType;
		this.SAMPLE_NUM=SAMPLE_NUM;
		this.sampleNumber=sampleNumber;
		this.currentTask=currentTask;
		this.TASK_ORDER_NUM=TASK_ORDER_NUM;
		this.handingType=handingType;
	}
	public EngineLog addLogContexts(Map<String, Object> params) {
		this.logInfos=params;
		return this;
	}
	public EngineLog logInfoFilter(HashSet<String> filters) {
		HashMap<String, Object> filterLogInfos=new HashMap<>();
		for(String key:filters) {
			if(this.logInfos.containsKey(key)) {
				filterLogInfos.put(key, this.logInfos.get(key));
			}
		}
		this.logInfos=filterLogInfos;
		return this;
	}
	public EngineLog addLogContext(String key,Object context) {
		this.logInfos.put(key, context);
		return this;
	}
	private String logType;//日志类型
	private String operationType;//操作类型
	private String logTime;//日志时间
	private String operator;//操作用户
	private String SAMPLE_NUM;//样本编号
	private String sampleNumber;//样本别名
	private String currentTask;//当前工序
	private String TASK_ORDER_NUM;//任务单编号
	private String handingType;//异常处理方式
	private Map<String, Object> logInfos=new HashMap<>();//日志信息
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	public String getLogTime() {
		return logTime;
	}
	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Map<String, Object> getLogInfos() {
		return logInfos;
	}
	public void setLogInfos(Map<String, Object> logInfos) {
		this.logInfos = logInfos;
	}
	
	public String getOperationType() {
		return operationType;
	}
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	
	public String getSAMPLE_NUM() {
		return SAMPLE_NUM;
	}
	public void setSAMPLE_NUM(String sAMPLE_NUM) {
		SAMPLE_NUM = sAMPLE_NUM;
	}
	public String getSampleNumber() {
		return sampleNumber;
	}
	public void setSampleNumber(String sampleNumber) {
		this.sampleNumber = sampleNumber;
	}
	public String getCurrentTask() {
		return currentTask;
	}
	public void setCurrentTask(String currentTask) {
		this.currentTask = currentTask;
	}
	public String getTASK_ORDER_NUM() {
		return TASK_ORDER_NUM;
	}
	public void setTASK_ORDER_NUM(String tASK_ORDER_NUM) {
		TASK_ORDER_NUM = tASK_ORDER_NUM;
	}
	public String getHandingType() {
		return handingType;
	}
	public void setHandingType(String handingType) {
		this.handingType = handingType;
	}
	@Override
	public String toString() {
		return "EngineLog [logType=" + logType + ", operationType=" + operationType + ", logTime=" + logTime
				+ ", operator=" + operator + ", SAMPLE_NUM=" + SAMPLE_NUM + ", sampleNumber=" + sampleNumber
				+ ", currentTask=" + currentTask + ", TASK_ORDER_NUM=" + TASK_ORDER_NUM + ", handingType=" + handingType
				+ ", logInfos=" + logInfos + "]";
	}
	/**
	 * 日志类型
	 * @author yeyuanchun
	 *
	 */
	public interface LOG_TYPE{
		public static String CASE_LOG="CASE_LOG";//案件
		public static String SUBCASE_LOG="SUBCASE_LOG";//子案件
		public static String SAMPLE_LOG="SAMPLE_LOG";//样本
		public static String TASK_LOG="TASK_LOG";//任务
		public static String REPORT_LOG="REPORT_LOG";//报告
		
	}
	public interface OPERATION_TYPE{
		public static String CREATE="CREATE";//创建
		public static String DELETE="DELETE";//删除
		public static String UPDATE="UPDATE";//更新
	}
	
	public interface SAMPLE_OPERATION_TYPE{
		public static String CREATE="CREATE";//创建
		public static String DELETE="DELETE";//删除
		public static String UPDATE="UPDATE";//更新
		public static String ALLOT="ALLOT";//下达
		public static String FINISH="FINISH";//完成
		public static String ROUTING="ROUTING";//确认工艺路线
		public static String EXCEPTION="EXCEPTION";//标记异常
		public static String CHANGETASK="CHANGETASK";//转发合并
		public static String HANDING="HANDING";//异常处理
	}
}
