package in.mj.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.mj.entities.User;

public class App {
	public static void main(String[] args) {

// Create mandatory objects : ------------------------------
		Configuration cfg = new Configuration();
		cfg.configure("/in/mj/config/hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

// Perform CRUD ooperations :----------------------------------------------------------

		// 1. INSERT data : --------------
//		User user = new User();
//		user.setId(1);
//		user.setName("Mangesh");
//		user.setEmail("mangesh@gmail.com");
//		user.setPassword("Mangesh@123");
//		user.setCity("Pune");

		User user1 = new User();
//		user1.setName("MJ");
//		user1.setEmail("mj@gmail.com");
//		user1.setPassword("mj@123");
//		user1.setCity("Mumbai");

		// Actual Insert query : (Always use try-catch block to prevent any error and
		// execute rollback)
		try {
			session.save(user1);
			transaction.commit();
			System.out.println("Data Inserted");
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			System.out.println("Data not inserted");
		}

		// 2. SELECT data : -----------------
		try {
			User user = session.get(User.class, 1);
			if (user != null) {
				System.out.println(user.getName());
				System.out.println(user.getEmail());
				System.out.println(user.getPassword());
				System.out.println(user.getCity());

				System.out.println("Data Inserted");
			} else {
				System.out.println("User not found");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
