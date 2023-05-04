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
	
	public List<User> getAllUser(){
		list = new ArrayList<User>();
		session =  new DBConnection().getSession();
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
		return u1;
	}
	
	public void updateUser(User u) {
		session = new DBConnection().getSession();
		tx = session.beginTransaction();
		
		Query q = session.createQuery("update User u set u.Name=:Name, u.Contact=:Contact, u.Address=:Address, u.Email=:u.Email, u.Password=:Password where u.ID:=ID");
		q.setParameter("Name", u.getName());
		q.setParameter("Contact", u.getContact());
		q.setParameter("Address", u.getAddress());
		q.setParameter("Email", u.getEmail());
		q.setParameter("Password", u.getPassword());
		q.setParameter("ID", u.getID());
		
		list = q.list();
		u = list.get(0);
		
		tx.commit();
		session.close();
		System.out.println("Data Updated succesfully.");
	}
	
	public void deleteUser(int ID) {
		session = new DBConnection().getSession();
		tx = session.beginTransaction();
		
		Query q = session.createQuery("delete from User where ID=:ID");
		q.setParameter("ID", ID);
		
		tx.commit();
		session.close();
		System.out.println("Data Deleted Succesfully.");
	}
}