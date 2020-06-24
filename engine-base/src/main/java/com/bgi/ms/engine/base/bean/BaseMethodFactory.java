package com.bgi.ms.engine.base.bean;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.bgi.ms.engine.base.exception.BaseException;
import com.bgi.ms.engine.base.utils.ValidatorUtil;
public class BaseMethodFactory {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private BaseMethodBeanPostProcessor baseMethodBeanPostProcessor;

	public BaseMethodFactory(BaseMethodBeanPostProcessor baseMethodBeanPostProcessor) {
		this.baseMethodBeanPostProcessor=baseMethodBeanPostProcessor;
	}
	public BaseResponse executeMethod(BaseRequestParameter baseRequestParameter) throws BaseException {
		try {
			SystemParams systemParameters = baseRequestParameter.getSystemParams();
			Map<String, Object> applicationParameters = baseRequestParameter.getApplicationParams();
			if (ValidatorUtil.isEmpty(systemParameters)) {
				throw new BaseException(BaseException.ERROR_CODE.PARAM_NULL, "系统参数缺失");
			}
			String method = systemParameters.getMethod();
			logger.info("[接口反射]调用方法名称" + method);
			if (null == baseMethodBeanPostProcessor.getBaseMethodMap()) {
				throw new BaseException(BaseException.ERROR_CODE.SERVICE_UNAVAILABLE, "方法列表未初始化");
			}
			Object[] methodInfos = baseMethodBeanPostProcessor.getBaseMethodMap().get(method);
			if (null == methodInfos) {
				throw new BaseException(BaseException.ERROR_CODE.UNSUPPORTED_METHOD, "未找到方法[" + method + "]");
			}
			Object executeObject = methodInfos[0];
			Method executeMethod = (Method) methodInfos[1];
			List<Object> invokeArgs = new ArrayList<Object>();
		    Class<?>[] parameterTypes = executeMethod.getParameterTypes();
		    
		    
		    
		    
		    // 遍历参数
		    for(int i=0;i<parameterTypes.length;i++) {
		    	Class<?> parameterType=parameterTypes[i];
				if (Map.class.equals(parameterType)) {
				    invokeArgs.add(applicationParameters);
				}
		    }
//			Parameter[] parameters = executeMethod.getParameters();
//			for (Parameter parameter : parameters) {
//				if (applicationParameters.getClass().equals(parameter.getParameterizedType())) {
//					invokeArgs.add(applicationParameters);
//				}
//				if (applicationParameters.getClass().equals(parameter.getParameterizedType())) {
//					invokeArgs.add(applicationParameters);
//				}
//
//			}
		    Object responObject=executeMethod.invoke(executeObject,invokeArgs.toArray());
		    if(BaseResponse.class.isInstance(responObject)) {
		    	return (BaseResponse) responObject;
		    }
		    BaseResponse baseResponse=new BaseResponse();
		    baseResponse.setRows(responObject);
		    return baseResponse;

		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			// TODO: handle exception
			Throwable cause = e.getCause();
			if (cause instanceof BaseException) {
				throw (BaseException) cause;
			}
			e.printStackTrace();
			logger.error("接口请求出现错误:{}",e.getMessage());
			throw new BaseException(BaseException.ERROR_CODE.UNKNOWN, "系统异常");
		}
	}
}
