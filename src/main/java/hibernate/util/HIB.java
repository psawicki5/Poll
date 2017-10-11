package hibernate.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import hibernate.entity.Choice;
import hibernate.entity.Question;
import hibernate.util.HibernateUtil;

public class HIB {

	public static void main(String[] args) {
		
		System.out.println("start");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		SimpleDateFormat sdfr = new SimpleDateFormat("dd-MM-yyyy");
		String date = sdfr.format(new Date());
		System.out.println(date);
		
		session.beginTransaction();
		
		//Question question = new Question("Co robisz", date);
		//session.save(question);
		
		//List<Question> questions = session.createQuery("from Question").list();
		
		Question question = session.get(Question.class, 1);
		
		//Choice w1 = new Choice(question, "pytanie 2", 0);
		
		//session.save(w1);
		
		//System.out.println(w1);
		
		//System.out.println(question);
		
		List<Choice> choiceOne = session.createQuery("from Choice obj where obj.question= :question").setParameter("question", question).list();
		
		for(Choice choice: question.getChoices()) {
			System.out.println(choice);
		}
		
		//System.out.println(choiceOne);
		session.getTransaction().commit();
		session.close();
	}

}
