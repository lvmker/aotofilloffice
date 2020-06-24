package com.bgi.ms.engine.base.bean.product;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author : ChenHaiFeng
 * @date : 2020/2/17 16:09
 * @Description:案件生成规则（产品中的属性）
 */
public class CaseGenerationRules {
    /**
     * 规则code
     */
    @SerializedName("CASERULE_CODE")
    private String caseRuleCode;
    /**
     *规则名称
     */
    @SerializedName("CASERULE_NAME")
    private String caseRuleName;
    /**
     *规则生效条件
     */
    @SerializedName("CONDITIONS")
    private List<Condition> conditions;

    public String getCaseRuleCode() {
        return caseRuleCode;
    }

    public void setCaseRuleCode(String caseRuleCode) {
        this.caseRuleCode = caseRuleCode;
    }

    public String getCaseRuleName() {
        return caseRuleName;
    }

    public void setCaseRuleName(String caseRuleName) {
        this.caseRuleName = caseRuleName;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public String toString() {
        return "CaseGenerationRules{" +
                "caseRuleCode='" + caseRuleCode + '\'' +
                ", caseRuleName='" + caseRuleName + '\'' +
                ", conditions=" + conditions +
                '}';
    }
}
