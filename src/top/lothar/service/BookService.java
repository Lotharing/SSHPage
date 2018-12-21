package top.lothar.service;

import top.lothar.bean.PageBean;

public interface BookService {
	
	public PageBean queryForPage(int pageSize , int page);
	
}
