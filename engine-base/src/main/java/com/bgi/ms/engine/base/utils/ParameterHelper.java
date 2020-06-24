package com.bgi.ms.engine.base.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bgi.ms.engine.base.bean.QueryOption;
import com.bgi.ms.engine.base.exception.BaseException;
import com.bgi.ms.engine.base.utils.MongoConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ParameterHelper {
	private static Gson defaultGson=new GsonBuilder().create();
	private static Logger logger =LoggerFactory.getLogger(ParameterHelper.class);
	public static List<QueryOption> getQueryOptions(Map<String, Object> applicationParameters) throws BaseException{
		List<QueryOption> options=new ArrayList<>();
		if(applicationParameters.containsKey(MongoConstants.REQUEST_PARAMETER_FIELD.OPTIONS)) {
			options=defaultGson.fromJson(defaultGson.toJson(applicationParameters.get(MongoConstants.REQUEST_PARAMETER_FIELD.OPTIONS)) ,new TypeToken<ArrayList<QueryOption>>() {}.getType());
//			options=(List<QueryOption>) applicationParameters.get(MongoConstants.REQUEST_PARAMETER_FIELD.OPTIONS);
		}
		if(null==options) {
			throw new BaseException(BaseException.ERROR_CODE.PARAM_ILLEGAL, "参数"+MongoConstants.REQUEST_PARAMETER_FIELD.OPTIONS+"不能为空");
		}
		return options;
	}
	
	public static List<String> getObjectJsons(Map<String, Object> applicationParameters) throws BaseException{
		List<String> valueJsons=new ArrayList<>();
		if(applicationParameters.containsKey(MongoConstants.REQUEST_PARAMETER_FIELD.OBJECTS)) {
			@SuppressWarnings("unchecked")
			List<Object> objects=(List<Object>) applicationParameters.get(MongoConstants.REQUEST_PARAMETER_FIELD.OBJECTS);
			if(objects!=null&&objects.size()>0) {
				for(Object object:objects) {
					if(String.class.isInstance(object)) {
						valueJsons.add((String) object);
					}else {
						valueJsons.add(defaultGson.toJson(object));
					}
				}
			}
		}
		return valueJsons;
	}
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> getObjects(Map<String, Object> applicationParameters) throws BaseException{
		List<Map<String, Object>> valueParams=new ArrayList<>();
		if(applicationParameters.containsKey(MongoConstants.REQUEST_PARAMETER_FIELD.OBJECTS)) {
			List<Object> objects=(List<Object>) applicationParameters.get(MongoConstants.REQUEST_PARAMETER_FIELD.OBJECTS);
			if(objects!=null&&objects.size()>0) {
				for(Object object:objects) {
					if(Map.class.isInstance(object)) {
						valueParams.add((Map<String, Object>) object);
					}
				}
			}
		}
		return valueParams;
	}
}
