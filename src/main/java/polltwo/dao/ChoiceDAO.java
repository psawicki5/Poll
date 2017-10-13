package polltwo.dao;

import java.util.List;

import hibernate.entity.Choice;

public interface ChoiceDAO {
	
	public List<Choice> getAllQuestions();
	public Choice getChoice(int questionId);
	public void updateChoice(Choice choice);
}
