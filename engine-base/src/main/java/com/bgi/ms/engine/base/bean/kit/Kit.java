package com.bgi.ms.engine.base.bean.kit;

import java.util.List;
import java.util.Map;

import com.bgi.ms.engine.base.bean.product.Condition;
import com.bgi.ms.engine.base.bean.product.TemplateInfo;
import com.google.gson.annotations.SerializedName;
/**
 * 试剂盒
 * @author yeyuanchun
 *
 */
public class Kit {
	@SerializedName("dicItemCode")
	private String kitCode;
	@SerializedName("dicItemName")
	private String kitName;
	@SerializedName("PCR_TEMPLATE")
	private List<TemplateInfo> pcrTemplates;//扩增表模板
	@SerializedName("ELE_TEMPLATE")
	private List<TemplateInfo> eleTemplates;//电泳表模板
	@SerializedName("PCR_METHOD")
	private Object pcrMethod;//扩增方法
	@SerializedName("MARKER_SORTS")
	private String markerSorts;

	public Boolean isMatchConditions(List<Condition> conditions,Map<String, Object> matchMap) {
		if(null==conditions||conditions.size()==0) {
			return true;
		}
		for(Condition condition:conditions) {
			if(!condition.match(matchMap)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 获取符合条件的扩增表模板
	 * @param matchMap
	 * @return
	 */
	public TemplateInfo getMatchedPcrTemplate(Map<String, Object> matchMap) {
		if(pcrTemplates==null||pcrTemplates.size()==0) {
			return null;
		}
		for(TemplateInfo templateInfo:pcrTemplates) {
			if(isMatchConditions(templateInfo.getConditions(),matchMap)) {
				return templateInfo;
			}
		}
		return null;
	}
	/**
	 * 获取符合条件的电泳表模板
	 * @param matchMap
	 * @return
	 */
	public TemplateInfo getMatchedEleTemplate(Map<String, Object> matchMap) {
		if(eleTemplates==null||eleTemplates.size()==0) {
			return null;
		}
		for(TemplateInfo templateInfo:eleTemplates) {
			if(isMatchConditions(templateInfo.getConditions(),matchMap)) {
				return templateInfo;
			}
		}
		return null;
	}
	public String getKitCode() {
		return kitCode;
	}
	public void setKitCode(String kitCode) {
		this.kitCode = kitCode;
	}
	public String getKitName() {
		return kitName;
	}
	public void setKitName(String kitName) {
		this.kitName = kitName;
	}
	public List<TemplateInfo> getPcrTemplates() {
		return pcrTemplates;
	}
	public void setPcrTemplates(List<TemplateInfo> pcrTemplates) {
		this.pcrTemplates = pcrTemplates;
	}
	public List<TemplateInfo> getEleTemplates() {
		return eleTemplates;
	}
	public void setEleTemplates(List<TemplateInfo> eleTemplates) {
		this.eleTemplates = eleTemplates;
	}

	public Object getPcrMethod() {
		return pcrMethod;
	}

	public void setPcrMethod(Object pcrMethod) {
		this.pcrMethod = pcrMethod;
	}

	public String getMarkerSorts() {
		return markerSorts;
	}

	public void setMarkerSorts(String markerSorts) {
		this.markerSorts = markerSorts;
	}

	@Override
	public String toString() {
		return "Kit{" +
				"kitCode='" + kitCode + '\'' +
				", kitName='" + kitName + '\'' +
				", pcrTemplates=" + pcrTemplates +
				", eleTemplates=" + eleTemplates +
				", pcrMethod=" + pcrMethod +
				", markerSorts='" + markerSorts + '\'' +
				'}';
	}
}
