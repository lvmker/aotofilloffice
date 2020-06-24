package com.bgi.ms.engine.base.bean.sample;

import java.util.List;

/**
 * @author : ChenHaiFeng
 * @date : 2019/8/19 17:10
 * @Description:
 */
public class CPICalculation {
    private List<PIResult> fPIResults;
    private List<PIResult> mPIResults;
    private String mConclusion;
    private String fConclusion;
    private String mCpi;
    private String fCpi;
    private List<String> sampleNumList;
    private List<String> sampleNumberList;
    private List<String> sampleNameList;

    public List<PIResult> getfPIResults() {
        return fPIResults;
    }

    public void setfPIResults(List<PIResult> fPIResults) {
        this.fPIResults = fPIResults;
    }

    public List<PIResult> getmPIResults() {
        return mPIResults;
    }

    public void setmPIResults(List<PIResult> mPIResults) {
        this.mPIResults = mPIResults;
    }

    public String getmConclusion() {
        return mConclusion;
    }

    public void setmConclusion(String mConclusion) {
        this.mConclusion = mConclusion;
    }

    public String getfConclusion() {
        return fConclusion;
    }

    public void setfConclusion(String fConclusion) {
        this.fConclusion = fConclusion;
    }

    public String getmCpi() {
        return mCpi;
    }

    public void setmCpi(String mCpi) {
        this.mCpi = mCpi;
    }

    public String getfCpi() {
        return fCpi;
    }

    public void setfCpi(String fCpi) {
        this.fCpi = fCpi;
    }

    public List<String> getSampleNumList() {
        return sampleNumList;
    }

    public void setSampleNumList(List<String> sampleNumList) {
        this.sampleNumList = sampleNumList;
    }

    public List<String> getSampleNameList() {
        return sampleNameList;
    }

    public void setSampleNameList(List<String> sampleNameList) {
        this.sampleNameList = sampleNameList;
    }
    public List<String> getSampleNumberList() {
        return sampleNumberList;
    }

    public void setSampleNumberList(List<String> sampleNumberList) {
        this.sampleNumberList = sampleNumberList;
    }

    @Override
    public String toString() {
        return "CPICalculation{" +
                "fPIResults=" + fPIResults +
                ", mPIResults=" + mPIResults +
                ", mConclusion='" + mConclusion + '\'' +
                ", fConclusion='" + fConclusion + '\'' +
                ", mCpi='" + mCpi + '\'' +
                ", fCpi='" + fCpi + '\'' +
                ", sampleNumList=" + sampleNumList +
                ", sampleNumberList=" + sampleNumberList +
                ", sampleNameList=" + sampleNameList +
                '}';
    }
}
