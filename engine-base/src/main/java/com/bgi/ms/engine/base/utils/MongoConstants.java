package com.bgi.ms.engine.base.utils;

public class MongoConstants {
	/**
	 * 接案数据库定义
	 * @author yeyuanchun
	 *
	 */
	public interface DATABASE_NAME{
		public static String CASE_MANAGER_DATABASE="engine";//案件数据库
		public static String ROUTING_DATABASE="engine";//案件数据库
		public static String RESOURCE_DATABASE="engine";//资源管理数据库
		public static String RESULT_ANALYSIS="resultAnalysis";//资源管理数据库
	}
	
	/**
	 * 接案数据库集合定义
	 * @author yeyuanchun
	 *
	 */
	public interface COLLECTION_NAME{
		public static String CASE_MANAGER_CASE="case";//案件表
		public static String CASE_MANAGER_SUBCASE="subcase";//子案件表
		public static String CASE_MANAGER_SAMPLE="sample";//样本表
//		public static String ROUTING_ZBGIN_EXCEPTION_ORDER="ZBGIN_EXCEPTION_ORDER";//异常单表
		public static String ROUTING_ZBGIN_TASK_ORDER="ZBGIN_TASK_ORDER";//任务单表
//		public static String ROUTING_ZBGIN_RESULT_ORDER="ZBGIN_RESULT_ORDER";//结果单表
//		public static String ROUTING_ZBGIN_ROUTING="ZBGIN_ROUTING";//routing任务表
		public static String ROUTING_ZBGIN_GX_CFIG="ZBGIN_GX_CFIG";//
		public static String ROUTING_ZBGIN_GX_FIELD="ZBGIN_GX_FIELD";//
		public static String RESOURCE_MANAGER_MACHINE="machine";//机器表
		public static String RESOURCE_MANAGER_MATERIAL="material";//库存表
		public static String RESOURCE_MANAGER_MATERIAL_STOCK="material_stock";//库存记录表
		public static String REPORT_MANAGER_REPORT="report";//报告表
		public static String REPORT_MANAGER_TEMPLATE="report_template";//模板表
		public static String LOG="engine_log";//日志表
		public static String CANTON="canton";//省市表
		public static String PROMISE_ORDER="promiseOrder";//觅童订单表
		public static String GBI_SAMPLE="gbi_sample";//新筛样本表
		public static String GBI_CASE="gbi_case";//新筛案件表
		public static String GBI_SUBCASE="gbi_subcase";//新筛子案件案件表
		public static String GBI_REPORT="gbi_report";//新筛子案件案件表

	}
	
	public interface DICTIONARY_FIELD{
		public static String DICTIONARY_CODE="dicItemCode";//参数对象
		public static String DICTIONARY_NAME="dicItemName";//过滤参数
		public static String DICTIONARY_NUM="dicItemNum";//过滤参数
		public static String DIC_CODE="dicCode";//过滤参数
	}
	
	/**
	 * 通用请求常量定义
	 * @author yeyuanchun
	 *
	 */
	public interface REQUEST_PARAMETER_FIELD{
		public static String OBJECTS="OBJECTS";//参数对象
		public static String OPTIONS="OPTIONS";//过滤参数
		public static String FIELDS="FIELDS";//字段定义
	}
	/**
	 * 接案数据库常量定义
	 * @author yeyuanchun
	 *
	 */
	
