package Connection;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Model.User;

public class DBConnection {
	SessionFactory sf = null;
	Session session = null;
	Configuration cfg = null;
	Properties pro = null;

	public Session getSession() {
		pro = new Properties();
		pro.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		pro.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernatecore");
		pro.setProperty("hibernate.connection.username", "root");
		pro.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		pro.setProperty("hibernate.hbm2ddl.auto", "update");
		pro.setProperty("hibernate.show_sql", "true");
		pro.setProperty("hibernate.format_sql", "true");

		cfg = new Configuration();
		cfg.setProperties(pro).addAnnotatedClass(User.class);
		sf = cfg.buildSessionFactory();
		session = sf.openSession();
		return session;
	}
}
