package MANYtoMANY;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Teacher {
	@Id
	private int ID;
	private String Name;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Student> student;

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

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Teacher [ID=" + ID + ", Name=" + Name + ", student=" + student + "]";
	}

}
