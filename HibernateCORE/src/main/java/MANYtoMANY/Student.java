package MANYtoMANY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@Column(name = "Student_ID")
	private int ID;
	private String Name;
	@ManyToMany
	private List<Teacher> teacher;

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

	public List<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(List<Teacher> teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Student [ID=" + ID + ", Name=" + Name + ", teacher=" + teacher + "]";
	}

}
