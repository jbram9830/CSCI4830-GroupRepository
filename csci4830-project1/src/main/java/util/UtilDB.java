/**
 */
package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import datamodel.DataModelPost;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class UtilDB {
   static SessionFactory sessionFactory = null;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory != null) {
         return sessionFactory;
      }
      Configuration configuration = new Configuration().configure();
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
      sessionFactory = configuration.buildSessionFactory(builder.build());
      return sessionFactory;
   }

   public static List<DataModelPost> listDataModelPosts() {
      List<DataModelPost> resultList = new ArrayList<DataModelPost>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;  // each process needs transaction and commit the changes in DB.

      try {
         tx = session.beginTransaction();
         List<?> DataModelPosts = session.createQuery("FROM DataModelPost").list();
         for (Iterator<?> iterator = DataModelPosts.iterator(); iterator.hasNext();) {
            DataModelPost DataModelPost = (DataModelPost) iterator.next();
            resultList.add(DataModelPost);
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static List<DataModelPost> listDataModelPosts(String keyword) {
      List<DataModelPost> resultList = new ArrayList<DataModelPost>();
      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         System.out.println((DataModelPost)session.get(DataModelPost.class, 1)); // use "get" to fetch data
        // Query q = session.createQuery("FROM DataModelPost");
         List<?> DataModelPosts = session.createQuery("FROM DataModelPost").list();
         for (Iterator<?> iterator = DataModelPosts.iterator(); iterator.hasNext();) {
            DataModelPost post = (DataModelPost) iterator.next();
            if (keyword == null) {
            	resultList.add(post);

            }
	            if (keyword != null && post.getPost_id() == Integer.valueOf(keyword)) {
	            	resultList.add(post);
	            }
            
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static void createDataModelPost(String palias, String tname, Integer tscore, String pbody, String post_timestamp, String etimestamp, String post_type) {
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         session.save(new DataModelPost(palias, tname, tscore, pbody, 0, post_timestamp, etimestamp, post_type));
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
   
   public static void deletePost(String id){
	   Session session = getSessionFactory().openSession();      
	   Transaction tx = null;
	   try {
		   tx = session.beginTransaction();
		   String hql = "delete from DataModelPost where post_id = "+ id; 
		   Query query = session.createQuery(hql);
		   query.executeUpdate();
		   tx.commit();
	   } finally {
		   session.close();
	   }
   }
   
   public static void deleteComment(String id){
	   Session session = getSessionFactory().openSession();      
	   Transaction tx = null;
	   try {
		   tx = session.beginTransaction();
		   String hql = "delete from DataModelComment where post_id = "+ id; 
		   Query query = session.createQuery(hql);
		   query.executeUpdate();
		   tx.commit();
	   } finally {
		   session.close();
	   }
   }
}
