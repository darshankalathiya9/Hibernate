package Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Connection.DBConnection;
import Model.User;

public class UserDao {
	Session session = null;
	Transaction tx = null;
	List<User> list = null;

	public void insertUser(User u) {
		session = new DBConnection().getSession();
		tx = session.beginTransaction();

		session.save(u);

		tx.commit();
		session.close();

		System.out.println("Data Inserted succesfully.");
	}

	public User userLogin(User u) {
		User u1 = null;
		session = new DBConnection().getSession();
		tx = session.beginTransaction();

		Query q = session.createQuery("from User u where u.Email=:Email and u.Password=:Password");
		q.setParameter("Email", u.getEmail());
		q.setParameter("Password", u.getPassword());

		list = q.list();
		u1 = list.get(0);

		tx.commit();
		session.close();
		return u1;
	}

	public List<User> getAllUser() {
		list = new ArrayList<User>();
		session = new DBConnection().getSession();
		tx = session.beginTransaction();

		Query q = session.createQuery("from User");
		list = q.list();

		tx.commit();
		session.close();
		return list;
	}

	public User getUserByID(int ID) {
		User u1 = null;
		session = new DBConnection().getSession();
		tx = session.beginTransaction();

		Query q = session.createQuery("from User u where u.ID=:ID");
		q.setParameter("ID", ID);
		list = q.list();
		u1 = list.get(0);

		tx.commit();
		session.close();
		System.out.println(u1);
		return u1;
	}

	public void updateUser(User u) {
		session = new DBConnection().getSession();
		tx = session.beginTransaction();

		Query q = session.createQuery("update User u set u.Name=?1, u.Contact=?2, u.Address=?3, u.Email=?4, u.Password=?5 where u.ID=?6");
		q.setParameter(1, u.getName());
		q.setParameter(2, u.getContact());
		q.setParameter(3, u.getAddress());
		q.setParameter(4, u.getEmail());
		q.setParameter(5, u.getPassword());
		q.setParameter(6, u.getID());
		q.executeUpdate();

		tx.commit();
		session.close();
		System.out.println("Data Updated succesfully.");
	}

	public void deleteUser(User u) {
		session = new DBConnection().getSession();
		tx = session.beginTransaction();

		session.delete(u);

		tx.commit();
		session.close();
		System.out.println("Data Deleted Succesfully.");
	}
}
