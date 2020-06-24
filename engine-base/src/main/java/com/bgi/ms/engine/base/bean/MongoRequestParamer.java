package com.bgi.ms.engine.base.bean;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.bgi.ms.engine.base.bean.QueryOption;

public class MongoRequestParamer {

	/*
	 * 操作的数据库名称
	 */
	private String dbName;//操作的数据库名称
	/*
	 * 操作的集合名称（表名）
	 */
	private String collectionName;//操作的集合名称（表名）
	/*
	 * 单个对象的json
	 */
	private String documentJson;//单个对象的json
	/*
	 * 多个对象的json
	 */
	private List<String> documentJsons;//多个对象的json
	/*
	 * 单个对象
	 */
	private Object obj;//单个对象
	/*
	 * 多个对象
	 */
	private List<Object> objs;//多个对象
	/*
	 * 过滤条件
	 */
	private List<QueryOption> queryOptions;//过滤条件
	/*
	 * 字段过滤条件，控制返回字段
	 */
	private Map<String, Object> filterFields;//字段过滤条件，控制返回字段
	
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getCollectionName() {
		return collectionName;
	}
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
	public String getDocumentJson() {
		return documentJson;
	}
	public void setDocumentJson(String documentJson) {
		this.documentJson = documentJson;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public List<String> getDocumentJsons() {
		return documentJsons;
	}
	public void setDocumentJsons(List<String> documentJsons) {
		this.documentJsons = documentJsons;
	}
	public List<Object> getObjs() {
		return objs;
	}
	public void setObjs(List<Object> objs) {
		this.objs = objs;
	}
	public List<QueryOption> getQueryOptions() {
		return queryOptions;
	}
	public void setQueryOptions(List<QueryOption> queryOptions) {
		this.queryOptions = queryOptions;
	}
	public Map<String, Object> getFilterFields() {
		return filterFields;
	}
	public void setFilterFields(Map<String, Object> filterFields) {
		this.filterFields = filterFields;
	}
	
}
