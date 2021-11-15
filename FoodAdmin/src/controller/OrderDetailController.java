package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.OrderDetail;
import entity.Orders;
import entity.FoodDetail;
import service.OrderDetailService;
import service.OrdersService;
import service.FoodDetailService;

@Controller
@RequestMapping(value = "/AdminController")
public class OrderDetailController {
	
	@Autowired
	private OrderDetailService OrderDetailService;
	@Autowired
	private FoodDetailService FoodDetailService;
	@Autowired 
	private OrdersService OrdersService;
	
	@RequestMapping(value = "/initAddOrderDetail.htm")
	public ModelAndView addOrderDetail() {
		ModelAndView mAndView = new ModelAndView("NewOrderDetail");
		OrderDetail OrderDetail = new OrderDetail();
		List<FoodDetail> listFoodDetails = FoodDetailService.getAllFoodDetails();
		List<Orders> listOrderss = OrdersService.getAllOrderss();
		mAndView.addObject("listOrderss", listOrderss);
		mAndView.addObject("listFoodDetails", listFoodDetails);
		mAndView.addObject("OrderDetailNew", OrderDetail);
		return mAndView;
	}
	
	@RequestMapping(value = "addOrderDetail.htm")
	public String addNewOrderDetail(OrderDetail OrderDetailNew) {
		boolean check = OrderDetailService.addOrderDetail(OrderDetailNew);
		if (check == true) {
			return "redirect:getAll.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "/initUpdateOrderDetail.htm")
	public ModelAndView updateOrderDetail(int odId) {
		ModelAndView mAndView = new ModelAndView("UpdateOrderDetail");
		OrderDetail OrderDetail = OrderDetailService.findOrderDetailById(odId);
		mAndView.addObject("OrderDetailUp", OrderDetail);
		return mAndView;
	}
	
	@RequestMapping(value = "/updateOrderDetail.htm")
	public String updateOrderDetail(OrderDetail OrderDetailUp) {
		boolean check = OrderDetailService.updateOrderDetail(OrderDetailUp);
		if (check == true) {
			return "redirect:getAll.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "deleteOrderDetail.htm")
	public String deleteOrderDetail(int odId) {
		boolean check = OrderDetailService.deleteOrderDetail(odId);
		if (check) {
			return "redirect:getAll.htm";
		}else {
			return "Error";
		}
	}
}

