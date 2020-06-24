package com.bgi.ms.engine.base.bean.product;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
/**
 * 产品信息
 * @author yeyuanchun
 *
 */
public class ProductInfo {
    @SerializedName("dicItemCode")
    private String productCode;//产品编码
    @SerializedName("dicItemName")
    private String productName;//产品名称
    @SerializedName("CPDL")
    private Map<String,Object> productType;//产品类型
    @SerializedName("PREVIEW_TEMPLATE")
    private List<TemplateInfo> previewTemplates;//案件预览模板
    @SerializedName("REPORT_TEMPLATE")
    private List<TemplateInfo> reportTemplates;//报告模板
    @SerializedName("CPI_CALCULATION_TEMPLATE")
    private List<TemplateInfo> cpiCalculationTemplate;//CPI计算表模板
    @SerializedName("DEFAULT_ROUTING")
    private List<RoutingInfo> defaultRoutings;//默认工艺路线
    @SerializedName("DEFAULT_CALCULATION")
    private List<Calculation> defaultCalculations;//默认算法
    @SerializedName("CASE_GENERATION_RULES")
    private List<CaseGenerationRules> defaultCaseGenerationRules;//默认案件生成规则
    @SerializedName("SUBHEADING")
    private List<ReportSubheading> defaultReportSubheading;//默认报告副标题范本


    /**
     * 功能描述: 获取符合条件的报告副标题
     * @param:
     * @return:
     * @auther: ChenHaiFeng
     * @date: 2020/2/17 16:22
     */
    public ReportSubheading getMatchReportSubheading(Map<String, Object> matchMap) {
        if(defaultReportSubheading==null||defaultReportSubheading.size()==0) {
            return null;
        }
        for(ReportSubheading reportSubheading:defaultReportSubheading) {
            if(isMatchConditions(reportSubheading.getConditions(),matchMap)) {
                return reportSubheading;
            }
        }
        return null;
    }

    /**
     * 功能描述: 获取符合条件的案件生成规则
     * @param:
     * @return:
     * @auther: ChenHaiFeng
     * @date: 2020/2/17 16:22
     */
    public CaseGenerationRules getMatchCaseGenerationRules(Map<String, Object> matchMap) {
        if(defaultCaseGenerationRules==null||defaultCaseGenerationRules.size()==0) {
            return null;
        }
        for(CaseGenerationRules caseGenerationRules:defaultCaseGenerationRules) {
            if(isMatchConditions(caseGenerationRules.getConditions(),matchMap)) {
                return caseGenerationRules;
            }
        }
        return null;
    }

    /**
     * 获取符合条件的算法
     * @param matchMap
     * @return
     */
    public Calculation getMatchCalculation(Map<String, Object> matchMap) {
        if(defaultCalculations==null||defaultCalculations.size()==0) {
            return null;
        }
        for(Calculation calculation:defaultCalculations) {
            if(isMatchConditions(calculation.getConditions(),matchMap)) {
                return calculation;
            }
        }
        return null;
    }


    /**
     * 获取符合条件的案件预览模板
     * @param matchMap
     * @return
     */
    public TemplateInfo getMatchedPriviewTemplate(Map<String, Object> matchMap) {
        if(previewTemplates==null||previewTemplates.size()==0) {
            return null;
        }
        for(TemplateInfo templateInfo:previewTemplates) {
            if(isMatchConditions(templateInfo.getConditions(),matchMap)) {
                return templateInfo;
            }
        }
        return null;
    }
    /**
     * 获取复核条件的报告模板
     * @param matchMap
     * @return
     */
    public TemplateInfo getMatchedReportTemplate(Map<String, Object> matchMap) {
        if(reportTemplates==null||reportTemplates.size()==0) {
            return null;
        }
        for(TemplateInfo templateInfo:reportTemplates) {
            if(isMatchConditions(templateInfo.getConditions(),matchMap)) {
                return templateInfo;
            }
        }
        return null;
    }
    /**
     * 获取CPI计算EXCEL模板
     * @param matchMap
     * @return
     */
    public TemplateInfo getMatchedCPICACTemplate(Map<String, Object> matchMap) {
        if(cpiCalculationTemplate==null||cpiCalculationTemplate.size()==0) {
            return null;
        }
        for(TemplateInfo templateInfo:cpiCalculationTemplate) {
            if(isMatchConditions(templateInfo.getConditions(),matchMap)) {
                return templateInfo;
            }
        }
        return null;
    }
    /**
     * 获取符合条件的工艺路线
     * @param matchMap
     * @return
     */
    public RoutingInfo getMatchedDefaultRouting(Map<String, Object> matchMap) {
        if(defaultRoutings==null||defaultRoutings.size()==0) {
            return null;
        }
        for(RoutingInfo defaultRouting:defaultRoutings) {
            if(isMatchConditions(defaultRouting.getConditions(),matchMap)) {
                return defaultRouting;
            }
        }
        return null;
    }

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

