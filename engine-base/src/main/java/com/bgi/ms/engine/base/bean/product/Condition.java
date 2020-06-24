package com.bgi.ms.engine.base.bean.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.print.DocFlavor.STRING;

import org.springframework.util.StringUtils;

import com.bgi.ms.engine.base.bean.QueryOption;
import com.bgi.ms.engine.base.bean.kit.Kit;
import com.google.gson.annotations.SerializedName;

/**
 * 判断条件
 * @author yeyuanchun
 *
 */
public class Condition {
	@SerializedName("FIELD_NAME")
	private String fieldName;//
	@SerializedName("FIELD_VALUE")
	private String fieldValue;//
	@SerializedName("FIELD_OPTION")
	private String fieldOption;//
	public static void main(String[] args) {
		List<Map<String, Object>> samples=new ArrayList<Map<String,Object>>();
		Map<String, Object> sample=new HashMap<String, Object>();
		sample.put("sampleName", "111");
		
		Map<String,Object> kitMap=new HashMap<>();
		kitMap.put("dicItemCode", "19G");
		kitMap.put("dicItemName", "19G试剂盒");

		sample.put("KIT", kitMap);
		
		samples.add(sample);
		Map<String, Object> sample1=new HashMap<String, Object>();
		sample1.put("sampleName", "222");
		sample1.put("KIT", kitMap);
		samples.add(sample1);
		Map<String, Object> matchMap=new HashMap<>();
		matchMap.put("SAMPLES", samples);
		System.out.println("案件信息-"+matchMap.toString());
		
		
		Condition condition=new Condition();
		condition.setFieldName("SAMPLES[0].KIT.dicItemCode");
		condition.setFieldValue("19G");
		condition.setFieldOption("EQ");
		System.out.println("匹配条件-"+condition.toString());
		System.out.println("是否匹配-"+condition.match(matchMap));
//		String[] fieldNames="SAMPLES[1].sampleName".split("\\.");
//		System.out.println(fieldNames.toString());
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Boolean match(Map<String, Object> matchMap) {
		try {
			String[] fieldNames=fieldName.split("\\.");
			if(null==fieldNames||fieldNames.length==0) {
				return false;
			}
			Object value=matchMap;
			for(String name:fieldNames) {
		        String reg = "\\[(.*?)\\]";
		        Pattern pattern = Pattern.compile(reg);
		        Matcher matcher = pattern.matcher(name);
		        if( matcher.find() ){
		        	String fieldName=name.substring(0, name.indexOf("["));
		        	String index=matcher.group(1);
		        	Object listObj=matchMap.get(fieldName);
		        	if(List.class.isInstance(listObj)) {
		        		List objList=((List)listObj);
		        		if(index.equals("size")) {
		        			value=objList.size()+"";
		        		}else {
		        			int i=Integer.parseInt(index);
		        			if(objList.size()<=i) {
		        				return false;
		        			}else {
		        				value=objList.get(i);
		        			}
		        		}
		        	}else {
		        		value=listObj;
		        	}
		        	
		        }else{
					value=matchMap.get(name);
		        }
				if(Map.class.isInstance(value)) {
					matchMap=(Map<String, Object>) value;
				}
			}
			switch (fieldOption) {
			case QueryOption.OPTION.EQ://等于
				if(StringUtils.isEmpty(value.toString())) {
					if(null==fieldValue||StringUtils.isEmpty(fieldValue)) {
						return true;
					}else {
						return false;
					}
				}else {
					if(value.toString().equals(fieldValue)) {
						return true;
					}else {
						return false;
					}
				}
			case QueryOption.OPTION.NQ://
				if(StringUtils.isEmpty(value.toString())) {
					if(null==fieldValue||StringUtils.isEmpty(fieldValue)) {
						return true;
					}else {
						return false;
					}
				}else {
					if(value.toString().contains(fieldValue)) {
						return true;
					}else {
						return false;
					}
				}
			default:
				break;
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		
		return false;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	public String getFieldOption() {
		return fieldOption;
	}
	public void setFieldOption(String fieldOption) {
		this.fieldOption = fieldOption;
	}
	@Override
	public String toString() {
		return "Condition [fieldName=" + fieldName + ", fieldValue=" + fieldValue + ", fieldOption=" + fieldOption
				+ "]";
	}
	
}
