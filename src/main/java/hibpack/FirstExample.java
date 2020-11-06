package hibpack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate example to insert data into Contact table
 */

public class FirstExample {
	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		
		try {
			// This step will read hibernate.cfg.xml and prepare hibernate for
			// use
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			
			tx = session.beginTransaction();
			
			// Create new instance of Contact and set values in it
			System.out.println("Inserting Record");
			Contact contact = new Contact();
			contact.setId(102);
			contact.setFirstName("Cathy");
			contact.setLastName("Cooper");
			contact.setEmail("cathycooper@gmail.com");
			
			session.saveOrUpdate(contact);
			
			System.out.println("Done");
			tx.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			tx.rollback();
		} finally {
			// Actual contact insertion will happen at this step
			System.out.println("Flush...");
			session.flush();
			session.close();
		}
	}
}
