package com.bgi.ms.engine.base.bean.sample;

/**
 * @author
 * @date 19-12-2 10:10
 * @Description
 */
public class CHRDataDetail {
    // 检测位点编号
    private String siteNum;
    // 染色体
    private String chr;
    // 父亲基因型
    private String fatherGene;
    // 母本基因型
    private String motherGene;
    // 胎儿基因型
    private String childGene;
    // 是否错配
    private String isMatched;

    public String getSiteNum() {
        return siteNum;
    }

    public void setSiteNum(String siteNum) {
        this.siteNum = siteNum;
    }

    public String getChr() {
        return chr;
    }

    public void setChr(String chr) {
        this.chr = chr;
    }

    public String getFatherGene() {
        return fatherGene;
    }

    public void setFatherGene(String fatherGene) {
        this.fatherGene = fatherGene;
    }

    public String getMotherGene() {
        return motherGene;
    }

    public void setMotherGene(String motherGene) {
        this.motherGene = motherGene;
    }

    public String getChildGene() {
        return childGene;
    }

    public void setChildGene(String childGene) {
        this.childGene = childGene;
    }

    public String getIsMatched() {
        return isMatched;
    }

    public void setIsMatched(String isMatched) {
        this.isMatched = isMatched;
    }

    @Override
    public String toString() {
        return "CHRDataDetail{" +
                "siteNum='" + siteNum + '\'' +
                ", chr='" + chr + '\'' +
                ", fatherGene='" + fatherGene + '\'' +
                ", motherGene='" + motherGene + '\'' +
                ", childGene='" + childGene + '\'' +
                ", isMatched='" + isMatched + '\'' +
                '}';
    }
}
