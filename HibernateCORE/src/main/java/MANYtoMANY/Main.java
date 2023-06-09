package MANYtoMANY;

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

		Teacher t1 = new Teacher();
		t1.setID(1);
		t1.setName("DK");
		
		Teacher t2 = new Teacher();
		t2.setID(2);
		t2.setName("Bhano");
		
		Student s1 = new Student();
		s1.setID(1);
		s1.setName("Tirthu");
		
		Student s2 = new Student();
		s2.setID(2);
		s2.setName("Piyush");
		
		List<Student> slist = new ArrayList<Student>();
		slist.add(s1);
		slist.add(s2);
		
		List<Teacher> tlist = new ArrayList<Teacher>();
		tlist.add(t1);
		tlist.add(t2);
		
		s1.setTeacher(tlist);
		s2.setTeacher(tlist);
		
		t1.setStudent(slist);
		t2.setStudent(slist);
		
		session.save(t1);
		session.save(t2);		
		
		tx.commit();
		session.close();
		sf.close();
	}
}
