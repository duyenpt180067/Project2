package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Food;
import entity.FoodDetail;
import modelDao.FoodModel;

@Service
public class FoodService {
	@Autowired
	private FoodModel FoodModel;

	public List<Food> getAllFoods() {
		// TODO Auto-generated method stub
		return FoodModel.getAllFoods();
	}

	public boolean addFood(Food Food) {
		// TODO Auto-generated method stub
		return FoodModel.addFood(Food);
	}

	public boolean updateFood(Food Food) {
		// TODO Auto-generated method stub
		return FoodModel.updateFood(Food);
	}

	public boolean deleteFood(String FoodId) {
		// TODO Auto-generated method stub
		return FoodModel.deleteFood(FoodId);
	}

	public Food findFoodById(String FoodId) {
		// TODO Auto-generated method stub
		return FoodModel.findFoodById(FoodId);
	}
	public List<FoodDetail> listFoodDetail(Food foodId){
		return FoodModel.listFoodDetail(foodId);
	}
}

