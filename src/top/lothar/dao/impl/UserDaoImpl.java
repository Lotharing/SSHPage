package top.lothar.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import top.lothar.bean.User;
import top.lothar.dao.UserDao;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currentSession(){
		return sessionFactory.openSession();
	}
	
	@Override
	public User findByUser(String username, String password) {
		// TODO Auto-generated method stub
		Session session = null;
		User result = null;
		
		session = currentSession();
		Transaction tx = session.beginTransaction();
		String hsql = "from User u where u.username = :uusername and u.password = :upassword";
		Query query = session.createQuery(hsql);
		query.setParameter("uusername", username);
		query.setParameter("upassword", password);
		result = (User) query.uniqueResult();
		tx.commit();
		session.close();
		return result;
	}

}
