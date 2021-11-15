package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.UserGroup;
import entity.WebUser;
import service.WebUserService;

@Controller
@RequestMapping(value = "/AdminController/web_user")
public class WebUserController {
	
	@Autowired
	private WebUserService WebUserService;
	
	
	@RequestMapping(value = "list.htm")
	public ModelAndView getAll() {
		ModelAndView mAndView = new ModelAndView("web_user/index");
		List<WebUser> listWebUsers = WebUserService.getAllWebUsers();
		mAndView.addObject("listWebUsers", listWebUsers);
		return mAndView;
	}

	@RequestMapping(value = "/initAddWebUser.htm")
	public ModelAndView addWebUser() {
		ModelAndView mAndView = new ModelAndView("web_user/NewWebUser");
		List<String> listStatus = WebUserService.listStatus();
		mAndView.addObject("listStatus", listStatus);
		List<WebUser> listWebUser = WebUserService.getAllWebUsers();
		mAndView.addObject("listWebUser", listWebUser);
		WebUser WebUser = new WebUser();
		UserGroup usergroup = new UserGroup();
		mAndView.addObject("UserGroup", usergroup);
		mAndView.addObject("WebUserNew", WebUser);
		return mAndView;
	}
	
	@RequestMapping(value = "addWebUser.htm")
	public String addNewWebUser(WebUser WebUserNew) {
		boolean check = WebUserService.addWebUser(WebUserNew);
		UserGroup usergroup = new UserGroup();
		usergroup.setWebUser(WebUserNew);
		if(WebUserNew.isIsadmin() == true) {
			usergroup.setWebGroup(WebUserService.findWebGroupById(1));
		}else {
			usergroup.setWebGroup(WebUserService.findWebGroupById(2));
		}
		boolean check2 = WebUserService.addUserGroup(usergroup);
		if ((check == true)&&(check2==true)) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "/initUpdateWebUser.htm")
	public ModelAndView updateWebUser(int userId) {
		ModelAndView mAndView = new ModelAndView("web_user/UpdateWebUser");
		List<String> listStatus = WebUserService.listStatus();
		mAndView.addObject("listStatus", listStatus);
		WebUser WebUser = WebUserService.findWebUserById(userId);
		mAndView.addObject("WebUserUp", WebUser);
		return mAndView;
	}
	
	@RequestMapping(value = "/updateWebUser.htm")
	public String updateWebUser(WebUser WebUserUp) {
		boolean check = WebUserService.updateWebUser(WebUserUp);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "deleteWebUser.htm")
	public String deleteWebUser(int userId) {
		boolean check = WebUserService.deleteWebUser(userId);
		if (check) {
			return "redirect:list.htm";
		}else {
			return "Error";
		}
	}
}


