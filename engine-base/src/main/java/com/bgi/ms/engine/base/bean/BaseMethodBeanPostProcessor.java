package com.bgi.ms.engine.base.bean;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import com.bgi.ms.engine.base.method.BaseMethod;


public class BaseMethodBeanPostProcessor implements BeanPostProcessor {
    private Logger logger=LoggerFactory.getLogger(BaseMethodBeanPostProcessor.class);
    private static Map<String, Object[]> baseMethodMap = null;
    public Object postProcessBeforeInitialization(Object bean, String beanName)
           throws BeansException {
       return bean;
    }
    public Object postProcessAfterInitialization(Object bean, String beanName)throws BeansException {
	Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
	logger.debug("BaseMethodBeanPostProcessor扫描"+beanName);
	for (Method method : methods) {
		BaseMethod baseMethod = method.getAnnotation(BaseMethod.class);
		if (baseMethod != null) {
		    Object[] methodInfos = new Object[2];
		    methodInfos[0] = bean;
		    methodInfos[1] = method;
		    if(null==baseMethodMap){
		    	baseMethodMap=new HashMap<>();
		    }
		    baseMethodMap.put(baseMethod.value(), methodInfos);
		    logger.debug("BaseMethodBeanPostProcessor添加方法"+baseMethod.value());
		}
	    }
       return bean;
    }
	public Map<String, Object[]> getBaseMethodMap() {
		return baseMethodMap;
	}
    
}