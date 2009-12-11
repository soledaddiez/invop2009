package dao.util;

import modelo.Producto;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateSessionFactory
{
  public static final SessionFactory sessionFactory;

  static
  {
    try
    {
      AnnotationConfiguration annotConf = new AnnotationConfiguration();
      annotConf.addAnnotatedClass(Producto.class);
      annotConf.configure();
      // The line below generates the exception!
      sessionFactory = annotConf.buildSessionFactory();
//      sessionFactory = new AnnotationConfiguration().configure()
//        .buildSessionFactory();
    } catch (Throwable ex) {
      System.err.println("Initial SessionFactory creation failed." + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}