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
import project.model.dao.IImageFood;
import project.model.entity.ImageFood;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/imageFood")
public class ImageFoodController {
	@Autowired
	private IImageFood imageFoodDao; 
	
	@GetMapping(value = "/findAllImageFood")
	public List<ImageFood> getAllImageFood(){
		return imageFoodDao.findAll();
	}
	
	@GetMapping(value = "/findImageFoodById/{id}")
	public ResponseEntity<ImageFood> findImageFoodById(@PathVariable(value = "id") Integer imageId)
		throws ResourceNotFoundException{
		ImageFood imageFood = imageFoodDao.findById(imageId)
				.orElseThrow(()->new ResourceNotFoundException("Not found with id = "+imageId));
		return ResponseEntity.ok().body(imageFood);
	}
}
