package com.bgi.ms.engine.base.bean.sample;
public class Marker {
	private String marker;//基因位点名称
	private String allele1;//等位基因检测值1
	private String allele2;//等位基因检测值2
	private String allele3;//等位基因检测值3
	public Marker(String marker,String allele1,String allele2) {
		this.marker=marker;
		this.allele1=allele1;
		this.allele2=allele2;
	}
	public Marker(String marker,String allele1,String allele2,String allele3) {
		this.marker=marker;
		this.allele1=allele1;
		this.allele2=allele2;
		this.allele3=allele3;
	}
	public Marker() {
		
	}
	public Boolean isEqual(Marker marker1) {
		if(null==marker1) {
			return false;
		}
		if((allele1.equals(marker1.getAllele1())&&allele2.equals(marker1.getAllele2()))||(allele2.equals(marker1.getAllele1())&&allele1.equals(marker1.getAllele2()))) {
			return true;
		}
		return false;
	}
	
	public Boolean isSimilar(Marker marker1) {
		if(null==marker1) {
			return false;
		}
		if(allele1.equals(marker1.getAllele1())||allele1.equals(marker1.getAllele2())||allele2.equals(marker1.getAllele1())||allele2.equals(marker1.getAllele2())) {
			return true;
		}
		return false;
	}
	public String getMarker() {
		return marker;
	}
	public void setMarker(String marker) {
		this.marker = marker;
	}
	public String getAllele1() {
		return allele1;
	}
	public void setAllele1(String allele1) {
		this.allele1 = allele1;
	}
	public String getAllele2() {
		return allele2;
	}
	public void setAllele2(String allele2) {
		this.allele2 = allele2;
	}
	public String getAllele3() {
		return allele3;
	}
	public void setAllele3(String allele3) {
		this.allele3 = allele3;
	}
	public Boolean equalsMarker(Marker othermarker) {
		if(null==othermarker) {
			return false;
		}
		if(marker.equals(othermarker.getMarker())&&allele1.equals(othermarker.getAllele1())&&allele2.equals(othermarker.getAllele2())) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Marker [marker=" + marker + ", allele1=" + allele1 + ", allele2=" + allele2 + ", allele3=" + allele3
				+ "]";
	}
}
