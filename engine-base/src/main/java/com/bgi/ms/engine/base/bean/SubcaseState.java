package com.bgi.ms.engine.base.bean;

public interface SubcaseState {
	//接案阶段状态
	public static String UNCONFIRMED="UNCONFIRMED";//案件未确认
	public static String INCOMPLETE="INCOMPLETE";//案件信息不完整
	//生产阶段状态
	public static String EXPERIMENTING="EXPERIMENTING";//实验中
	public static String UNCHECKED="UNCHECKED";//实验完成，数据未复核
	public static String UNREPORTED="UNREPORTED";//数据已复核，报告未生成

	//报告阶段状态
	public static String UNREVIEWED="UNREVIEWED";//报告已生成，报告未审核
//	public static String REPORTINCOMPLETE="INCOMPLETE";//第一份报告已经生成，正准备生成第二份最终报告//incomplete,残缺品
//	public static String EDITING="EDITING";//审核未通过，报告修改中
//	public static String REVIEWED="REVIEWED";//审核通过
//	public static String PUBLISHED="PUBLISHED";//报告最终生成（审核通过后自动生成最终版本报告）,报告尚未发放给用户
//	public static String FINISHED="FINISHED";//报告已经发放
	
	public static String EXCEPTION="EXCEPTION";//
	
	
	

}
