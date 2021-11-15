package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Favorite;
import entity.Food;
import entity.WebUser;
import service.FavoriteService;
import service.FoodService;
import service.WebUserService;

@Controller
@RequestMapping(value = "/AdminController/favorite")
public class FavoriteController {
	
	@Autowired
	private FavoriteService FavoriteService;
	@Autowired
	private WebUserService WebUserService;
	@Autowired
	private FoodService foodService;
	
	@RequestMapping(value = "list.htm")
	public ModelAndView getAll() {
		ModelAndView mAndView = new ModelAndView("favorite/index");
		List<Favorite> listFavorites = FavoriteService.getAllFavorites();
		mAndView.addObject("listFavorites", listFavorites);
		List<WebUser> listWebUsers = WebUserService.getAllWebUsers();
		mAndView.addObject("listWebUsers", listWebUsers);
		List<Food> listFoods = foodService.getAllFoods();
		mAndView.addObject("listFoods", listFoods);
		return mAndView;
	}

	@RequestMapping(value = "/initAddFavorite.htm")
	public ModelAndView addFavorite() {
		ModelAndView mAndView = new ModelAndView("favorite/NewFavorite");
		Favorite Favorite = new Favorite();
		List<WebUser> listWebUsers = WebUserService.getAllWebUsers();
		List<Food> listFoods = foodService.getAllFoods();
		mAndView.addObject("listFoods", listFoods);
		mAndView.addObject("listWebUsers", listWebUsers);
		mAndView.addObject("FavoriteNew", Favorite);
		return mAndView;
	}
	
	@RequestMapping(value = "addFavorite.htm")
	public String addNewFavorite(Favorite FavoriteNew) {
		boolean check = FavoriteService.addFavorite(FavoriteNew);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "/initUpdateFavorite.htm")
	public ModelAndView updateFavorite(int favoriteId) {
		ModelAndView mAndView = new ModelAndView("favorite/UpdateFavorite");
		List<WebUser> listWebUsers = WebUserService.getAllWebUsers();
		List<Food> listFoods = foodService.getAllFoods();
		mAndView.addObject("listFoods", listFoods);
		mAndView.addObject("listWebUsers", listWebUsers);
		Favorite Favorite = FavoriteService.findFavoriteById(favoriteId);
		mAndView.addObject("FavoriteUp", Favorite);
		return mAndView;
	}
	
	@RequestMapping(value = "/updateFavorite.htm")
	public String updateFavorite(Favorite FavoriteUp) {
		boolean check = FavoriteService.updateFavorite(FavoriteUp);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "deleteFavorite.htm")
	public String deleteFavorite(int favoriteId) {
		boolean check = FavoriteService.deleteFavorite(favoriteId);
		if (check) {
			return "redirect:list.htm";
		}else {
			return "Error";
		}
	}
}
