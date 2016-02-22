package com.df.service;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.df.crawl.Spider;
import com.df.crawl.impl.HttpClientSpider;
import com.df.entity.CrawlResult;
import com.df.entity.CrawlTask;
import com.df.entity.qyxy.QiYe;
import com.df.parse.QyxyParser;

public class QYService {

	public void crawl() throws Exception{
		Map<String,String> data = new HashMap<String,String>();
		Spider spider = new HttpClientSpider();
		Map<String,Object> map = new HashMap<String,Object>();
		BufferedWriter w = null;
		try {
			CrawlTask task = new CrawlTask("http://qyxy.baic.gov.cn/dito/ditoAction!ycmlFrame.dhtml",map);
			QyxyParser qp = new QyxyParser();
			for(int i=0;i<100;i++){
				map.put("pageNos", i+1);
				map.put("pageNo", i);
				task.setParam(map);
				CrawlResult cr = spider.crawl(task);
				if(data.containsKey(cr.getContent())){
					System.out.println("已经抓取完毕");
					break;
				}
				data.put(cr.getContent(), "");
				Thread.sleep(3000);
			}
			w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:/qite.txt")));
					
			for(Entry<String,String> entity:data.entrySet()){
				List<QiYe> list = qp.parse(entity.getKey());
				for(int x=0;x<list.size();x++)
					w.write(list.get(x).toString()+"\n");
			}
			w.flush();
		} finally {
			if(null!=w)
				w.close();
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		QYService qs = new QYService();
		Date date = new Date();
		qs.crawl();
		System.out.println("总耗时:"+ (new Date().getTime() - date.getTime()));
	}
	
}
