package com.df.entity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class CrawlTask {

	private String url;
	
	private boolean isPost;
	
	private Map<String,Object> param;
	
	private URL url2 = null;
	
	public CrawlTask(String url){
		this(url,false,null);
	}
	
	public CrawlTask(String url,Map<String,Object> param){
		this(url,true,param);
	}
	
	public CrawlTask(String url,boolean isPost,Map<String,Object> param){
		this.url = url;
		this.isPost = isPost;
		this.param = param;
		try {
			url2 = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isPost() {
		return isPost;
	}

	public void setPost(boolean isPost) {
		this.isPost = isPost;
	}

	public Map<String, Object> getParam() {
		return param;
	}

	public void setParam(Map<String, Object> param) {
		this.param = param;
	}
	
	public String getHost(){
		return url2.getHost();
	}
	
	public int getPort(){
		return url2.getPort();
	}
	
	public String getProtocol(){
		return url2.getProtocol();
	}
	
	public String getPath(){
		return url2.getPath();
	}
}
