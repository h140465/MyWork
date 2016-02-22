package com.df.entity.qyxy;

public class QiYe {
	
	private String name;
	
	private String code;
	
	private String src;
	
	private String date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "企业名称："+name+",编号:"+code+",时间:"+date;
	}
	
	
}