	public interface CASE_MANAGER_FIELD{
		public static String CASE="CASE";//案件
		public static String SAMPLES="SAMPLES";//样本列表
		public static String SAMPLE="SAMPLE";//样本
		public static String SUB_CASES="SUB_CASES";//子案件对象列表
		public static String CASE_NUM="CASE_NUM";//案件编号
		public static String CASE_NUMS="CASE_NUMS";//案件编号列表
		public static String SAMPLE_NUMS="SAMPLE_NUMS";//样本编号列表
		public static String SAMPLE_NUM="SAMPLE_NUM";//样本编号
		public static String SAMPLE_ALIAS="sampleNumber";//样本别名
		public static String SUBCASE_ALIAS="caseNumber";//案件别名
		public static String SUBCASE_NUM="SUBCASE_NUM";//子案件编号
		public static String SUBCASE_NUMS="SUBCASE_NUMS";//
		public static String ORDER_NUM="ORDER_NUM";//订单编号
		public static String SUBCASE_STATE="SUBCASE_STATE";//子案件状态
		public static String SAMPLE_STATE="SAMPLE_STATE";//样本状态
		public static String PRODUCTION="CPLX";//产品信息
		public static String PRODUCT_CODE="dicItemCode";//产品编码
		public static String CALCULATE_RESULT="CALCULATE_RESULT";//计算结果
		
		public static String PREVIEW_WORD_URL="PREVIEW_WORD_URL";//委托书word文件地址
		public static String PREVIEW_TEMPLATE_URL="PREVIEW_TEMPLATE_URL";//委托书预览文件地址
		public static String ROUTING="ROUTING";//工艺路线
		public static String SUBCASE_SAMPLE_EXCEPTION="SUBCASE_SAMPLE_EXCEPTION";//样本信息异常内容（影响状态，不进入生产）
		public static String SUBCASE_PROFILE_EXCEPTION="SUBCASE_PROFILE_EXCEPTION";//案件信息异常内容（不影响状态，可进入生产）
		public static String SUBCASE_UNCOMPLETED="SUBCASE_UNCOMPLETED";//案件信息不完整
		public static String SUBCASE_RECEIVED_TIME="SUBCASE_RECEIVED_TIME";//案件受理时间
		public static String PROFILE_REPLACEMENT_STATE="PROFILE_REPLACEMENT_STATE";//资料补寄状态
		public static String SAMPLE_REPLACEMENT_STATE="SAMPLE_REPLACEMENT_STATE";//样本补寄状态
		public static String PROFILE_EXPRESS_NUMBER="PROFILE_EXPRESS_NUMBER";//资料补寄单号
		public static String SAMPLE_EXPRESS_NUMBER="SAMPLE_EXPRESS_NUMBER";//样本补寄单号
		public static String SUBCASE_EXCEPTION_STATE="SUBCASE_EXCEPTION_STATE";//子案件异常状态
		public static String REPORT_NUM="REPORT_NUM";//报告编号
		public static String REPORT="REPORT";//报告
		public static String REPORTS="REPORTS";//报告列表
		
		public static String FAILED_TASK_ORDER="FAILED_TASK_ORDER";//上传失败任务单
		public static String EQUAL_SAMPLE="EQUAL_SAMPLE";//位点信息一致样本
		public static String SIMILAR_SAMPLE="SIMILAR_SAMPLE";//疑似亲缘关系样本
		public static String IS_UPLOAD="IS_UPLOAD";//是否本次上传标识
		public static String ERROR_DESC="ERROR_DESC";//错误描述
		public static String MD5="MD5";//MARKERS MD5
		public static String ADD_MD5="ADD_MD5";//ADD_MARKERS MD5
		public static String MARKERS="MARKERS";//最终位点信息
		public static String ADD_MARKERS="ADD_MARKERS";//加测最终位点
		public static String MARKERS_1="MARKERS_1";//初次上传位点信息
		public static String MARKERS_2="MARKERS_2";//再次上传位点信息
		public static String ADD_MARKERS_1="ADD_MARKERS_1";//加测初次上传位点信息
		public static String ADD_MARKERS_2="ADD_MARKERS_2";//加测再次上传位点信息
		public static String IS_MARKERS_MATCHED="IS_MARKERS_MATCHED";//两次上传数据是否一致
		public static String IDENTIFYTYPE = "identifyType";//是什么报告，检还是鉴
		public static String CPLX = "CPLX";//产品类型，新的改动，替换了PRODUCTION
		public static String  SUBCASE_EXCEPTION_DESC = "SUBCASE_EXCEPTION_DESC";//报告异常描述
		public static String NBJG = "NBJG";//内部机构
		public static String CHARGEAMOUNT = "chargeAmount";//应收款,收费金额
		public static String RESULTNOTICEDATE = "resultNoticeDate";//结果通知时间
		public static String SALEMODEL = "SALEMODEL";//代理和自营
		public static String DLJG = "DLJG";//代理机构
		public static String IDENTIFYPURPOSE = "IDENTIFYPURPOSE";//鉴定用途


	}
	
	
	/**
	 * @Author luojiwen
	 * @Description 司法样本表字段
	 * @Date 14:16 2020/4/1
	 * @param 
	 * @return 
	 */
	public interface SAMPLE_MANAGER_FIELD{
		//样本姓名
		public static String SAMPLENAME = "sampleName";
		//样本编号
		public static String SAMPLE_NUM = "SAMPLE_NUM";
		//样本别名
		public static String SAMPLENUMBER = "sampleNumber";
		//试剂盒
		public static String KIT  = "KIT";
		//性别
		public static String SAMPLERELATION  = "SAMPLERELATION";
		//出生日期
		public static String BIRTHDAY  = "birthday";
		//有效证件号码
		public static String CERTNUM  = "certNum";
		//MARKERS,复核之后的
		public static String MARKERS  = "MARKERS";


	}

