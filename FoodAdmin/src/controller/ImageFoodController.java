package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.ImageFood;
import entity.Food;
import service.ImageFoodService;
import service.FoodService;

@Controller
@RequestMapping(value = "/AdminController/image_food")
public class ImageFoodController {
	
	@Autowired
	private ImageFoodService ImageFoodService;
	@Autowired
	private FoodService FoodService;
	
	@RequestMapping(value = "list.htm")
	public ModelAndView getAll() {
		ModelAndView mAndView = new ModelAndView("image_food/index");
		List<Food> listFoods = FoodService.getAllFoods();
		mAndView.addObject("listFoods", listFoods);
		List<ImageFood> listImageFoods = ImageFoodService.getAllImageFoods();
		mAndView.addObject("listImageFoods", listImageFoods);
		return mAndView;
	}

	@RequestMapping(value = "/initAddImageFood.htm")
	public ModelAndView addImageFood() {
		ModelAndView mAndView = new ModelAndView("image_food/NewImageFood");
		ImageFood ImageFood = new ImageFood();
		List<Food> listFoods = FoodService.getAllFoods();
		mAndView.addObject("listFoods", listFoods);
		mAndView.addObject("ImageFoodNew", ImageFood);
		return mAndView;
	}
	
	@RequestMapping(value = "addImageFood.htm")
	public String addNewImageFood(ImageFood ImageFoodNew) {
		boolean check = ImageFoodService.addImageFood(ImageFoodNew);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "/initUpdateImageFood.htm")
	public ModelAndView updateImageFood(int imageId) {
		ModelAndView mAndView = new ModelAndView("image_food/UpdateImageFood");
		ImageFood ImageFood = ImageFoodService.findImageFoodById(imageId);
		List<Food> listFoods = FoodService.getAllFoods();
		mAndView.addObject("listFoods", listFoods);
		mAndView.addObject("ImageFoodUp", ImageFood);
		return mAndView;
	}
	
	@RequestMapping(value = "/updateImageFood.htm")
	public String updateImageFood(ImageFood ImageFoodUp) {
		boolean check = ImageFoodService.updateImageFood(ImageFoodUp);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "deleteImageFood.htm")
	public String deleteImageFood(int imageId) {
		boolean check = ImageFoodService.deleteImageFood(imageId);
		if (check) {
			return "redirect:list.htm";
		}else {
			return "Error";
		}
	}
}

