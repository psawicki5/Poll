package polltwo.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hibernate.entity.Question;

@Repository 
public class QuestionDAOImpl implements QuestionDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public Question getQuestion(int questionId) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Question.class, questionId);
	}
	
	@Transactional
	public List<Question> getQuestions() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Question> theQuery = currentSession.createQuery("from Question", Question.class);
		return theQuery.getResultList();
	}

}