	/**
	 * 资源管理字段
	 * @author yeyuanchun
	 *
	 */
	public interface RESOURCE_FIELD{
		public static String MACHINE_CODE="MACHINE_CODE";//机器编码
		public static String MATERIAL_CODE="MATERIAL_CODE";//物料编码
		public static String MATERIAL_STOCK="MATERIAL_STOCK";//物料库存
		public static String MATERIAL_STOCK_CODE="MATERIAL_STOCK_CODE";//物料批次编码
		public static String MATERIAL_BATCH_STOCK="MATERIAL_BATCH_STOCK";//物料批次原始库存
		public static String MATERIAL_STOCK_TYPE="MATERIAL_STOCK_TYPE";//物料库存类型  X-新增  N-消耗
	}
	/**
	 * 实验生产字段
	 * @author yeyuanchun
	 *
	 */
	public interface ROUTING_FIELD{
		public static String EXCEPTION_ORDER_NUM="EXCEPTION_ORDER_NUM";//异常单编号
		public static String ZGXBH="zgxbh";//
		public static String FLD_ID="FLD_ID";//
		public static String RESULT_ORDER_NUM="RESULT_ORDER_NUM";//结果单编号
		public static String TASK_ORDER_NUM="TASK_ORDER_NUM";//任务单编号
		public static String TASK_INDEX="TASK_INDEX";//任务序号
		public static String TASK_NUM="TASK_NUM";//任务编码
		public static String TASK_EXCEPTION="TASK_EXCEPTION";//异常描述
		public static String EXCEPTION_OPERATION="EXCEPTION_OPERATION";//异常处理
		public static String GOTO_INDEX="GOTO_INDEX";//发回工序位置
		public static String TASK_GROUP="TASK_GROUP";//
		public static String ZKYKS="ZKYKS";//
		public static String ZSFXD="ZSFXD";//
		public static String ZSFKS="ZSFKS";//
		public static String ZSFWC="ZSFWC";//
		public static String ZSFYC="ZSFYC";//
		public static String ZGXZH="zgxzh";//
		public static String TASKS="TASKS";//
		public static String GX_FIELDS="gx_fields";//
		public static String KIT="KIT";//试剂盒
		public static String EXT_METHOD="EXT_METHOD";//提取方法
		public static String PCR_METHOD="PCR_METHOD";//扩增方法
		public static String EXPERIMENTER="EXPERIMENTER";//实验员
		public static String CURRENT_INDEX="CURRENT_INDEX";//当前工序序号
		public static String CURRENT_TASK="CURRENT_TASK";//当前工序
		public static String KITADD="KITADD";//加测试剂盒
		public static String PCR_METHOD_ADD="PCR_METHOD_ADD";//加测扩增方法
		
