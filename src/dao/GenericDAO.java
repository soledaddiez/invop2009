package dao;

import java.lang.reflect.ParameterizedType;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import dao.util.HibernateSessionFactory;
import excepciones.DataAccessException;
 
public abstract class GenericDAO<T> {
 
	public Class<T> domainClass = getDomainClass();
 
	protected Session session;
 
	/**
	  * Method to return the class of the domain object
	  */ 
	protected Class getDomainClass() {
	 	if (domainClass == null) {
			ParameterizedType thisType = (ParameterizedType) getClass()
 				.getGenericSuperclass();
			domainClass = (Class) thisType.getActualTypeArguments()[0];
	 	}
		return domainClass;
	}
 
//	@SuppressWarnings("unchecked")
//	public T load(Long id) {
//		T returnValue = (T) getHibernateTemplate().load(domainClass, id);
//		session.getTransaction().commit();
//		return returnValue;
//	}
	
	 @SuppressWarnings("unchecked")
     public T load(Long id) throws DataAccessException {
             try{
                     T returnValue = (T) getHibernateTemplate().load(domainClass, id);       
                     session.getTransaction().commit();      
                     return returnValue;
             } catch (HibernateException e) {
                     throw new DataAccessException(e);
             }
     }

 
	public void update(T t) throws DataAccessException {
		try {
			getHibernateTemplate().update(t);
	 		session.getTransaction().commit();
	 	} catch (HibernateException e) {
	 		throw new DataAccessException(e);
		}
	}
	
	public void updateAll(List<T> list) throws DataAccessException {
		for(T element : list)
			update(element);
	}
 
	public void save(T t) throws DataAccessException {
	 	try {
	 		getHibernateTemplate().save(t);
	 	
	 		session.getTransaction().commit();
	 		session.flush();
	 	} catch (HibernateException e) {
	 		throw new DataAccessException(e);
	 	}
	}
	
	public void saveAll(List<T> list) throws DataAccessException {
		for(T element : list)
			save(element);
	}
 
	public void delete(T t) {
	 	getHibernateTemplate().delete(t);
	 	session.getTransaction().commit();
	}
 
	@SuppressWarnings("unchecked")
	public List<T> getList() {
		List<T> returnList = getHibernateTemplate().createQuery(
	 			"from " + domainClass.getName() + " x").list();
		session.getTransaction().commit();
		return returnList;
	}
 
	public void deleteById(Long id) throws DataAccessException {
	 	Object obj = this.load(id);
	 	getHibernateTemplate().delete(obj);
	}
 
	public int deleteAll(boolean isSure) {
		int countDeleted = getHibernateTemplate().createQuery(
 			"delete " + domainClass.getName()).executeUpdate();
		if (isSure)
	 		session.getTransaction().commit();
	 	else
	 		session.getTransaction().rollback();
		return countDeleted;
	}
 
	public int count() {
	 	Integer count = (Integer) getHibernateTemplate().createQuery(
 			"select count(*) from " + domainClass.getName() + " x")
 			.uniqueResult();
		session.getTransaction().commit();
		return count.intValue();
	}
 
	public List<T> findByExample(T exampleObject) {
	 	Example example = Example.create(exampleObject).excludeZeroes()
 			.enableLike().ignoreCase();
		List<T> list = getHibernateTemplate().createCriteria(domainClass).add(
 			example).list();
		session.getTransaction().commit();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(Hashtable<String, Object> criteria) {
		Criteria crit = getHibernateTemplate().createCriteria(domainClass.getName());
		if (criteria != null){
			Set<String> ks = criteria.keySet();
			if (ks.size()>0){
				for(String key : ks){
					crit.add(Restrictions.eq(key, criteria.get(key)));	
				}
			}
		}
		
		List<T> returnList = crit.list(); 
		session.getTransaction().commit();
		return returnList;
	} 
	
	protected Session getHibernateTemplate() {
		session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		return session;
	}
}