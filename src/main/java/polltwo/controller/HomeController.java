package polltwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hibernate.entity.Question;
import polltwo.dao.QuestionDAO;

@Controller
public class HomeController {
	
	@Autowired
	private QuestionDAO questionDAO;
	
	@RequestMapping(value="/")
	public String showHome(Model model) {
		
		List<Question> questions = questionDAO.getQuestions();
		model.addAttribute("questions", questions);
		return "home";
	}
}
