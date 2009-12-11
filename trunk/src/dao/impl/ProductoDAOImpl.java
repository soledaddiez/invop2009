package dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import modelo.Producto;
import dao.ProductoDAO;

public class ProductoDAOImpl implements ProductoDAO{

	private SessionFactory sessionFactory;

    public ProductoDAOImpl() {
        AnnotationConfiguration annotConf = new AnnotationConfiguration();
        annotConf.addAnnotatedClass(Producto.class);
        annotConf.configure();
        // The line below generates the exception!
        sessionFactory = annotConf.buildSessionFactory();
    }

	@Override
	public void save(Producto producto) {
		Session session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();
        try {
                tx.begin();
                session.saveOrUpdate(producto);
                tx.commit();
        } catch (RuntimeException e) {
                tx.rollback();
                throw e;
        } finally {
                session.close();
        }
	}
}
