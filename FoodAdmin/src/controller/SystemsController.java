package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Systems;
import service.SystemsService;

@Controller
@RequestMapping(value = "/AdminController/systems")
public class SystemsController {
	
	@Autowired
	private SystemsService SystemsService;
	
	@RequestMapping(value = "list.htm")
	public ModelAndView getAll() {
		ModelAndView mAndView = new ModelAndView("systems/index");
		List<Systems> listSystemss = SystemsService.getAllSystemss();
		mAndView.addObject("listSystemss", listSystemss);
		return mAndView;
	}

	@RequestMapping(value = "/initAddSystems.htm")
	public ModelAndView addSystems() {
		ModelAndView mAndView = new ModelAndView("systems/NewSystems");
		Systems Systems = new Systems();
		mAndView.addObject("SystemsNew", Systems);
		return mAndView;
	}
	
	@RequestMapping(value = "addSystems.htm")
	public String addNewSystems(Systems SystemsNew) {
		boolean check = SystemsService.addSystems(SystemsNew);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "/initUpdateSystems.htm")
	public ModelAndView updateSystems(int systemId) {
		ModelAndView mAndView = new ModelAndView("systems/UpdateSystems");
		Systems Systems = SystemsService.findSystemsById(systemId);
		mAndView.addObject("SystemsUp", Systems);
		return mAndView;
	}
	
	@RequestMapping(value = "/updateSystems.htm")
	public String updateSystems(Systems SystemsUp) {
		boolean check = SystemsService.updateSystems(SystemsUp);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "deleteSystems.htm")
	public String deleteSystems(int systemId) {
		boolean check = SystemsService.deleteSystems(systemId);
		if (check) {
			return "redirect:list.htm";
		}else {
			return "Error";
		}
	}
}

