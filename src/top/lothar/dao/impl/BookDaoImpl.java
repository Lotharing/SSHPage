package top.lothar.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import top.lothar.bean.Book;
import top.lothar.dao.BookDao;

@Transactional
@Repository
public class BookDaoImpl implements BookDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currentSession(){
		return sessionFactory.openSession();
	}
	/**
	 * 分页查询
	 * off 	起始位置
	 * len	查询长度
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findForPage(String hql, int off, int len) {
		// TODO Auto-generated method stub
		Session session = null;
		List<Book> books = null;
		session = currentSession();
		
		Query query = session.createQuery(hql);
		query.setFirstResult(off);
		query.setMaxResults(len);
		
		books = query.list();
		session.close();
		
		return books;
		
	}
	/**
	 * 查询记录总数
	 */
	@Override
	public int findAllRowCounts(String hql) {
		// TODO Auto-generated method stub
		Session session = null;
		session = currentSession();
		Query query = session.createQuery(hql);
		return query.list().size();
	}

}
