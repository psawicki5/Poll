package hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Question")
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
	private int id;
	
	@Column(name="questionText", nullable=false, length=255)
	private String questionText;
	
	@Column(name="pubDate", length=32)
	private String pubDate;
	
	@OneToMany(mappedBy="question")
	private List<Choice> choices = new ArrayList<Choice>();
	
	public Question() {
		
	}
	
	public Question(String questionText, String pubDate, List<Choice> choices) {

		this.questionText = questionText;
		this.pubDate = pubDate;
		this.choices = choices;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", questionText=" + questionText + ", pubDate=" + pubDate + "]";
	}

	public List<Choice> getChoices() {
		return choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}
	
}
