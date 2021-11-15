package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.FoodDetail;
import entity.Size;
import entity.Food;
import service.FoodDetailService;
import service.FoodService;
import service.SizeService;

@Controller
@RequestMapping(value = "/AdminController/fd")
public class FoodDetailController {
	
	@Autowired
	private FoodDetailService FoodDetailService;
	@Autowired
	private FoodService FoodService;
	@Autowired 
	private SizeService sizeService;
	
	@RequestMapping(value = "list.htm")
	public ModelAndView getAll() {
		ModelAndView mAndView = new ModelAndView("food_detail/index");
		List<Food> listFoods = FoodService.getAllFoods();
		mAndView.addObject("listFoods", listFoods);
		List<FoodDetail> listFds = FoodDetailService.getAllFoodDetails();
		mAndView.addObject("listFds", listFds);
		List<Size> listSizes = sizeService.getAllSizes();
		mAndView.addObject("listSizes", listSizes);
		return mAndView;
	}
	
	@RequestMapping(value = "/initAddFoodDetail.htm")
	public ModelAndView addFoodDetail() {
		ModelAndView mAndView = new ModelAndView("food_detail/NewFoodDetail");
		FoodDetail FoodDetail = new FoodDetail();
		List<Food> listFoods = FoodService.getAllFoods();
		List<Size> listSizes = sizeService.getAllSizes();
		mAndView.addObject("listSizes", listSizes);
		mAndView.addObject("listFoods", listFoods);
		mAndView.addObject("FoodDetailNew", FoodDetail);
		return mAndView;
	}
	
	@RequestMapping(value = "addFoodDetail.htm")
	public String addNewFoodDetail(FoodDetail FoodDetailNew) {
		boolean check = FoodDetailService.addFoodDetail(FoodDetailNew);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "/initUpdateFoodDetail.htm")
	public ModelAndView updateFoodDetail(int fdId) {
		ModelAndView mAndView = new ModelAndView("food_detail/UpdateFoodDetail");
		FoodDetail FoodDetail = FoodDetailService.findFoodDetailById(fdId);
		mAndView.addObject("FoodDetailUp", FoodDetail);
		List<Food> listFoods = FoodService.getAllFoods();
		List<Size> listSizes = sizeService.getAllSizes();
		mAndView.addObject("listSizes", listSizes);
		mAndView.addObject("listFoods", listFoods);
		return mAndView;
	}
	
	@RequestMapping(value = "/updateFoodDetail.htm")
	public String updateFoodDetail(FoodDetail FoodDetailUp) {
		boolean check = FoodDetailService.updateFoodDetail(FoodDetailUp);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "deleteFoodDetail.htm")
	public String deleteFoodDetail(int fdId) {
		boolean check = FoodDetailService.deleteFoodDetail(fdId);
		if (check) {
			return "redirect:list.htm";
		}else {
			return "Error";
		}
	}
}