		public static String FGI005="FGI005";//亲子数据上传工序
		public static String FGI006="FGI006";//亲子数据复核工序
		public static String FGI019="FGI019";//母血分型数据上传工序
		public static String FGI024="FGI024";//加测亲子数据上传工序
		public static String FGI025="FGI025";//加测数据复核工序
	}
	
	public interface STATE_VALUE{
		public static String YES="X";//
		public static String NO="N";//
	}
	/**
	 * 报告表字段
	 * @author yeyuanchun
	 *
	 */
	public interface REPORT_FIELD{
		public static String REPORT_NUM="REPORT_NUM";//报告编号
		public static String REPORT_URL="REPORT_URL";//报告生成的路径
		public static String REPORT_STATE="REPORT_STATE";//报告状态
		public static String AUDIT_DESC="AUDIT_DESC";//审核意见
		public static String REPORTPDF_URL="REPORTPDF_URL";//报告PDF生成的路径
		public static String LAST_REPORT_URL="LAST_REPORT_URL";//第一次报告生成的路径
		public static String LAST_REPORTPDF_URL="LAST_REPORTPDF_URL";//第一次报告PDF生成的路径
		public static String CREATOR="CREATOR";//报告创建人
		public static String REPORT_HAS_SETTING="hasSetting";//报告是否设置过
		public static String REPORT_HAS_NOTIFIED="hasNotified";//报告是否通知过客户
		
		public static String REPORT_CREATE_DATE="REPORT_CREATE_DATE";//报告创建时间
		public static String REPORT_CREATE_STATE="REPORT_CREATE_STATE";//报告的状态
		public static String REPORT_CPI_TABLE_URL="REPORT_CPI_TABLE_URL";//CPI计算表的路径
		public static String Expected_Reporting_Time="ExpectedReportingTime";//报告预计发放时间

	}

	/**
	 * 模板表字段
	 * @author yeyuanchun
	 *
	 */
	public interface REPORT_TEMPLATE_FIELD{
		public static String TEMPLATE_ID="TEMPLATE_ID";//模板编号
		public static String TEMPLATE_DESC="TEMPLATE_DESC";//模板描述
		public static String TEMPLATE_URL="TEMPLATE_URL";//模板的路径
		public static String DEFINITION_URL="DEFINITION_URL";//定义文件模板路径
		public static String TEMPLATE_TYPE="TEMPLATE_TYPE";//模板的类型
		public static String TEMPLATEPDF_URL="TEMPLATEPDF_URL";//模板的PDF路径
		public static String LAST_TEMPLATE_URL="LAST_TEMPLATE_URL";//模板最后修改路径
		public static String LAST_DEFINITION_URL="LAST_DEFINITION_URL";//定义文件最后修改路径
	}
	
	/**
	 * 操作用户
	 * @author yeyuanchun
	 *
	 */
	public interface OPERATION_USER{
		public static String SUBCASE_CREATE_USER="SUBCASE_CREATE_USER";//案件录入人 
		public static String SUBCASE_REVIEW_USER="SUBCASE_REVIEW_USER";//资料核实人 
		public static String SUBCASE_IMPROVE_USER="SUBCASE_IMPROVE_USER";//资料补寄人
		public static String SUBCASE_EXCEPTION_HANDLE_USER="SUBCASE_EXCEPTION_HANDLE_USER";//案件异常处理人
		public static String SUBCASE_CALCULATE_USER="SUBCASE_CALCULATE_USER";//分型数据计算人
		public static String SUBCASE_EXCEPTION_USER="SUBCASE_EXCEPTION_USER";//案件异常标记人 
		
		public static String REPORT_CREATE_USER="REPORT_CREATE_USER";//报告生成人
		public static String REPORT_REVIEW_USER="REPORT_REVIEW_USER";//报告复核人
		public static String REPORT_EXCEPTION_HANDLE_USER="REPORT_EXCEPTION_HANDLE_USER";//报告异常处理人
		public static String REPORT_SEND_USER="REPORT_SEND_USER";//报告发放人
		
