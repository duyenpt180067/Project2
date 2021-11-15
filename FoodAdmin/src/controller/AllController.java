package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.OrderDetail;
import entity.Orders;
import entity.WebUser;
import service.OrderDetailService;
import service.OrdersService;
import service.WebUserService;
//
//
@Controller
@RequestMapping(value = "/AdminController")
public class AllController {
	
	@Autowired
	private OrderDetailService odService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private WebUserService webUserService;
	
	@RequestMapping(value = "home")
	public ModelAndView getAll() {
		ModelAndView mAndView = new ModelAndView("GetAll");
		List<OrderDetail> listOrderDetails = odService.getAllOrderDetails();
		mAndView.addObject("listOrderDetails", listOrderDetails);
		List<Orders> listOrderss = ordersService.listOrderChoXuLy();
		mAndView.addObject("listOrderss", listOrderss);
		
		return mAndView;
	}
	@RequestMapping(value = "login")
	public ModelAndView login() {
		ModelAndView mAndView = new ModelAndView("Login");
		List<WebUser> listUser = webUserService.getAllAdmin();
		mAndView.addObject("listUser", listUser);
		
		return mAndView;
	}
}
