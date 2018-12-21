package top.lothar.dao;

import java.util.List;

import top.lothar.bean.Book;

public interface BookDao {
	/**
	 * 分页查询
	 * @param hql	查询条件
	 * @param off	记录起始点
	 * @param len	查询数量
	 * @return
	 */
	public 	List<Book> findForPage(String hql, int off, int len);
	/**
	 * 查询记录总数
	 * @param hql
	 * @return
	 */
	public int findAllRowCounts(String hql);
}
