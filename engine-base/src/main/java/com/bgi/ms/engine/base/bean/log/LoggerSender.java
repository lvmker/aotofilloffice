package com.bgi.ms.engine.base.bean.log;
import java.util.HashSet;

import org.springframework.scheduling.annotation.Async;

import com.bgi.ms.engine.base.utils.MongoConstants;
public class LoggerSender {
	public LoggerSender(IEngineLogger engineLogger) {
		// TODO Auto-generated constructor stub
		loggerObservable=new LoggerObservable();
		loggerObserver=new LoggerObserver(engineLogger);
		loggerObservable.addObserver(loggerObserver);
		logFilters=new HashSet<>();
		logFilters.add(MongoConstants.CASE_MANAGER_FIELD.CASE_NUM);
		logFilters.add(MongoConstants.CASE_MANAGER_FIELD.SAMPLE_NUMS);
		logFilters.add(MongoConstants.CASE_MANAGER_FIELD.SAMPLE_NUM);
		logFilters.add(MongoConstants.CASE_MANAGER_FIELD.SUBCASE_NUM);
		logFilters.add(MongoConstants.CASE_MANAGER_FIELD.SUBCASE_STATE);
		logFilters.add(MongoConstants.CASE_MANAGER_FIELD.SAMPLE_STATE);
		logFilters.add(MongoConstants.CASE_MANAGER_FIELD.PROFILE_EXPRESS_NUMBER);
		logFilters.add(MongoConstants.CASE_MANAGER_FIELD.SAMPLE_EXPRESS_NUMBER);
		logFilters.add(MongoConstants.CASE_MANAGER_FIELD.SUBCASE_EXCEPTION_STATE);
		logFilters.add(MongoConstants.CASE_MANAGER_FIELD.REPORT_NUM);
		logFilters.add(MongoConstants.RESOURCE_FIELD.MACHINE_CODE);
		logFilters.add(MongoConstants.RESOURCE_FIELD.MATERIAL_CODE);
		logFilters.add(MongoConstants.RESOURCE_FIELD.MATERIAL_STOCK);
		logFilters.add(MongoConstants.RESOURCE_FIELD.MATERIAL_STOCK_CODE);
		logFilters.add(MongoConstants.RESOURCE_FIELD.MATERIAL_BATCH_STOCK);
		logFilters.add(MongoConstants.RESOURCE_FIELD.MATERIAL_STOCK_TYPE);
		logFilters.add(MongoConstants.ROUTING_FIELD.EXCEPTION_ORDER_NUM);
		logFilters.add(MongoConstants.ROUTING_FIELD.RESULT_ORDER_NUM);
		logFilters.add(MongoConstants.ROUTING_FIELD.TASK_ORDER_NUM);
		logFilters.add(MongoConstants.ROUTING_FIELD.TASK_NUM);
		logFilters.add(MongoConstants.REPORT_FIELD.REPORT_NUM);
		logFilters.add(MongoConstants.REPORT_FIELD.REPORT_URL);
		logFilters.add(MongoConstants.REPORT_FIELD.REPORTPDF_URL);
		logFilters.add(MongoConstants.REPORT_FIELD.CREATOR);
		logFilters.add(MongoConstants.REPORT_TEMPLATE_FIELD.TEMPLATE_ID);
		logFilters.add(MongoConstants.OPERATION_USER.SUBCASE_CREATE_USER);
		logFilters.add(MongoConstants.OPERATION_USER.SUBCASE_REVIEW_USER);
		logFilters.add(MongoConstants.OPERATION_USER.SUBCASE_IMPROVE_USER);
		logFilters.add(MongoConstants.OPERATION_USER.SUBCASE_EXCEPTION_HANDLE_USER);
		logFilters.add(MongoConstants.OPERATION_USER.SUBCASE_CALCULATE_USER);
		logFilters.add(MongoConstants.OPERATION_USER.SUBCASE_EXCEPTION_USER);
		logFilters.add(MongoConstants.OPERATION_USER.REPORT_CREATE_USER);
		logFilters.add(MongoConstants.OPERATION_USER.REPORT_REVIEW_USER);
		logFilters.add(MongoConstants.OPERATION_USER.REPORT_SEND_USER);
		logFilters.add(MongoConstants.OPERATION_USER.SAMPLE_EXCEPTION_USER);
		logFilters.add(MongoConstants.OPERATION_USER.SAMPLE_CREATE_USER);
		logFilters.add(MongoConstants.OPERATION_USER.SAMPLE_ROUTING_USER);
		logFilters.add(MongoConstants.OPERATION_USER.SAMPLE_DATA_UPLOAD_USER);
		logFilters.add(MongoConstants.OPERATION_USER.SAMPLE_DATA_REUPLOAD_USER);
		logFilters.add(MongoConstants.OPERATION_USER.SAMPLE_DATA_CONFIRM_USER);
		logFilters.add(MongoConstants.OPERATION_USER.TASK_ALLOT_USER);
		logFilters.add(MongoConstants.OPERATION_USER.TASK_START_USER);
		logFilters.add(MongoConstants.OPERATION_USER.TASK_FINISH_USER);
		logFilters.add(MongoConstants.OPERATION_USER.TASK_EXCEPTION_USER);
		logFilters.add(MongoConstants.OPERATION_USER.TASK_EXCEPTION_HANDLE_USER);
	}
	private LoggerObservable loggerObservable;
	private LoggerObserver loggerObserver;
	private HashSet<String> logFilters;
    @Async
    public void sendLogger(EngineLog loggerinfo) {
    	loggerObservable.send(loggerinfo);
    }
}
