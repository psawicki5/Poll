package polltwo.dao;

import java.util.List;

import hibernate.entity.Question;

public interface QuestionDAO {
	public Question getQuestion(int questionId);
	public List<Question> getQuestions();
}