		public static String SAMPLE_EXCEPTION_USER="SAMPLE_EXCEPTION_USER";//样本异常标记人
		public static String SAMPLE_CREATE_USER="SAMPLE_CREATE_USER";//样本创建人
		public static String SAMPLE_ROUTING_USER="SAMPLE_ROUTING_USER";//工艺路线确定人
		public static String SAMPLE_DATA_UPLOAD_USER="SAMPLE_DATA_UPLOAD_USER";//分型数据上传人
		public static String SAMPLE_DATA_REUPLOAD_USER="SAMPLE_DATA_REUPLOAD_USER";//分型数据复核人
		public static String SAMPLE_DATA_CONFIRM_USER="SAMPLE_DATA_CONFIRM_USER";//分型数据确认人
		
		public static String TASK_FORWARD_USER="TASK_FORWARD_USER";//任务单转发人
		public static String TASK_ALLOT_USER="TASK_ALLOT_USER";//工序下达人
		public static String TASK_START_USER="TASK_START_USER";//工序开始人
		public static String TASK_FINISH_USER="TASK_FINISH_USER";//工序完成人
		public static String TASK_EXCEPTION_USER="TASK_EXCEPTION_USER";//任务标记异常人
		public static String TASK_EXCEPTION_HANDLE_USER="TASK_EXCEPTION_HANDLE_USER";//任务异常处理人
	}
	/**
	 * 操作时间
	 * @author yeyuanchun
	 *
	 */
	public interface OPERATION_TIME{
		public static String SUBCASE_CREATE_TIME="SUBCASE_CREATE_TIME";//案件录入时间 
		public static String SUBCASE_REVIEW_TIME="SUBCASE_REVIEW_TIME";//资料核实时间 
		public static String SUBCASE_IMPROVE_TIME="SUBCASE_IMPROVE_TIME";//资料补寄时间
		public static String SUBCASE_EXCEPTION_HANDLE_TIME="SUBCASE_EXCEPTION_HANDLE_TIME";//案件异常处理时间
		public static String SUBCASE_CALCULATE_TIME="SUBCASE_CALCULATE_TIME";//分型数据计算时间
		public static String SUBCASE_EXCEPTION_TIME="SUBCASE_EXCEPTION_TIME";//案件异常标记人
		
		public static String REPORT_CREATE_TIME="REPORT_CREATE_TIME";//报告生成时间
		public static String REPORT_REVIEW_TIME="REPORT_REVIEW_TIME";//报告复核时间
		public static String REPORT_EXCEPTION_HANDLE_TIME="REPORT_EXCEPTION_HANDLE_TIME";//报告异常处理时间
		public static String REPORT_SEND_TIME="REPORT_SEND_TIME";//报告发放时间
		
		
		public static String SAMPLE_EXCEPTION_TIME="SAMPLE_EXCEPTION_TIME";//样本异常时间
		public static String SAMPLE_CREATE_TIME="SAMPLE_CREATE_TIME";//样本创建时间
		public static String SAMPLE_ROUTING_TIME="SAMPLE_ROUTING_TIME";//工艺路线确定时间
		public static String SAMPLE_DATA_UPLOAD_TIME="SAMPLE_DATA_UPLOAD_TIME";//分型数据上传时间
		public static String SAMPLE_DATA_REUPLOAD_TIME="SAMPLE_DATA_REUPLOAD_TIME";//分型数据复核时间
		public static String SAMPLE_DATA_CONFIRM_TIME="SAMPLE_DATA_CONFIRM_TIME";//分型数据确认时间
		