    public String getProductCode() {
        return productCode;
    }
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Map<String, Object> getProductType() {
        return productType;
    }
    public void setProductType(Map<String, Object> productType) {
        this.productType = productType;
    }
    public List<TemplateInfo> getPreviewTemplates() {
        return previewTemplates;
    }
    public void setPreviewTemplates(List<TemplateInfo> previewTemplates) {
        this.previewTemplates = previewTemplates;
    }
    public List<TemplateInfo> getReportTemplates() {
        return reportTemplates;
    }
    public void setReportTemplates(List<TemplateInfo> reportTemplates) {
        this.reportTemplates = reportTemplates;
    }
    public List<RoutingInfo> getDefaultRoutings() {
        return defaultRoutings;
    }
    public void setDefaultRoutings(List<RoutingInfo> defaultRoutings) {
        this.defaultRoutings = defaultRoutings;
    }

    public List<Calculation> getDefaultCalculations() {
        return defaultCalculations;
    }
    public void setDefaultCalculations(List<Calculation> defaultCalculations) {
        this.defaultCalculations = defaultCalculations;
    }

    public List<CaseGenerationRules> getDefaultCaseGenerationRules() {
        return defaultCaseGenerationRules;
    }

    public void setDefaultCaseGenerationRules(List<CaseGenerationRules> defaultCaseGenerationRules) {
        this.defaultCaseGenerationRules = defaultCaseGenerationRules;
    }

    public List<ReportSubheading> getDefaultReportSubheading() {
        return defaultReportSubheading;
    }

    public void setDefaultReportSubheading(List<ReportSubheading> defaultReportSubheading) {
        this.defaultReportSubheading = defaultReportSubheading;
    }

    public List<TemplateInfo> getCpiCalculationTemplate() {
        return cpiCalculationTemplate;
    }

    public void setCpiCalculationTemplate(List<TemplateInfo> cpiCalculationTemplate) {
        this.cpiCalculationTemplate = cpiCalculationTemplate;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", previewTemplates=" + previewTemplates +
                ", reportTemplates=" + reportTemplates +
                ", defaultRoutings=" + defaultRoutings +
                ", defaultCalculations=" + defaultCalculations +
                ", defaultCaseGenerationRules=" + defaultCaseGenerationRules +
                ", defaultReportSubheading=" + defaultReportSubheading +
                '}';
    }
    public static void main(String[] args) {
        String productJson="{\"PREVIEW_TEMPLATE\":[{\"CONDITIONS\":[{\"FIELD_VALUE\":\"测试字段值\",\"FIELD_NAME\":\"测试字段名称\",\"FIELD_OPTION\":\"测试运算规则\"}],\"TEMPLATE_ID\":\"测试模板ID\"}],\"REPORT_TEMPLATE\":[{\"CONDITIONS\":[{\"FIELD_VALUE\":\"测试字段值\",\"FIELD_NAME\":\"测试字段名称\",\"FIELD_OPTION\":\"测试运算规则\"}],\"TEMPLATE_ID\":\"测试模板ID\"}],\"DEFAULT_ROUTING\":[{\"ROUTING\":\"工艺路线\",\"CONDITIONS\":[{\"FIELD_VALUE\":\"测试字段值\",\"FIELD_NAME\":\"测试字段名称\",\"FIELD_OPTION\":\"测试运算规则\"}]}],\"PRODUCT_NAME\":\"测试产品\",\"PRODUCT_CODE\":\"CPLX23\"}";
        Gson defaultGson=new GsonBuilder().create();
        ProductInfo productInfo=defaultGson.fromJson(productJson, ProductInfo.class);
        System.out.println(productInfo.toString());

    }
}
