package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Food;
import entity.FoodDetail;
import entity.Size;
//import entity.Bonus;
import entity.Categories;
import service.FoodService;
import service.SizeService;
import service.CategoriesService;
import service.FoodDetailService;

@Controller
@RequestMapping(value = "/AdminController/food")
public class FoodController {
	
	@Autowired
	private FoodDetailService FoodDetailService;
	@Autowired 
	private SizeService sizeService;
	@Autowired
	private FoodService FoodService;
	
	@Autowired
	private CategoriesService CategoriesService;
	
	@RequestMapping(value = "list.htm")
	public ModelAndView getAll() {
		ModelAndView mAndView = new ModelAndView("food/index");
		List<Food> listFoods = FoodService.getAllFoods();
		mAndView.addObject("listFoods", listFoods);
		List<Categories> listCategoriess = CategoriesService.getAllCategoriess();
		mAndView.addObject("listCategoriess", listCategoriess);
		return mAndView;
	}

	@RequestMapping(value = "/initAddFood.htm")
	public ModelAndView addFood() {
		ModelAndView mAndView = new ModelAndView("food/NewFood");
		Food Food = new Food();
		List<Categories> listCategoriess = CategoriesService.getAllCategoriess();
		mAndView.addObject("listCategoriess", listCategoriess);
		mAndView.addObject("FoodNew", Food);
		return mAndView;
	}
	
	@RequestMapping(value = "addFood.htm")
	public String addNewFood(Food FoodNew) {
		boolean check = FoodService.addFood(FoodNew);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "/initUpdateFood.htm")
	public ModelAndView updateFood(String foodId) {
		ModelAndView mAndView = new ModelAndView("food/UpdateFood");
		List<Categories> listCategoriess = CategoriesService.getAllCategoriess();
		mAndView.addObject("listCategoriess", listCategoriess);
		Food Food = FoodService.findFoodById(foodId);
		mAndView.addObject("FoodUp", Food);
		return mAndView;
	}
	
	@RequestMapping(value = "/updateFood.htm")
	public String updateFood(Food FoodUp) {
		boolean check = FoodService.updateFood(FoodUp);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "deleteFood.htm")
	public String deleteFood(String foodId) {
		boolean check = FoodService.deleteFood(foodId);
		if (check) {
			return "redirect:list.htm";
		}else {
			return "Error";
		}
	}
	@RequestMapping(value = "detailFood.htm")
	public ModelAndView detailFood(String foodId) {
		ModelAndView mAndView = new ModelAndView("food/detail");
		Food food = FoodService.findFoodById(foodId);
		List<FoodDetail> listFoods = FoodService.listFoodDetail(food);
		mAndView.addObject("listFoodDetail", listFoods);
		mAndView.addObject("foodDetail", food);
		return mAndView;
	}
	@RequestMapping(value = "/initAddFoodDetail.htm")
	public ModelAndView addFoodDetail(String foodId) {
		ModelAndView mAndView = new ModelAndView("food_detail/NewFoodDetail");
		Food food = FoodService.findFoodById(foodId);
		FoodDetail FoodDetail = new FoodDetail();
		FoodDetail.setFood(food) ;
		List<Size> listSizes = sizeService.getAllSizes();
		mAndView.addObject("food", food);
		mAndView.addObject("listSizes", listSizes);
		mAndView.addObject("FoodDetailNew", FoodDetail);
		return mAndView;
	}
	
	@RequestMapping(value = "addFoodDetail.htm")
	public String addNewFoodDetail(FoodDetail FoodDetailNew) {
		boolean check = FoodDetailService.addFoodDetail(FoodDetailNew);
		if (check == true) {
			return "redirect:detailFood.htm?foodId="+FoodDetailNew.getFood().getFoodId();
		} else {
			return "Error";
		}
	}
	@RequestMapping(value = "deleteFoodDetail.htm")
	public String deleteFoodDetail(int fdId) {
		FoodDetail fd = FoodDetailService.findFoodDetailById(fdId);
		boolean check = FoodDetailService.deleteFoodDetail(fdId);
		if (check) {
			return "redirect:detailFood.htm?foodId="+fd.getFood().getFoodId();
		}else {
			return "Error";
		}
	}
	@RequestMapping(value = "/initUpdateFoodDetail.htm")
	public ModelAndView updateFoodDetail(int fdId) {
		ModelAndView mAndView = new ModelAndView("food_detail/UpdateFoodDetail");
		FoodDetail FoodDetail = FoodDetailService.findFoodDetailById(fdId);
		mAndView.addObject("FoodDetailUp", FoodDetail);
//		List<Food> listFoods = FoodService.getAllFoods();
		List<Size> listSizes = sizeService.getAllSizes();
		mAndView.addObject("listSizes", listSizes);
//		mAndView.addObject("listFoods", listFoods);
		return mAndView;
	}
	
	@RequestMapping(value = "/updateFoodDetail.htm")
	public String updateFoodDetail(FoodDetail FoodDetailUp) {
		boolean check = FoodDetailService.updateFoodDetail(FoodDetailUp);
		if (check == true) {
			return "redirect:detailFood.htm?foodId="+FoodDetailUp.getFood().getFoodId();
		} else {
			return "Error";
		}
	}
}

