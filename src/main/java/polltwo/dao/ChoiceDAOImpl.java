package polltwo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hibernate.entity.Choice;

@Repository
public class ChoiceDAOImpl implements ChoiceDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Choice> getAllQuestions() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Choice> query = currentSession.createQuery("from Choice", Choice.class);
		return query.getResultList();
	}
	
	@Transactional
	public Choice getChoice(int questionId) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Choice.class, questionId);
	}
	
	@Transactional
	public void updateChoice(Choice choice) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(choice);
	}

}
