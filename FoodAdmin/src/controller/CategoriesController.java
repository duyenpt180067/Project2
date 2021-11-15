package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Categories;
import service.CategoriesService;

@Controller
@RequestMapping(value = "/AdminController/categories")
public class CategoriesController {
	
	@Autowired
	private CategoriesService CategoriesService;
	
	@RequestMapping(value = "list.htm")
	public ModelAndView getAll() {
		ModelAndView mAndView = new ModelAndView("categories/index");
		List<Categories> listCategoriess = CategoriesService.getAllCategoriess();
		mAndView.addObject("listCategoriess", listCategoriess);
		return mAndView;
	}

	@RequestMapping(value = "initAddCategory.htm")
	public ModelAndView addCategories() {
		ModelAndView mAndView = new ModelAndView("categories/create");
		Categories Categories = new Categories();
		mAndView.addObject("CategoryNew", Categories);
		return mAndView;
	}
	
	@RequestMapping(value = "addCategory.htm")
	public String addNewCategories(Categories CategoryNew) {
		boolean check = CategoriesService.addCategories(CategoryNew);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "initUpdateCategory.htm")
	public ModelAndView updateCategories(int caId) {
		ModelAndView mAndView = new ModelAndView("categories/edit");
		Categories Categories = CategoriesService.findCategoriesById(caId);
		mAndView.addObject("CategoryUp", Categories);
		return mAndView;
	}
	
	@RequestMapping(value = "updateCategory.htm")
	public String updateCategories(Categories CategoryUp) {
		boolean check = CategoriesService.updateCategories(CategoryUp);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "deleteCategory.htm")
	public String deleteCategories(int caId) {
		boolean check = CategoriesService.deleteCategories(caId);
		if (check) {
			return "redirect:list.htm";
		}else {
			return "Error";
		}
	}
}


