package com.bgi.ms.engine.base.bean.sample;

/**
 * @author
 * @date 19-12-2 10:05
 * @Description
 */
public class CHRStatistic {
    private String chr;
    private String total;
    private String siteNum;

    public String getChr() {
        return chr;
    }

    public void setChr(String chr) {
        this.chr = chr;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSiteNum() {
        return siteNum;
    }

    public void setSiteNum(String siteNum) {
        this.siteNum = siteNum;
    }

    @Override
    public String toString() {
        return "CHRStatistic{" +
                "chr='" + chr + '\'' +
                ", total='" + total + '\'' +
                ", siteNum='" + siteNum + '\'' +
                '}';
    }
}
