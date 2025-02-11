package hibpack;

import org.hibernate.Session;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;
/**
 * Hibernate Criteria Query
 */
public class HibernateCriteriaQueryExample {
	public static void main(String[] args) {
		Session session = null;
		try {
			// This step will read hibernate.cfg.xml and prepare hibernate for
			// use
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			//Criteria Query Example
			Criteria crit = session.createCriteria(Insurance.class);
			List insurances = crit.list();
			for(Iterator it = insurances.iterator();it.hasNext();){
				Insurance insurance = (Insurance) it.next();
				System.out.println("ID: " + insurance.getLngInsuranceId());
				System.out.println("Name: " + insurance.getInsuranceName());
				
			}
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
		}		
	}
}
