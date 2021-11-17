package project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.exception.ResourceNotFoundException;
import project.model.dao.IOrderDetail;
import project.model.entity.OrderDetail;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/orderDetail")
public class OrderDetailController {

	@Autowired
	private IOrderDetail orderDetailDao; 
	
	@GetMapping(value = "/findAllOrderDetail")
	public List<OrderDetail> getAllOrderDetail(){
		return orderDetailDao.findAll();
	}
	
	@GetMapping(value = "/findOrderDetailById/{id}")
	public ResponseEntity<OrderDetail> findOrderDetailById(@PathVariable(value = "id") int odId)
		throws ResourceNotFoundException{
		OrderDetail orderDetail = orderDetailDao.findById(odId)
				.orElseThrow(()->new ResourceNotFoundException("Not found with id = "+odId));
		return ResponseEntity.ok().body(orderDetail);
	}
	@PostMapping(value = "/save")
	public OrderDetail postWebUser(@RequestBody OrderDetail od){
		return orderDetailDao.save(od);
	}
	@GetMapping(value = "/findAllOrderDetailByOrderId/{id}")
	public List<OrderDetail> findOrderDetailByOrderId(@PathVariable(value = "id") String orderId){
		List<OrderDetail> listOrderDetail = orderDetailDao.findAll();
		List<OrderDetail> listFind = new ArrayList<OrderDetail>();
		for(int i=0; i<listOrderDetail.size(); i++) {
			if(listOrderDetail.get(i).getOrder().getOrderId().equals(orderId)) {
				listFind.add(listOrderDetail.get(i));
			}
		}
		return listFind;
	}
}
