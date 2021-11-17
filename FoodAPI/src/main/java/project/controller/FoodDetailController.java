package project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.exception.ResourceNotFoundException;
import project.model.dao.IFoodDetail;
import project.model.entity.FoodDetail;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/foodDetail")
public class FoodDetailController {
	@Autowired
	private IFoodDetail foodDetailDao; 
	
	@GetMapping(value = "/findAllFoodDetail")
	public List<FoodDetail> getAllFoodDetail(){
		return foodDetailDao.findAll();
	}
	

	
	@GetMapping(value = "/findFoodDetailById/{id}")
	public ResponseEntity<FoodDetail> findFoodDetailById(@PathVariable(value = "id") Integer fdId)
		throws ResourceNotFoundException{
		FoodDetail foodDetail = foodDetailDao.findById(fdId)
				.orElseThrow(()->new ResourceNotFoundException("Not found with id = "+fdId));
		return ResponseEntity.ok().body(foodDetail);
	}
	public static boolean find(List<FoodDetail> listNeed, String a) {
		for (int j = 0; j < listNeed.size(); j++) {
			if (a == listNeed.get(j).getFood().getFoodId()) {
				return true;
			}
		}
		return false;
	}
	@GetMapping(value = "/findAllFood")
	public List<FoodDetail> getAllFoodDetailFoodId(){
		List<FoodDetail> listFood = foodDetailDao.findAll();
		List<FoodDetail> listNeed = new ArrayList<FoodDetail>();
		for (int i = 0; i < listFood.size(); i++) {
			if ((find(listNeed,listFood.get(i).getFood().getFoodId()) == false)) {
				listNeed.add(listFood.get(i));
			}
		}
		return listNeed;
	}
	
	@GetMapping(value = "/listPage")
	public List<Integer> getAllPage(){
		List<FoodDetail> listFood = foodDetailDao.findAll();
		List<FoodDetail> listNeed = new ArrayList<FoodDetail>();
		List<Integer> listPage = new ArrayList<Integer>();
		for (int i = 0; i < listFood.size(); i++) {
			if ((find(listNeed,listFood.get(i).getFood().getFoodId()) == false)) {
				listNeed.add(listFood.get(i));
			}
		}
		if(listNeed.size()%9 ==0) {
			for(int i=1; i<= listNeed.size()/9; i++) {
				listPage.add(i);
			}
		}
		else if(listNeed.size()%9 !=0) {
			for(int i=1; i<= listNeed.size()/9+1; i++) {
				listPage.add(i);
			}
		}
		return listPage;
	}
	
	@GetMapping(value = "/findFoodPage/{page}")
	public List<FoodDetail> getFoodOnPage(@PathVariable(value = "page") Integer page){
		List<FoodDetail> listFood = foodDetailDao.findAll();
		List<FoodDetail> listNeed = new ArrayList<FoodDetail>();
		for (int i = 0; i < listFood.size(); i++) {
			if ((find(listNeed,listFood.get(i).getFood().getFoodId()) == false)) {
				listNeed.add(listFood.get(i));
			}
		}
		List<FoodDetail> listFoodOnPage = new ArrayList<FoodDetail>();
		if(listNeed.size()%9 ==0) {
			for(int i=(page-1)*9; i<=(page-1)*9+8;i++ ) {
				listFoodOnPage.add(listNeed.get(i));
			}
		}
		else if(listNeed.size()%9 !=0) {
			if(page < listNeed.size()/9+1) {
				for(int i=(page-1)*9; i<=(page-1)*9+8;i++ ) {
					listFoodOnPage.add(listNeed.get(i));
				}
			}
			if(page == listNeed.size()/9+1) {
				for(int i =(page-1)*9; i< listNeed.size(); i++) {
					listFoodOnPage.add(listNeed.get(i));
				}
			}
		}
		return listFoodOnPage;
	}
	
	@GetMapping(value = "/listPageOneCatalog/{id}")
	public List<Integer> getAllPageOneCatalog(@PathVariable(value = "id") Integer id){
		List<FoodDetail> listFood = foodDetailDao.findAll();
		List<FoodDetail> listNeed = new ArrayList<FoodDetail>();
		List<Integer> listPage = new ArrayList<Integer>();
		for (int i = 0; i < listFood.size(); i++) {
			if ((find(listNeed,listFood.get(i).getFood().getFoodId()) == false)&&(listFood.get(i).getFood().getCatalog().getCaId() == id)) {
				listNeed.add(listFood.get(i));
			}
		}
		if(listNeed.size()%9 ==0) {
			for(int i=1; i<= listNeed.size()/9; i++) {
				listPage.add(i);
			}
		}
		else if(listNeed.size()%9 !=0) {
			for(int i=1; i<= listNeed.size()/9+1; i++) {
				listPage.add(i);
			}
		}
		return listPage;
	}
	@GetMapping(value = "/findFoodPageOneCatalog/{id}/{page}")
	public List<FoodDetail> getFoodOnPageCatalog(@PathVariable(value = "id") Integer id,@PathVariable(value = "page") Integer page){
		List<FoodDetail> listFood = foodDetailDao.findAll();
		List<FoodDetail> listNeed = new ArrayList<FoodDetail>();
		for (int i = 0; i < listFood.size(); i++) {
			if ((find(listNeed,listFood.get(i).getFood().getFoodId()) == false)&&(listFood.get(i).getFood().getCatalog().getCaId() == id)) {
				listNeed.add(listFood.get(i));
			}
		}
		List<FoodDetail> listFoodOnPage = new ArrayList<FoodDetail>();
		if(listNeed.size()%9 ==0) {
			for(int i=(page-1)*9; i<=(page-1)*9+8;i++ ) {
				listFoodOnPage.add(listNeed.get(i));
			}
		}
		else if(listNeed.size()%9 !=0) {
			if(page < listNeed.size()/9+1) {
				for(int i=(page-1)*9; i<=(page-1)*9+8;i++ ) {
					listFoodOnPage.add(listNeed.get(i));
				}
			}
			if(page == listNeed.size()/9+1) {
				for(int i =(page-1)*9; i< listNeed.size(); i++) {
					listFoodOnPage.add(listNeed.get(i));
				}
			}
		}
		return listFoodOnPage;
	}
}
