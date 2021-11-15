package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.FoodDetail;
import entity.OrderDetail;
import entity.Orders;
import entity.WebUser;
import service.FoodDetailService;
import service.OrderDetailService;
import service.OrdersService;
import service.WebUserService;

@Controller
@RequestMapping(value = "/AdminController/orders")
public class OrdersController {
	
	@Autowired
	private OrdersService OrdersService;
	@Autowired
	private WebUserService WebUserService;
	@Autowired
	private OrderDetailService OrderDetailService;
	@Autowired
	private FoodDetailService FoodDetailService;
	
	@RequestMapping(value = "list.htm")
	public ModelAndView getAll() {
		ModelAndView mAndView = new ModelAndView("orders/index");
		List<Orders> listOrderss = OrdersService.getAllOrderss();
		mAndView.addObject("listOrderss", listOrderss);
		List<WebUser> listWebUsers = WebUserService.getAllWebUsers();
		mAndView.addObject("listWebUsers", listWebUsers);
		return mAndView;
	}

	@RequestMapping(value = "/initAddOrders.htm")
	public ModelAndView addOrders() {
		ModelAndView mAndView = new ModelAndView("orders/NewOrders");
		Orders Orders = new Orders();
		List<WebUser> listWebUsers = WebUserService.getAllWebUsers();
		mAndView.addObject("listWebUsers", listWebUsers);
		mAndView.addObject("OrdersNew", Orders);
		return mAndView;
	}
	
	@RequestMapping(value = "addOrders.htm")
	public String addNewOrders(Orders OrdersNew) {
		boolean check = OrdersService.addOrders(OrdersNew);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "/initUpdateOrders.htm")
	public ModelAndView updateOrders(String orderId) {
		ModelAndView mAndView = new ModelAndView("orders/UpdateOrders");
		Orders Orders = OrdersService.findOrdersById(orderId);
		List<WebUser> listWebUsers = WebUserService.getAllWebUsers();
		mAndView.addObject("listWebUsers", listWebUsers);
		mAndView.addObject("OrdersUp", Orders);
		return mAndView;
	}
	
	@RequestMapping(value = "/updateOrders.htm")
	public String updateOrders(Orders OrdersUp) {
		boolean check = OrdersService.updateOrders(OrdersUp);
		if (check == true) {
			return "redirect:list.htm";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "detailOrder.htm")
	public ModelAndView detailFood(String orderId) {
		ModelAndView mAndView = new ModelAndView("orders/detail");
		Orders order = OrdersService.findOrdersById(orderId);
		List<OrderDetail> listFoods = OrdersService.listOrderDetail(order);
		mAndView.addObject("listOrderDetail", listFoods);
		mAndView.addObject("orderDetail", order);
		return mAndView;
	}
	
	@RequestMapping(value = "deleteOrders.htm")
	public String deleteOrders(String orderId) {
		boolean check = OrdersService.deleteOrders(orderId);
		if (check) {
			return "redirect:list.htm";
		}else {
			return "Error";
		}
	}
	@RequestMapping(value = "/initAddOrderDetail.htm")
	public ModelAndView addOrderDetail(String orderId) {
		ModelAndView mAndView = new ModelAndView("orders/NewOrderDetail");
		Orders order = OrdersService.findOrdersById(orderId);
		OrderDetail OrderDetail = new OrderDetail();
		List<FoodDetail> listFoodDetail = FoodDetailService.getAllFoodDetails();
		OrderDetail.setOrder(order);
		mAndView.addObject("listFoodDetail", listFoodDetail);
		mAndView.addObject("order", order);
		mAndView.addObject("OrderDetailNew", OrderDetail);
		return mAndView;
	}
	
	@RequestMapping(value = "addOrderDetail.htm")
	public String addNewOrderDetail(OrderDetail OrderDetailNew) {
		boolean check = OrderDetailService.addOrderDetail(OrderDetailNew);
		if (check == true) {
			return "redirect:detailOrder.htm?orderId="+OrderDetailNew.getOrder().getOrderId();
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "/initUpdateOrderDetail.htm")
	public ModelAndView updateOrderDetail(int odId) {
		ModelAndView mAndView = new ModelAndView("orders/UpdateOrderDetail");
		List<FoodDetail> listFoodDetail = FoodDetailService.getAllFoodDetails();
		mAndView.addObject("listFoodDetail", listFoodDetail);
		OrderDetail OrderDetail = OrderDetailService.findOrderDetailById(odId);
		mAndView.addObject("OrderDetailUp", OrderDetail);
		return mAndView;
	}
	
	@RequestMapping(value = "/updateOrderDetail.htm")
	public String updateOrderDetail(OrderDetail OrderDetailUp) {
		boolean check = OrderDetailService.updateOrderDetail(OrderDetailUp);
		if (check == true) {
			return "redirect:detailOrder.htm?orderId="+OrderDetailUp.getOrder().getOrderId();
		} else {
			return "Error";
		}
	}
	
	@RequestMapping(value = "deleteOrderDetail.htm")
	public String deleteOrderDetail(int odId) {
		OrderDetail od = OrderDetailService.findOrderDetailById(odId);
		boolean check = OrderDetailService.deleteOrderDetail(odId);
		if (check) {
			return "redirect:detailOrder.htm?orderId="+od.getOrder().getOrderId();
		}else {
			return "Error";
		}
	}
}

