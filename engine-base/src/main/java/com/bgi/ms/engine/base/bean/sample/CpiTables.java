package com.bgi.ms.engine.base.bean.sample;

import java.util.List;
import java.util.Map;

/**
 * @author : ChenHaiFeng
 * @date : 2019/9/19 09:45
 * @Description: CPI最终结论
 */
public class CpiTables {
    private List<CPICalculation> cpiList;
    private List<CPICalculation> cpiListAdd;
    /**
     * 错配位点-M
     */
    private Map<String, Map<String, List<Marker>>> mMissingListMp;
    /**
     * 错配位点-M Add
     */
    private Map<String, Map<String, List<Marker>>> mMissingListMpAdd;
    /**
     * 错配位点-F
     */
    private Map<String, Map<String, List<Marker>>> fMissingListMp;
    /**
     * 错配位点-F Add
     */
    private Map<String, Map<String, List<Marker>>> fMissingListMpAdd;
    /**
     * 鉴定事项
     */
    private List<String>IdentifyItem;
    /**
     * 检验过程
     */
    private List<String> testMethod;
    /**
     * 分析说明
     */
    private List<String> analysis;
    /**
     * 鉴定意见
     */
    private List<String> suggestion;

    /**
     * 检验材料
     */
    private List<String> sampleMerterials;

    public List<String> getSampleMerterials() {
        return sampleMerterials;
    }

    public void setSampleMerterials(List<String> sampleMerterials) {
        this.sampleMerterials = sampleMerterials;
    }

    public List<String> getIdentifyItem() {
        return IdentifyItem;
    }

    public void setIdentifyItem(List<String> IdentifyItem) {
        this.IdentifyItem = IdentifyItem;
    }

    public List<CPICalculation> getCpiList() {
        return cpiList;
    }

    public void setCpiList(List<CPICalculation> cpiList) {
        this.cpiList = cpiList;
    }

    public List<String> getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(List<String> testMethod) {
        this.testMethod = testMethod;
    }

    public List<String> getAnalysis() {
        return analysis;
    }

    public void setAnalysis(List<String> analysis) {
        this.analysis = analysis;
    }
    public List<CPICalculation> getCpiListAdd() {
        return cpiListAdd;
    }

    public void setCpiListAdd(List<CPICalculation> cpiListAdd) {
        this.cpiListAdd = cpiListAdd;
    }


    public Map<String, Map<String, List<Marker>>> getmMissingListMp() {
        return mMissingListMp;
    }

    public void setmMissingListMp(Map<String, Map<String, List<Marker>>> mMissingListMp) {
        this.mMissingListMp = mMissingListMp;
    }

    public Map<String, Map<String, List<Marker>>> getmMissingListMpAdd() {
        return mMissingListMpAdd;
    }

    public void setmMissingListMpAdd(Map<String, Map<String, List<Marker>>> mMissingListMpAdd) {
        this.mMissingListMpAdd = mMissingListMpAdd;
    }

    public Map<String, Map<String, List<Marker>>> getfMissingListMp() {
        return fMissingListMp;
    }

    public void setfMissingListMp(Map<String, Map<String, List<Marker>>> fMissingListMp) {
        this.fMissingListMp = fMissingListMp;
    }

    public Map<String, Map<String, List<Marker>>> getfMissingListMpAdd() {
        return fMissingListMpAdd;
    }

    public void setfMissingListMpAdd(Map<String, Map<String, List<Marker>>> fMissingListMpAdd) {
        this.fMissingListMpAdd = fMissingListMpAdd;
    }

    public List<String> getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(List<String> suggestion) {
        this.suggestion = suggestion;
    }

    @Override
    public String toString() {
        return "CpiTables{" +
                "cpiList=" + cpiList +
                ", cpiListAdd=" + cpiListAdd +
                ", mMissingListMp=" + mMissingListMp +
                ", mMissingListMpAdd=" + mMissingListMpAdd +
                ", fMissingListMp=" + fMissingListMp +
                ", fMissingListMpAdd=" + fMissingListMpAdd +
                ", IdentifyItem=" + IdentifyItem +
                ", testMethod=" + testMethod +
                ", analysis=" + analysis +
                ", suggestion=" + suggestion +
                ", sampleMerterials=" + sampleMerterials +
                '}';
    }
}
