package com.bgi.ms.engine.base.bean.calculate;

/**
 * Created by admin at 2019/8/28
 */
public class CalculateParamer {


    private String subcaseNum;//子案件编号
    private String calculationCode;//算法编码 CPI/IBS

    public String getSubcaseNum() {
        return subcaseNum;
    }

    public void setSubcaseNum(String subcaseNum) {
        this.subcaseNum = subcaseNum;
    }

    public String getCalculationCode() {
        return calculationCode;
    }

    public void setCalculationCode(String calculationCode) {
        this.calculationCode = calculationCode;
    }
}
