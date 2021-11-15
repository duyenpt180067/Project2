package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.FoodDetail;
import modelDao.FoodDetailModel;

@Service
public class FoodDetailService {
	@Autowired
	private FoodDetailModel FoodDetailModel;

	public List<FoodDetail> getAllFoodDetails() {
		// TODO Auto-generated method stub
		return FoodDetailModel.getAllFoodDetails();
	}

	public boolean addFoodDetail(FoodDetail FoodDetail) {
		// TODO Auto-generated method stub
		return FoodDetailModel.addFoodDetail(FoodDetail);
	}

	public boolean updateFoodDetail(FoodDetail FoodDetail) {
		// TODO Auto-generated method stub
		return FoodDetailModel.updateFoodDetail(FoodDetail);
	}

	public boolean deleteFoodDetail(int FoodDetailId) {
		// TODO Auto-generated method stub
		return FoodDetailModel.deleteFoodDetail(FoodDetailId);
	}

	public FoodDetail findFoodDetailById(int FoodDetailId) {
		// TODO Auto-generated method stub
		return FoodDetailModel.findFoodDetailById(FoodDetailId);
	}
}

