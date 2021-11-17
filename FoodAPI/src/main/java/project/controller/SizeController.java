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
import project.model.dao.ISize;
import project.model.entity.Size;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/size")
public class SizeController {
	@Autowired
	private ISize sizeDao; 
	
	@GetMapping(value = "/findAllSize")
	public List<Size> getAllsize(){
		return sizeDao.findAll();
	}
	
	@GetMapping(value = "/findSizeById/{id}")
	public ResponseEntity<Size> findsizeById(@PathVariable(value = "id") Integer sizeId)
		throws ResourceNotFoundException{
		Size size = sizeDao.findById(sizeId)
				.orElseThrow(()->new ResourceNotFoundException("Not found with id = "+sizeId));
		return ResponseEntity.ok().body(size);
	}
}
