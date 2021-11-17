package project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.exception.ResourceNotFoundException;
import project.model.dao.IWebUser;
import project.model.entity.WebUser;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/webUser")
public class WebUserController {
	@Autowired
	private IWebUser webUserDao; 
	
	@GetMapping(value = "/findAllWebUser")
	public List<WebUser> getAllWebUser(){
		return webUserDao.findAll();
	}
	
	@GetMapping(value = "/findWebUserById/{id}")
	public ResponseEntity<WebUser> findWebUserById(@PathVariable(value = "id") int userId)
		throws ResourceNotFoundException{
		WebUser webUser = webUserDao.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("Not found with id = "+userId));
		return ResponseEntity.ok().body(webUser);
	}
	
	@GetMapping(value = "/findWebUserByName/{nameUser}")
	public WebUser findWebUserByUserName(@PathVariable(value = "nameUser") String name){
		List<WebUser> listUser = webUserDao.findAll();
		WebUser listNeedFind;
		for(int i=0; i< listUser.size(); i++) {
			if(listUser.get(i).getUserName().equals(name)) {
				listNeedFind=listUser.get(i);
				return listNeedFind;
			}
		}
		return null;
	}
	
	@PostMapping(value = "/postWebUser")
	public WebUser postWebUser(@RequestBody WebUser user){
		return webUserDao.save(user);
	}
	@DeleteMapping(value ="/deleteWebUser")
	public void deteteWebUser(@RequestBody WebUser user){
		webUserDao.delete(user);
	}
	@PutMapping(value = "/updateWebUser/{id}")
	public ResponseEntity<WebUser> updateWebUser(@PathVariable(value = "id") Integer userId, @RequestBody WebUser webUser) throws ResourceNotFoundException{
		WebUser webUserUpdate = webUserDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Not found Categories with Id="+userId));
		webUserUpdate.setUserName(webUser.getUserName());
		webUserUpdate.setAddresses(webUser.getAddresses());
		webUserUpdate.setPhone(webUser.getPhone());
		final WebUser updatedWebUser = webUserDao.save(webUserUpdate);
		return ResponseEntity.ok().body(updatedWebUser);		
	}
}
