package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.OrderDetail;
import modelDao.OrderDetailModel;

@Service
public class OrderDetailService {
	@Autowired
	private OrderDetailModel OrderDetailModel;

	public List<OrderDetail> getAllOrderDetails() {
		// TODO Auto-generated method stub
		return OrderDetailModel.getAllOrderDetails();
	}

	public boolean addOrderDetail(OrderDetail OrderDetail) {
		// TODO Auto-generated method stub
		return OrderDetailModel.addOrderDetail(OrderDetail);
	}

	public boolean updateOrderDetail(OrderDetail OrderDetail) {
		// TODO Auto-generated method stub
		return OrderDetailModel.updateOrderDetail(OrderDetail);
	}

	public boolean deleteOrderDetail(int OrderDetailId) {
		// TODO Auto-generated method stub
		return OrderDetailModel.deleteOrderDetail(OrderDetailId);
	}

	public OrderDetail findOrderDetailById(int OrderDetailId) {
		// TODO Auto-generated method stub
		return OrderDetailModel.findOrderDetailById(OrderDetailId);
	}
	public List<OrderDetail> listOD(String OrderId){
		return OrderDetailModel.listOD(OrderId);
	}
}

