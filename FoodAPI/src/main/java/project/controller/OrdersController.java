package project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.exception.ResourceNotFoundException;
import project.model.dao.IOrderDetail;
import project.model.dao.IOrders;
import project.model.entity.OrderDetail;
import project.model.entity.Orders;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/orders")
public class OrdersController {

	@Autowired
	private IOrders ordersDao; 
	@Autowired
	private IOrderDetail orderDetailDao;
	
	@GetMapping(value = "/findAllOrders")
	public List<Orders> getAllOrders(){
		return ordersDao.findAll();
	}
	
	@GetMapping(value = "/findOrdersById/{id}")
	public ResponseEntity<Orders> findOrdersById(@PathVariable(value = "id") String orderId)
		throws ResourceNotFoundException{
		Orders orders = ordersDao.findById(orderId)
				.orElseThrow(()->new ResourceNotFoundException("Not found with id = "+orderId));
		return ResponseEntity.ok().body(orders);
	}
	
//	@GetMapping(value = "/findAllOrdersByUserName/{id}")
//	public List<Orders> getAllOrdersByUserName(@PathVariable(value = "id") String userName){
//		List<Orders> listAll = ordersDao.findAll();
//		List<Orders> listByUserName
//	}
	
	@PostMapping(value = "/save")
	public Orders createNewOrder(@RequestBody Orders order) {
		return ordersDao.save(order);
	}
	@DeleteMapping(value = "/delete/{id}")
	public Map<String, Boolean> deleteCategories(@PathVariable(value = "id") String orderId) throws ResourceNotFoundException{
		Orders orderDelete = ordersDao.findById(orderId).orElseThrow(()-> new ResourceNotFoundException("Not found Categories with Id="+orderId));
		List<OrderDetail> listOrderDetail = orderDetailDao.findAll();
		List<OrderDetail> listFindByOrderId = new ArrayList<OrderDetail>();
		for(int i=0; i<listOrderDetail.size(); i++) {
			if(listOrderDetail.get(i).getOrder().getOrderId().equals(orderId)) {
				listFindByOrderId.add(listOrderDetail.get(i));
			}
		}
		for(int i=0; i< listFindByOrderId.size(); i++) {
			orderDetailDao.delete(listFindByOrderId.get(i));
		}
		ordersDao.delete(orderDelete);
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		result.put("deleted success", Boolean.TRUE);
		return result;
	}
}

