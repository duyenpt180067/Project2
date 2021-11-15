package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Size;
import service.SizeService;

@Controller
@RequestMapping(value = "/AdminController/size")
public class SizeController {
	
	@Autowired
	private SizeService SizeService;
	
	@RequestMapping(value = "list.htm")
	public ModelAndView getAll() {
		ModelAndView mAndView = new ModelAndView("size/index");
		List<Size> listSizes = SizeService.getAllSizes();
		mAndView.addObject("listSizes", listSizes);
		return mAndView;
	}

	@RequestMapping(value = "/initAddSize.htm")
	public ModelAndView addSize() {
		ModelAndView mAndView = new ModelAndView("size/NewSize");
		Size Size = new Size();
		mAndView.addObject("SizeNew", Size);
		return mAndView;
	}
	
	@RequestMapping(value = "addSize.htm")
	public String addNewSize(Size SizeNew) {
		boolean check = SizeService.addSize(SizeNew);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "/initUpdateSize.htm")
	public ModelAndView updateSize(int sizeId) {
		ModelAndView mAndView = new ModelAndView("size/UpdateSize");
		Size Size = SizeService.findSizeById(sizeId);
		mAndView.addObject("SizeUp", Size);
		return mAndView;
	}
	
	@RequestMapping(value = "/updateSize.htm")
	public String updateSize(Size SizeUp) {
		boolean check = SizeService.updateSize(SizeUp);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "deleteSize.htm")
	public String deleteSize(int sizeId) {
		boolean check = SizeService.deleteSize(sizeId);
		if (check) {
			return "redirect:list.htm";
		}else {
			return "Error";
		}
	}
}


