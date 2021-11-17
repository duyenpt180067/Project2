package project.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.exception.ResourceNotFoundException;
import project.model.dao.IFood;
import project.model.entity.Food;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/food")
public class FoodController {

	@Autowired
	private IFood foodDao; 
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@GetMapping(value = "/findAllFood")
	public List<Food> getAllFood(){
		return foodDao.findAll();
	}
	
	@GetMapping(value = "/findFoodById/{id}")
	public ResponseEntity<Food> findFoodById(@PathVariable(value = "id") String foodId)
		throws ResourceNotFoundException{
		Food food = foodDao.findById(foodId)
				.orElseThrow(()->new ResourceNotFoundException("Not found with id = "+foodId));
		return ResponseEntity.ok().body(food);
	}
	
}