		public static String TASK_FORWARD_TIME="TASK_FORWARD_TIME";//任务单转发时间
		public static String TASK_ALLOT_TIME="TASK_ALLOT_TIME";//工序下达时间
		public static String TASK_START_TIME="TASK_START_TIME";//工序开始时间
		public static String TASK_FINISH_TIME="TASK_FINISH_TIME";//工序完成时间
		public static String TASK_EXCEPTION_TIME="TASK_EXCEPTION_TIME";//任务标记异常时间
		public static String TASK_EXCEPTION_HANDLE_TIME="TASK_EXCEPTION_HANDLE_TIME";//任务异常处理时间
		public static String RESULTNOTICEDATE="resultNoticeDate";//结果通知时间


	}

	
	/**
	 * @Author YouMing Lin
	 * @Description  GBI_SAMPLE表字段
	 * @Date 15:21 2020/1/9
	 * @Param 
	 * @return 
	 **/
	public interface GBI_SAMPLE_FIELD{
		//样本编号
		public static String SAMPLENUM="SampleNum";
		//送检单位
		public static String UNIT="Unit";
		//送检科室
		public static String DEPARTMENT="Department";
		//新生儿姓名
		public static String NEWBORN="NewBorn";
		//性别女:0, 男:1
		public static String GENDER="Gender";
		//出生日期
		public static String BIRTHDATE="BirthDate";
		//母亲姓名
		public static String PARENTNAME="MName";
		//联系电话
		public static String PHONENUMBER="PhoneNumber";
		//门诊号/住院号
		public static String ADMISSIONNUMBER="AdmissionNumber";
		//采样日期
		public static String SAMPLINGDATE="SamplingDate";
		//样本类型
		public static String SELFCASETYPE="SelfcaseType";
		//指标
		public static String MARKERS="Markers";
		//样本状态
		public static String SAMPLE_STATUS="SampleStatus";
		//受检人（样本姓名）
		public static String SAMPLE_NAME="SampleName";
	}

	/**
	 * @Author YouMing Lin
	 * @Description GBI_SUBCASE表字段
	 * @Date 15:31 2020/1/9
	 * @Param
	 * @return
	 **/
	public interface GBI_SUBCASE_FIELD{
		//产品类型 DX0467新生儿48种遗传代谢病检测(串联质谱法) DX1376政府项目-新生儿48种遗传代谢病检测(串联质谱法)
		public static String CPLX="CPLX";
		//新生儿抗生素使用
		public static String ANTIBIOTICUSE="AntibioticUse";
		//新生儿补充胃肠外营养液(TPN)
		public static String NUTRIENTSOLUTION="NutrientSolution";
		//母亲碘接触式
		public static String IODINATED="Iodinated";
		//母亲是否有  甲亢, 甲低, 苯丙酮尿症, G6PD缺乏症, 肾上腺皮质增生, 其他
		public static String MWHETHER="Mwhether";
		//新生儿其他情况(体格检查、辅助检查)
		public static String NEWBORNOTHERS="NewbornOthers";
		//家族病史
		public static String FAMILYHISTORY="FamilyHistory";
		//患者共几名名
		public static String PATIENTNUM="PatientNum";
		//分别与新生儿关系
		public static String RELATION="Relation";
		//案件号
		public static String CASENUM="CaseNum";
		//样本编号list
		public static String SAMPLENUMS="SampleNums";
		//子案件编号
		public static String SUBCASENUM="SubcaseNum";
		//子案件创建时间
		public static String SUBCASECREATETIME="SubcaseCreateTime";
		//子案件状态
		public static String SUBCASESTATE="SubcaseState";
		//创建人
		public static String SUBCASECREATEUSER="SubcaseCreateUser";
		//样本信息
        public static String SAMPLES="Samples";

	}


	/**
	 * @Author luojiwen
	 * @Description 新筛报告表
	 * @Date 13:42 2020/1/10
	 * @param
	 * @return
	 */
	public interface GBI_REPORT_FIELD{
		//报告编号
		public static String REPORT_NUM="ReportNum";
		//报告地址
		public static String REPORT_WORD_URL="ReportWordUrl";
		//报告创建日期
		public static String REPORT_CREATE_DATE = "ReportCreateDate";
		//报告创建人
		public static String REPORT_CREATOR="ReportCreator";
		//报告对应的子案件编号
		public static String REPORT_SUBCASE="ReportSubCase";
		//报告的PDF地址
		public static String REPORT_PDF_URL="ReportPdfUrl";
	}
}
