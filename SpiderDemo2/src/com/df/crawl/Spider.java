package com.df.crawl;

import com.df.entity.CrawlResult;
import com.df.entity.CrawlTask;

public interface Spider {

	public CrawlResult crawl(CrawlTask task);
	
}
