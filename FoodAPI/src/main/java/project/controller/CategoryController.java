package project.controller;

//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.exception.ResourceNotFoundException;
import project.model.dao.ICategories;
import project.model.entity.Categories;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/categories")
public class CategoryController {
	@Autowired
	private ICategories catalogDao; 
	
	@GetMapping(value = "/findAllCategories")
	public List<Categories> getAllCategories(){
		return catalogDao.findAll();
	}

	@GetMapping(value = "/findAllByName/{caName}")
	public List<Categories> getAllCategoriesByName(@PathVariable(value = "caName") String CaName) {
		return catalogDao.findByCaName(CaName);
	}
	@GetMapping(value = "/findCatalogById/{id}")
	public ResponseEntity<Categories> findCatalogById(@PathVariable(value = "id") Integer caId)
		throws ResourceNotFoundException{
		Categories catalog = catalogDao.findById(caId)
				.orElseThrow(()->new ResourceNotFoundException("Not found with id = "+caId));
		return ResponseEntity.ok().body(catalog);
	}
//	@PostMapping(value = "/save")
//	public Categories createNewCategory(@RequestBody Categories cate) {
//		return catalogDao.save(cate);
//	}
//	
//	@PutMapping(value = "/update/{id}")
//	public ResponseEntity<Categories> updateCatalog(@PathVariable(value = "id") Integer caId, @RequestBody Categories catalog)
//		throws ResourceNotFoundException{
//		Categories cateUp = catalogDao.findById(caId)
//				.orElseThrow(()->new ResourceNotFoundException("Not found with id = "+caId)); 
//		cateUp.setCaName(catalog.getCaName());
//		cateUp.setCaStatus(catalog.isCaStatus());
//		cateUp.setDescriptions(catalog.getDescriptions());
//		cateUp.setListFood(catalog.getListFood());
//		cateUp.setPriorities(catalog.getPriorities());
//		return ResponseEntity.ok().body(catalogDao.save(cateUp));
//	}
//	
//	@DeleteMapping(value = "/delete/{id}")
//	public Map<String, Boolean> deleteCategories(@PathVariable(value = "id") Integer caId) 
//		throws ResourceNotFoundException{
//		Categories catalogDelete = catalogDao.findById(caId)
//				.orElseThrow(()-> new ResourceNotFoundException("Not found Categories with Id="+caId));
//		catalogDao.delete(catalogDelete);
//		Map<String, Boolean> result = new HashMap<String, Boolean>();
//		result.put("deleted success", Boolean.TRUE);
//		return result;
//	}

}
