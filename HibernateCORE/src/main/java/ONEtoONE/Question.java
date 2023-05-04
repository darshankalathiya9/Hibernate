package ONEtoONE;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Question {

	@Id
	private int ID;
	private String question;
	@OneToOne
	@JoinColumn(name = "A_ID")
	private Answer answer;

	@Override
	public String toString() {
		return "Question [ID=" + ID + ", question=" + question + ", answer=" + answer + "]";
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

}
