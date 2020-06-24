package com.bgi.ms.engine.base.bean.sample;

import java.util.List;

/**
 * @author
 * @date 19-12-2 10:01
 * @Description
 */
public class NipptTestData {
    // 疑父样本编号
    private String sampleNum;
    // 结论 N/Y
    private String con;
    // cpi
    private String cpi;
    // cpe
    private String cpe;
    // cnf
    private String cnf;
    // 染色体位点统计
    private List<CHRStatistic> chrStatistics;
    // 染色体位点数据详情
    private List<CHRDataDetail> chrDataDetails;

    public String getSampleNum() {
        return sampleNum;
    }

    public void setSampleNum(String sampleNum) {
        this.sampleNum = sampleNum;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public String getCpi() {
        return cpi;
    }

    public void setCpi(String cpi) {
        this.cpi = cpi;
    }

    public String getCpe() {
        return cpe;
    }

    public void setCpe(String cpe) {
        this.cpe = cpe;
    }

    public String getCnf() {
        return cnf;
    }

    public void setCnf(String cnf) {
        this.cnf = cnf;
    }

    public List<CHRStatistic> getChrStatistics() {
		return chrStatistics;
	}

	public void setChrStatistics(List<CHRStatistic> chrStatistics) {
		this.chrStatistics = chrStatistics;
	}

	public List<CHRDataDetail> getChrDataDetails() {
        return chrDataDetails;
    }

    public void setChrDataDetails(List<CHRDataDetail> chrDataDetails) {
        this.chrDataDetails = chrDataDetails;
    }

    @Override
	public String toString() {
		return "NipptTestData [sampleNum=" + sampleNum + ", con=" + con + ", cpi=" + cpi + ", cpe=" + cpe + ", cnf="
				+ cnf + ", chrStatistics=" + chrStatistics + ", chrDataDetails=" + chrDataDetails + "]";
	}
}