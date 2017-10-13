package polltwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import hibernate.entity.Choice;
import hibernate.entity.Question;
import polltwo.dao.ChoiceDAO;
import polltwo.dao.QuestionDAO;
import exceptions.QuestionNotFoundException;

@Controller
@RequestMapping(value="/vote/{questionId}")
public class VoteController {
	
	@Autowired
	private QuestionDAO questionDAO;
	@Autowired
	private ChoiceDAO choiceDAO;
	
	/**
	 * Displays voting form
	 * @param questionId int
	 * @param model
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String showChoices(@PathVariable("questionId") int questionId, Model model) {
	
		Question question = questionDAO.getQuestion(questionId);
		if (question == null) throw new QuestionNotFoundException();
		List<Choice> choices = question.getChoices();
		
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
		Integer choiceId = Integer.parseInt(request.getParameter("choiceId"));
		
		Choice choice = choiceDAO.getChoice(choiceId);
		
		choice.addVote();
		choiceDAO.updateChoice(choice);
		return "home";
	}
	
}
