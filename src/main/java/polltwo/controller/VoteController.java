package polltwo.controller;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import hibernate.entity.Choice;
import hibernate.entity.Question;
import hibernate.util.HibernateUtil;
import exceptions.QuestionNotFoundException;

@Controller
@RequestMapping(value="/vote/{questionId}")
public class VoteController {
	
	/**
	 * Displays voting form
	 * @param questionId int
	 * @param model
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String showChoices(@PathVariable("questionId") int questionId, Model model) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Question question = session.get(Question.class, questionId);
		if (question == null) throw new QuestionNotFoundException();
		List<Choice> choices = session.createQuery("from Choice choice where choice.question = :question")
				.setParameter("question", question).list();
		session.close();
		
		model.addAttribute("question", question);
		model.addAttribute("choices", choices);
		
		return "question/choices";
	}
	
	/**
	 * Increments Choice votes by 1 and returns to home page
	 * @param questionId int
	 * @param request WebRequest object
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String voteOnChoice(@PathVariable("questionId") int questionId, WebRequest request) {
		String choiceId = request.getParameter("choiceId");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Choice choice = session.get(Choice.class, Integer.parseInt(choiceId));
		
		choice.addVote();
		session.getTransaction().commit();
		session.close();
		
		return "home";
	}
	
}
