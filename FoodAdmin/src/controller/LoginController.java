package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import entity.OrderDetail;
import entity.Orders;
import service.OrderDetailService;
import service.OrdersService;

@Controller
public class LoginController {
	@RequestMapping(value = { "/login", "/" })
	public String login(@RequestParam(value = "error", required = false) final String error, final Model model) {
		if (error != null) {
			model.addAttribute("message", "Login Failed!");
		}
		return "login";
		
	}

//	  @RequestMapping("/admin")
//	  public String admin() {
//	    return "admin";
//	  }
//	@Autowired
//	private OrderDetailService odService;
//	@Autowired
//	private OrdersService ordersService;
//
//	@RequestMapping(value = "/AdminController/home")
//	public ModelAndView getAll() {
//		ModelAndView mAndView = new ModelAndView("GetAll");
//		List<OrderDetail> listOrderDetails = odService.getAllOrderDetails();
//		mAndView.addObject("listOrderDetails", listOrderDetails);
//		List<Orders> listOrderss = ordersService.listOrderChoXuLy();
//		mAndView.addObject("listOrderss", listOrderss);
//
//		return mAndView;
//	}

	@RequestMapping("/user")
	public String user() {
		return "user";
	}

	@RequestMapping("/logout")
	public String logout(final Model model) {
		model.addAttribute("message", "Logged out!");
		return "login";
	}

}
