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
import project.model.dao.IFavorite;
import project.model.entity.Favorite;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/favorite")
public class FavoriteController {
	@Autowired
	private IFavorite favoriteDao; 
	
	@GetMapping(value = "/findAllFavorite")
	public List<Favorite> getAllFavorite(){
		return favoriteDao.findAll();
	}
	
	@GetMapping(value = "/findFavoriteById/{id}")
	public ResponseEntity<Favorite> findFavoriteById(@PathVariable(value = "id") Integer favoriteId)
		throws ResourceNotFoundException{
		Favorite favorite = favoriteDao.findById(favoriteId)
				.orElseThrow(()->new ResourceNotFoundException("Not found with id = "+favoriteId));
		return ResponseEntity.ok().body(favorite);
	}
}
