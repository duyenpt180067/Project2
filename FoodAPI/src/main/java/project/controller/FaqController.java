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
import project.model.dao.IFaq;
import project.model.entity.Faq;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/faq")
public class FaqController {
	@Autowired
	private IFaq faqDao; 
	
	@GetMapping(value = "/findAllFaq")
	public List<Faq> getAllFaq(){
		return faqDao.findAll();
	}
	
	@GetMapping(value = "/findFaqById/{id}")
	public ResponseEntity<Faq> findFaqById(@PathVariable(value = "id") Integer faqId)
		throws ResourceNotFoundException{
		Faq faq = faqDao.findById(faqId)
				.orElseThrow(()->new ResourceNotFoundException("Not found with id = "+faqId));
		return ResponseEntity.ok().body(faq);
	}
}
