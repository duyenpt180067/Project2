package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Bonus;
import entity.FoodDetail;
import service.BonusService;
import service.FoodDetailService;

@Controller
@RequestMapping(value = "/AdminController/bonus")
public class BonusController {
	
	@Autowired
	private BonusService BonusService;
	
	@Autowired
	private FoodDetailService fdService;
	
	@RequestMapping(value = "list.htm")
	public ModelAndView getAll() {
		ModelAndView mAndView = new ModelAndView("bonus/index");
		List<Bonus> listBonuss = BonusService.getAllBonuss();
		mAndView.addObject("listBonuss", listBonuss);
		return mAndView;
	}

	@RequestMapping(value = "/initAddBonus.htm")
	public ModelAndView addBonus() {
		ModelAndView mAndView = new ModelAndView("bonus/NewBonus");
		Bonus Bonus = new Bonus();
		List<FoodDetail> listFoodDetail = fdService.getAllFoodDetails();
		mAndView.addObject("listFoodDetail", listFoodDetail);
		mAndView.addObject("BonusNew", Bonus);
		return mAndView;
	}
	
	@RequestMapping(value = "addBonus.htm")
	public String addNewBonus(Bonus BonusNew) {
		boolean check = BonusService.addBonus(BonusNew);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "/initUpdateBonus.htm")
	public ModelAndView updateBonus(int bonusId) {
		ModelAndView mAndView = new ModelAndView("bonus/UpdateBonus");
		Bonus Bonus = BonusService.findBonusById(bonusId);
		mAndView.addObject("BonusUp", Bonus);
		List<FoodDetail> listFoodDetail = fdService.getAllFoodDetails();
		mAndView.addObject("listFoodDetail", listFoodDetail);
		return mAndView;
	}
	
	@RequestMapping(value = "/updateBonus.htm")
	public String updateBonus(Bonus BonusUp) {
		boolean check = BonusService.updateBonus(BonusUp);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "deleteBonus.htm")
	public String deleteBonus(int bonusId) {
		boolean check = BonusService.deleteBonus(bonusId);
		if (check) {
			return "redirect:list.htm";
		}else {
			return "Error";
		}
	}
}

