package com.bgi.ms.engine.base.bean.sample;
public class PIResult {
	private String marker;//基因位点名称
	private String formula;//计算公式
	private String pi;//单基因位点PI
	private String piSci;//单基因位点PI处理成保留小数的科学计数法形式
	private String remark;//备注
	private String parentGene;//家长位点值
	private String childGene;//孩子位点值
	public PIResult() {
	}

	public PIResult(String marker, String formula, String pi, String remark) {
		this.marker = marker;
		this.formula = formula;
		this.pi = pi;
		this.remark = remark;
	}

	public String getMarker() {
		return marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getPi() {
		return pi;
	}

	public void setPi(String pi) {
		this.pi = pi;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getParentGene() {
		return parentGene;
	}

	public void setParentGene(String parentGene) {
		this.parentGene = parentGene;
	}

	public String getChildGene() {
		return childGene;
	}

	public void setChildGene(String childGene) {
		this.childGene = childGene;
	}

	public String getPiSci() {
		return piSci;
	}

	public void setPiSci(String piSci) {
		this.piSci = piSci;
	}

	@Override
	public String toString() {
		return "PIResult{" +
				"marker='" + marker + '\'' +
				", formula='" + formula + '\'' +
				", pi='" + pi + '\'' +
				", piSci='" + piSci + '\'' +
				", remark='" + remark + '\'' +
				", parentGene='" + parentGene + '\'' +
				", childGene='" + childGene + '\'' +
				'}';
	}
}
