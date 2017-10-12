package polltwo.controller;

import java.util.List;

import org.hibernate.Session;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hibernate.entity.Choice;
import hibernate.entity.Question;
import hibernate.util.HibernateUtil;
import exceptions.QuestionNotFoundException;

@Controller
@RequestMapping(value="/vote")
public class VoteController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String showChoices(@RequestParam("questionId") int questionId, Model model) {
		
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
	
}
