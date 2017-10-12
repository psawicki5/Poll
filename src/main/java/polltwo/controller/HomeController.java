package polltwo.controller;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hibernate.entity.Question;
import hibernate.util.HibernateUtil;

@Controller

public class HomeController {
	
	@RequestMapping(value="/")
	public String showHome(Model model) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<Question> questions = session.createQuery("from Question").list();
		session.close();
		model.addAttribute("questions", questions);
		return "home";
	}
}
