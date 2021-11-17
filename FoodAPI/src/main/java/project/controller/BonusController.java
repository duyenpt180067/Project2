package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.exception.ResourceNotFoundException;
import project.model.dao.IBonus;
import project.model.entity.Bonus;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/bonus")
public class BonusController {
	@Autowired
	private IBonus bonusDao; 
	
	@GetMapping(value = "/findAllBonus")
	public List<Bonus> getAllBonus(){
		return bonusDao.findAll();
	}
	
	@GetMapping(value = "/findBonusById/{id}")
	public ResponseEntity<Bonus> findBonusById(@PathVariable(value = "id") Integer bonusId)
		throws ResourceNotFoundException{
		Bonus bonus = bonusDao.findById(bonusId)
				.orElseThrow(()->new ResourceNotFoundException("Not found with id = "+bonusId));
		return ResponseEntity.ok().body(bonus);
	}
}
