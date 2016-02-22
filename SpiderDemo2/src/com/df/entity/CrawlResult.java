package com.df.entity;

import java.util.Date;

public class CrawlResult {
	
	private boolean isSuccess;

	private String code;
	
	private String content;
	
	private Date beginTime;
	
	private Date endTime;
	
	private CrawlTask task;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public CrawlTask getTask() {
		return task;
	}

	public void setTask(CrawlTask task) {
		this.task = task;
	}
	
}
