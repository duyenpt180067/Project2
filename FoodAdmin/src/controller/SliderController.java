package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Slider;
import service.SliderService;

@Controller
@RequestMapping(value = "/AdminController/slider")
public class SliderController {
	
	@Autowired
	private SliderService SliderService;
	
	@RequestMapping(value = "list.htm")
	public ModelAndView getAll() {
		ModelAndView mAndView = new ModelAndView("slider/index");
		List<Slider> listSliders = SliderService.getAllSliders();
		mAndView.addObject("listSliders", listSliders);
		return mAndView;
	}

	@RequestMapping(value = "/initAddSlider.htm")
	public ModelAndView addSlider() {
		ModelAndView mAndView = new ModelAndView("slider/NewSlider");
		Slider Slider = new Slider();
		mAndView.addObject("SliderNew", Slider);
		return mAndView;
	}
	
	@RequestMapping(value = "addSlider.htm")
	public String addNewSlider(Slider SliderNew) {
		boolean check = SliderService.addSlider(SliderNew);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "/initUpdateSlider.htm")
	public ModelAndView updateSlider(int sliderId) {
		ModelAndView mAndView = new ModelAndView("slider/UpdateSlider");
		Slider Slider = SliderService.findSliderById(sliderId);
		mAndView.addObject("SliderUp", Slider);
		return mAndView;
	}
	
	@RequestMapping(value = "/updateSlider.htm")
	public String updateSlider(Slider SliderUp) {
		boolean check = SliderService.updateSlider(SliderUp);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "deleteSlider.htm")
	public String deleteSlider(int sliderId) {
		boolean check = SliderService.deleteSlider(sliderId);
		if (check) {
			return "redirect:list.htm";
		}else {
			return "Error";
		}
	}
}


