package top.lothar.bean;
/**
 * 分页类
 * @author Lothar
 *
 */

import java.util.ArrayList;
import java.util.List;

public class PageBean {
	
	//总记录数
	private int allRowCounts;
	//每页记录数
	private int pageSize;
	//当前页
	private int curPage;
	//总页数
	private int sumPages;
	//存放books的List
	public List<Book> books = new ArrayList<Book>();
	/**
	 * 获取当前页的页数
	 * @param page
	 * @return
	 */
	public static int curPage(int page){
		return page == 0 ? 1 : page;
	}
	/**
	 * 获取当前页的起始记录数
	 * @param pageSize
	 * @param curPage
	 * @return
	 */
	public static int curOffset(int pageSize , int curPage){
		return pageSize * (curPage - 1);
	}
	/**
	 * 获取总的页数
	 * @param allRowCounts
	 * @param pageSize
	 * @return
	 */
	public static int getSumPages(int allRowCounts , int pageSize){
		return allRowCounts%pageSize == 0 ? allRowCounts/pageSize :(allRowCounts/pageSize + 1);
		
	}
	/**
	 * 无参构造
	 */
	public PageBean() {
		super();
	}
	/**
	 * 有参构造
	 * @param allRowCounts
	 * @param pageSize
	 * @param curPage
	 * @param sumPages
	 * @param books
	 */
	public PageBean(int allRowCounts, int pageSize, int curPage, int sumPages, List<Book> books) {
		super();
		this.allRowCounts = allRowCounts;
		this.pageSize = pageSize;
		this.curPage = curPage;
		this.sumPages = sumPages;
		this.books = books;
	}
	public int getAllRowCounts() {
		return allRowCounts;
	}
	public void setAllRowCounts(int allRowCounts) {
		this.allRowCounts = allRowCounts;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getSumPages() {
		return sumPages;
	}
	public void setSumPages(int sunPages) {
		this.sumPages = sunPages;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
