package ONEtoMANY;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Seller s1 = new Seller();
		s1.setID(1);
		s1.setName("DK");

		Product p1 = new Product();
		p1.setPID(1);
		p1.setP_Name("Laptop");

		Product p2 = new Product();
		p2.setPID(2);
		p2.setP_Name("Mobile");


		List<Product> list = new ArrayList<Product>();
		list.add(p1);
		list.add(p2);

		s1.setProduct(list);
		p1.setSeller(s1);
		p2.setSeller(s1);

		session.save(s1);
		session.save(p1);
		session.save(p2);

		tx.commit();
		session.close();
		sf.close();
	}
}
