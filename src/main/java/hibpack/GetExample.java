package hibpack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * To fatch data from Contact table
 */

public class GetExample {
	public static void main(String[] args) {
		Session session = null;

		try {
			// This step will read hibernate.cfg.xml and prepare hibernate for
			// use
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			
			Transaction tx = session.beginTransaction();
			
			// Fetching Contact
			System.out.println("Fetching Record");
			long contactId = 100;
			Contact contact = (Contact) session.get(Contact.class, contactId);
			System.out.println("Name = " + contact.getFirstName());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	}
}
