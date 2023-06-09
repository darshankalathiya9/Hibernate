package com.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_Data")
public class User {
	@Id
	private int ID;
	private String Name;
	private double per;

	public User(int iD, String name, double per) {
		super();
		ID = iD;
		Name = name;
		this.per = per;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getPer() {
		return per;
	}

	public void setPer(double per) {
		this.per = per;
	}

	@Override
	public String toString() {
		return "User [ID=" + ID + ", Name=" + Name + ", per=" + per + "]";
	}

}
