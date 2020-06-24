package com.bgi.ms.engine.base.bean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class QueryOption {
	public QueryOption() {
		
	}
	
	public QueryOption(String fieldName,String fieldValue,String fieldType,String option) {
		this.fieldName=fieldName;
		this.fieldValue=fieldValue;
		this.fieldType=fieldType;
		this.option=option;
	}
	/**
	 * 字段名
	 */
	private String fieldName;
	
	public interface OPER_FIELD_NAME{
		public static String ORDER_BY="orderBy";//排序
		public static String PAGE="page";//页码
		public static String PAGE_SIZE="pageSize";//每页条数
		public static String WITH_TOTAL="withTotal";//返回总条数
		public static String REGROUP="regroup";//重新聚合
		public static String GROUP_BY="groupBy";//分组
		public static String SUM="sum";//计算总量
	}
	/**
	 * 字段值
	 */
	private String fieldValue; // 
	/**
	 * 字段类型
	 */
	private String fieldType;//
	public interface FIELD_TYPE{
		/**
		 * 整形
		 */
		public static String TYPE_INT="INT";
		/**
		 * 浮点型
		 */
		public static String TYPE_DOUBLE="DOUBLE";
		/**
		 * 字符型
		 */
		public static String TYPE_STRING="STRING";
		/**
		 * 时间类型
		 */
		public static String TYPE_DATE="DATE";
		/**
		 * JSON类型
		 */
		public static String TYPE_JSON="JSON";
		/**
		 * 操作  如要求排序  分页  返回总条数
		 */
		public static String TYPE_OPERATION="OPER";
		
		/**
		 * 使用聚合查询 
		 */
		public static String TYPE_AGGREGATE="AGGR";
		
	}
	/**
	 * 范围条件 
	 */
	private String option; 
	public interface OPTION{
		/**
		 * EQ	等于	
		 */
		public static String EQ="EQ";	
		/**
		 * G	大于
		 */
		public static String G="G";
		/**
		 * GE	大于等于	
		 */
		public static String GE="GE";
		/**
		 * L	小于	
		 */
		public static String L="L";
		/**
		 * LE	小于等于	
		 */
		public static String LE="LE";
		/**
		 * NE	不等于
		 */
		public static String NE="NE";	
		/**
		 * IN   
		 */
		public static String IN="IN";
		/**
		 * NOT IN   
		 */
		public static String NIN="NIN";
		/**
		 * NOT   
		 */
		public static String NOT="NOT";
		/**
		 * NQ	包含	(适用于模糊查询)
		 */
		public static String NQ="NQ";
	}
	public String toAggregateOption() throws ParseException {
		if(OPTION.EQ.equals(option)) {
			return "{\""+fieldName+"\":\""+fieldValue+"\"}";
		}
		if(OPTION.G.equals(option)) {
			return "{\""+fieldName+"\":{\"$gt\":"+toFieldType()+"}}";
		}
		if(OPTION.GE.equals(option)) {
			return "{\""+fieldName+"\":{\"$gte\":"+toFieldType()+"}}";
		}
		if(OPTION.L.equals(option)) {
			return "{\""+fieldName+"\":{\"$lt\":"+toFieldType()+"}}";
		}
		if(OPTION.LE.equals(option)) {
			return "{\""+fieldName+"\":{\"$lte\":"+toFieldType()+"}}";
		}
		if(OPTION.NQ.equals(option)) {
			return "{\""+fieldName+"\":{\"$regex\":\""+fieldValue+"\"}}";
		}
		if(OPTION.IN.equals(option)) {
			return "{\""+fieldName+"\":{\"$in\":\""+toFieldType().toString()+"\"}}";
		}
		if(OPTION.NIN.equals(option)) {
			return "{\""+fieldName+"\":{\"$nin\":\""+toFieldType().toString()+"\"}}";
		}
		return null;
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
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	
	@SuppressWarnings("rawtypes")
	public List toFieldTypeList() throws ParseException{
		switch(getFieldType()) {
		case QueryOption.FIELD_TYPE.TYPE_INT:{
				String[] valueStrs=getFieldValue().split(",");
				List<Integer> values=new ArrayList<>();
				for(String valueStr:valueStrs) {
					values.add(Integer.parseInt(valueStr));
				}
				return values;
		}
		case QueryOption.FIELD_TYPE.TYPE_DOUBLE:{
				String[] valueStrs=getFieldValue().split(",");
				List<Double> values=new ArrayList<>();
				for(String valueStr:valueStrs) {
					values.add(Double.parseDouble(valueStr));
				}
				return values;
		}
		case QueryOption.FIELD_TYPE.TYPE_DATE:{
				String[] valueStrs=getFieldValue().split(",");
				List<Date> values=new ArrayList<>();
				DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				for(String valueStr:valueStrs) {
					values.add(fmt.parse(valueStr));
				}
				return values;
		}
		default:{
				String[] valueStrs=getFieldValue().split(",");
				List<String> values=new ArrayList<>();
				for(String valueStr:valueStrs) {
					values.add(valueStr);
				}
				return values;
		}

		}
	}
	public  Object toFieldType() throws ParseException {
		switch(getFieldType()) {
		case QueryOption.FIELD_TYPE.TYPE_INT:
				return Integer.parseInt(getFieldValue());
		case QueryOption.FIELD_TYPE.TYPE_DOUBLE:
				return Double.parseDouble(getFieldValue());
		case QueryOption.FIELD_TYPE.TYPE_DATE:
            String valueStr=getFieldValue();
            DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return fmt.parse(valueStr).getTime();
//		case QueryOption.FIELD_TYPE.TYPE_JSON:
//				return Document.parse(getFieldValue());
		default:
				return getFieldValue();
		}
	}

	@Override
	public String toString() {
		return "QueryOption [fieldName=" + fieldName + ", fieldValue=" + fieldValue + ", fieldType=" + fieldType
				+ ", option=" + option + "]";
	}
	
}
