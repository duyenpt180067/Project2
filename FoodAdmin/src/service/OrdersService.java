package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.OrderDetail;
import entity.Orders;
import modelDao.OrdersModel;

@Service
public class OrdersService {
	@Autowired
	private OrdersModel OrdersModel;

	public List<Orders> getAllOrderss() {
		// TODO Auto-generated method stub
		return OrdersModel.getAllOrderss();
	}

	public boolean addOrders(Orders Orders) {
		// TODO Auto-generated method stub
		return OrdersModel.addOrders(Orders);
	}

	public boolean updateOrders(Orders Orders) {
		// TODO Auto-generated method stub
		return OrdersModel.updateOrders(Orders);
	}

	public boolean deleteOrders(String OrdersId) {
		// TODO Auto-generated method stub
		return OrdersModel.deleteOrders(OrdersId);
	}

	public Orders findOrdersById(String OrdersId) {
		// TODO Auto-generated method stub
		return OrdersModel.findOrdersById(OrdersId);
	}
	public List<Orders> listOrderChoXuLy(){
		return OrdersModel.listOrderChoXuLy();
	}
	public List<OrderDetail> listOrderDetail(Orders order){
		return OrdersModel.listOrderDetail(order);
	}
}
