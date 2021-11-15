package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import entity.Answer;
import entity.Contact;
import service.AnswerService;
import service.ContactService;

@Controller
@RequestMapping(value = "/AdminController/answer")
public class AnswerController {
	
	@Autowired
	private AnswerService AnswerService;
	@Autowired
	private ContactService QuestionService;

	
	@RequestMapping(value = "list.htm")
	public ModelAndView getAll() {
		ModelAndView mAndView = new ModelAndView("answer/index");
		List<Answer> listAnswers = AnswerService.getAllAnswers();
		List<Contact> listQuestions = QuestionService.getAllQuestions();
		mAndView.addObject("listQuestions", listQuestions);
		mAndView.addObject("listAnswers", listAnswers);
		return mAndView;
	}
	
	@RequestMapping(value = "initAddAnswer.htm")
	public ModelAndView addAnswer() {
		ModelAndView mAndView = new ModelAndView("answer/NewAnswer");
		Answer answer = new Answer();
		List<Contact> listQuestions = QuestionService.getAllQuestions();
		mAndView.addObject("listQuestions", listQuestions);
		mAndView.addObject("answerNew", answer);
		return mAndView;
	}
	
	@RequestMapping(value = "addAnswer.htm")
	public String addNewAnswer(Answer answerNew) {
		boolean check = AnswerService.addAnswer(answerNew);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "initUpdateAnswer.htm")
	public ModelAndView updateAnswer(int answerId) {
		ModelAndView mAndView = new ModelAndView("answer/UpdateAnswer");
		List<Contact> listQuestions = QuestionService.getAllQuestions();
		mAndView.addObject("listQuestions", listQuestions);
		Answer Answer = AnswerService.findAnswerById(answerId);
		mAndView.addObject("AnswerUp", Answer);
		return mAndView;
	}
	
	@RequestMapping(value = "updateAnswer.htm")
	public String updateAnswer(Answer AnswerUp) {
		boolean check = AnswerService.updateAnswer(AnswerUp);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "deleteAnswer.htm")
	public String deleteAnswer(int answerId) {
		boolean check = AnswerService.deleteAnswer(answerId);
		if (check) {
			return "redirect:list.htm";
		}else {
			return "Error";
		}
	}
}
