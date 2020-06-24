package com.bgi.ms.engine.base.bean.product;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author : ChenHaiFeng
 * @date : 2020/2/17 16:04
 * @Description:报告副标题（产品中的属性）
 */
public class ReportSubheading {
    /**
     * 副标题code
     */
    @SerializedName("SUBHEADING_CODE")
    private String subheadingCode;
    /**
     *副标题范本
     */
    @SerializedName("SUBHEADING_NAME")
    private String subheadingName;
    /**
     *副标题生效条件
     */
    @SerializedName("CONDITIONS")
    private List<Condition> conditions;


    public String getSubheadingCode() {
        return subheadingCode;
    }

    public void setSubheadingCode(String subheadingCode) {
        this.subheadingCode = subheadingCode;
    }

    public String getSubheadingName() {
        return subheadingName;
    }

    public void setSubheadingName(String subheadingName) {
        this.subheadingName = subheadingName;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public String toString() {
        return "ReportSubheading{" +
                "subheadingCode='" + subheadingCode + '\'' +
                ", subheadingName='" + subheadingName + '\'' +
                ", conditions=" + conditions +
                '}';
    }
}
