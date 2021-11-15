package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Contact;
import service.ContactService;

@Controller
@RequestMapping(value = "/AdminController/question")
public class ContactController {
	
	@Autowired
	private ContactService QuestionService;
	
	@RequestMapping(value = "list.htm")
	public ModelAndView getAll() {
		ModelAndView mAndView = new ModelAndView("contact/index");
		List<Contact> listQuestions = QuestionService.getAllQuestions();
		mAndView.addObject("listQuestions", listQuestions);
		return mAndView;
	}

	@RequestMapping(value = "/initAddQuestion.htm")
	public ModelAndView addQuestion() {
		ModelAndView mAndView = new ModelAndView("contact/NewQuestion");
		Contact Question = new Contact();
		mAndView.addObject("QuestionNew", Question);
		return mAndView;
	}
	
	@RequestMapping(value = "addQuestion.htm")
	public String addNewQuestion(Contact QuestionNew) {
		boolean check = QuestionService.addQuestion(QuestionNew);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "/initUpdateQuestion.htm")
	public ModelAndView updateQuestion(int qId) {
		ModelAndView mAndView = new ModelAndView("contact/UpdateQuestion");
		Contact Question = QuestionService.findQuestionById(qId);
		mAndView.addObject("QuestionUp", Question);
		return mAndView;
	}
	
	@RequestMapping(value = "/updateQuestion.htm")
	public String updateQuestion(Contact QuestionUp) {
		boolean check = QuestionService.updateQuestion(QuestionUp);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "deleteQuestion.htm")
	public String deleteQuestion(int qId) {
		boolean check = QuestionService.deleteQuestion(qId);
		if (check) {
			return "redirect:list.htm";
		}else {
			return "Error";
		}
	}
}


