package top.lothar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.lothar.bean.Book;
import top.lothar.bean.PageBean;
import top.lothar.dao.BookDao;
import top.lothar.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;
	
	@Override
	public PageBean queryForPage(int pageSize, int page) {
		// TODO Auto-generated method stub
		String hql = "from Book book order by book.id";
		
		//查询记录总数
		int allRowCounts = bookDao.findAllRowCounts(hql);
		//当前页
		int curPage = PageBean.curPage(page);
		//当前页的起始记录是(0,5,..)
		int curOffset = PageBean.curOffset(pageSize, curPage);
		//一共多少页
		int sumPages = PageBean.getSumPages(allRowCounts, pageSize);
		
		List<Book> books = bookDao.findForPage(hql, curOffset, pageSize);
		
		PageBean pageBean = new PageBean();
		pageBean.setAllRowCounts(allRowCounts);
		pageBean.setCurPage(curPage);
		pageBean.setSumPages(sumPages);
		pageBean.setBooks(books);//每一页应该显示的各个记录
		
		return pageBean;
	}

}
