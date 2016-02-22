package com.df.spider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientSpider2 {

	public static void main(String[] args) throws Exception{
//		String url = "http://www.wdzj.com/front_select-plat";
		String url = "http://qyxy.baic.gov.cn/dito/ditoAction!ycmlFrame.dhtml";
		 CloseableHttpClient httpclient = HttpClients.createDefault();
	        try {
//	        	httpclient.getParams().setParameter(HttpMethodParams.USER_AGENT,"Mozilla/5.0 (X11; U; Linux i686; zh-CN; rv:1.9.1.2) Gecko/20090803 Fedora/3.5.2-2.fc11 Firefox/3.5.2");
	        	RequestBuilder rb = RequestBuilder.post(url);
	        	
//	        	rb.addParameter("querystr", "请输入企业名称或注册号");
	        	rb.addParameter("pageNos", "3");
	        	rb.addParameter("pageNo", "2");
	        	rb.addParameter("pageSize", "10");
	        	rb.addParameter("clear", "");
	        	
	        	rb.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.103 Safari/537.36");
	        	
	        	HttpUriRequest httpRequest = rb.build();
	        	CloseableHttpResponse response1 = httpclient.execute(httpRequest);
	            BufferedReader br =null;
	            try {
	                System.out.println(response1.getStatusLine());
	                HttpEntity entity1 = response1.getEntity();
	                br = new BufferedReader(new InputStreamReader(entity1.getContent()));
	                
	                String line = null;
	                while(null!=(line=br.readLine())){
	                	System.out.println(line);
	                }
	            } finally {
	            	if(null!=br)
	            		br.close();
	                response1.close();
	            }

	        } finally {
	            httpclient.close();
	        }

	}

}
