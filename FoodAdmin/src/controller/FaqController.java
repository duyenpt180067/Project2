package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Faq;
import service.FaqService;

@Controller
@RequestMapping(value = "/AdminController/faq")
public class FaqController {
	
	@Autowired
	private FaqService FaqService;
	
	@RequestMapping(value = "list.htm")
	public ModelAndView getAll() {
		ModelAndView mAndView = new ModelAndView("faq/index");
		List<Faq> listFaqs = FaqService.getAllFaqs();
		mAndView.addObject("listFaqs", listFaqs);
		return mAndView;
	}

	@RequestMapping(value = "/initAddFaq.htm")
	public ModelAndView addFaq() {
		ModelAndView mAndView = new ModelAndView("faq/NewFaq");
		Faq Faq = new Faq();
		mAndView.addObject("FaqNew", Faq);
		return mAndView;
	}
	
	@RequestMapping(value = "addFaq.htm")
	public String addNewFaq(Faq FaqNew) {
		boolean check = FaqService.addFaq(FaqNew);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "/initUpdateFaq.htm")
	public ModelAndView updateFaq(int faqId) {
		ModelAndView mAndView = new ModelAndView("faq/UpdateFaq");
		Faq Faq = FaqService.findFaqById(faqId);
		mAndView.addObject("FaqUp", Faq);
		return mAndView;
	}
	
	@RequestMapping(value = "/updateFaq.htm")
	public String updateFaq(Faq FaqUp) {
		boolean check = FaqService.updateFaq(FaqUp);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "deleteFaq.htm")
	public String deleteFaq(int faqId) {
		boolean check = FaqService.deleteFaq(faqId);
		if (check) {
			return "redirect:list.htm";
		}else {
			return "Error";
		}
	}
}
