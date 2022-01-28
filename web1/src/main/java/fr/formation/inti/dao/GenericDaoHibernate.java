package fr.formation.inti.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.formation.inti.utils.HibernateUtils;

public class GenericDaoHibernate<T, I extends Serializable> implements IGenericDao<T, I> {
	
	private static final Log log = LogFactory.getLog(GenericDaoHibernate.class);
	private SessionFactory sf;
	private Session session;
	private Transaction tx;
	
	private final Class<T> type;
	
	
	
	public Session getSession() {
		return session;
	}


	@SuppressWarnings("unchecked")
	public GenericDaoHibernate() {
		ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
		this.type = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
	}
	
	
	public void begin() {
		sf = HibernateUtils.getSessionFactory();
		session = sf.getCurrentSession();
	}
	
	public void close() {
		sf.close();
	}
	
	public void beginTransaction() {
		if(!session.isOpen())
			session = sf.getCurrentSession();
		tx = session.getTransaction();
		tx.begin();
	}
	
	public void commitTransaction() {
		tx.commit();
	}
	
	public void rollbackTransaction() {
		tx.rollback();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public I save(T t) {
		I id = (I) session.save(t);
		log.info(t);
		
		return id;
	}
	
	@Override
	public void update(T t) {
		session.update(t);
	}
	
	@Override
	public void delete(T t) {
		session.delete(t);
	}
	
	@Override
	public T findById(I i) {
		
		T t = session.get(type, i);
		
		return t;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		String hql = "select t from "+type.getName()+" t";
		
		Query<T> query = session.createQuery(hql);
		List<T> list = query.getResultList();
		
		return list;
	}
	
}
