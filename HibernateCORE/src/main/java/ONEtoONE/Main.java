package ONEtoONE;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Question q1 = new Question();
		q1.setID(1);
		q1.setQuestion("What is Your Name");
		
		Question q2 = new Question();
		q2.setID(2);
		q2.setQuestion("Which Course you Learning");
		
		Answer a1 = new Answer();
		a1.setID(1);
		a1.setAnswer("DK");
		
		Answer a2 = new Answer();
		a2.setID(2);
		a2.setAnswer("JAVA");
		
		q1.setAnswer(a1);
		q2.setAnswer(a2);
		
		a1.setQuestion(q1);
		a2.setQuestion(q2);
		
		session.save(a1);
		session.save(a2);
		session.save(q1);
		session.save(q2);
		
		tx.commit();
		session.close();
		sf.close();
	}
}