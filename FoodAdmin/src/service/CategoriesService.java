package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Categories;
import modelDao.CategoriesModel;

@Service
public class CategoriesService {
	@Autowired
	private CategoriesModel CategoriesModel;

	public List<Categories> getAllCategoriess() {
		// TODO Auto-generated method stub
		return CategoriesModel.getAllCategoriess();
	}

	public boolean addCategories(Categories Categories) {
		// TODO Auto-generated method stub
		return CategoriesModel.addCategories(Categories);
	}

	public boolean updateCategories(Categories Categories) {
		// TODO Auto-generated method stub
		return CategoriesModel.updateCategories(Categories);
	}

	public boolean deleteCategories(int CategoriesId) {
		// TODO Auto-generated method stub
		return CategoriesModel.deleteCategories(CategoriesId);
	}

	public Categories findCategoriesById(int CategoriesId) {
		// TODO Auto-generated method stub
		return CategoriesModel.findCategoriesById(CategoriesId);
	}
}

