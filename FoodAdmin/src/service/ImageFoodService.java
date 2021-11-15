package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.ImageFood;
import modelDao.ImageFoodModel;

@Service
public class ImageFoodService {
	@Autowired
	private ImageFoodModel ImageFoodModel;

	public List<ImageFood> getAllImageFoods() {
		// TODO Auto-generated method stub
		return ImageFoodModel.getAllImageFoods();
	}

	public boolean addImageFood(ImageFood ImageFood) {
		// TODO Auto-generated method stub
		return ImageFoodModel.addImageFood(ImageFood);
	}

	public boolean updateImageFood(ImageFood ImageFood) {
		// TODO Auto-generated method stub
		return ImageFoodModel.updateImageFood(ImageFood);
	}

	public boolean deleteImageFood(int ImageFoodId) {
		// TODO Auto-generated method stub
		return ImageFoodModel.deleteImageFood(ImageFoodId);
	}

	public ImageFood findImageFoodById(int ImageFoodId) {
		// TODO Auto-generated method stub
		return ImageFoodModel.findImageFoodById(ImageFoodId);
	}
}

