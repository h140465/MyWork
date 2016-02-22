package com.df.parse;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.df.entity.CrawlResult;
import com.df.entity.qyxy.QiYe;

public class QyxyParser {
	
	public List<QiYe> parse(CrawlResult cr){
		if(!cr.isSuccess()||cr.getContent().isEmpty())
			return null;
		List<QiYe> list = new ArrayList<QiYe>();
		Document doc = Jsoup.parse(cr.getContent());
		Element e = doc.select("table").first();
		Elements trs = e.select("tr[style]");
		for(Element tr :trs){
			QiYe q = new QiYe();
			Elements tds = tr.children();
			q.setName(tds.get(0).text());
			q.setCode(tds.get(1).text());
			q.setDate(tds.get(2).text());
			list.add(q);
		}
		return list;
	}
	
	public List<QiYe> parse(String str){
		List<QiYe> list = new ArrayList<QiYe>();
		Document doc = Jsoup.parse(str);
		Element e = doc.select("table").first();
		Elements trs = e.select("tr[style]");
		for(Element tr :trs){
			QiYe q = new QiYe();
			Elements tds = tr.children();
			q.setName(tds.get(0).text());
			q.setCode(tds.get(1).text());
			q.setDate(tds.get(2).text());
			list.add(q);
		}
		return list;
	}
}
