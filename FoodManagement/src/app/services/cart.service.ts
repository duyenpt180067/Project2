import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  orderDetail: string = "http://localhost:8080/api/v1/orderDetail/findAllOrderDetail"

  constructor(private http : HttpClient) { }

  getAllOrder(){
    return this.http.get("http://localhost:8080/api/v1/orders/findAllOrders");
  }

  findOrderById(id){
    return this.http.get("http://localhost:8080/api/v1/orders/findOrdersById/"+id);
  }

  getOrderDetailByOrderId(id){
    return this.http.get("http://localhost:8080/api/v1/orderDetail/findAllOrderDetailByOrderId/"+id);
  }

  getAllOrderDetail(){
    return this.http.get("http://localhost:8080/api/v1/orderDetail/findAllOrderDetail");
  }
  
  addOrder(order){
    return this.http.post("http://localhost:8080/api/v1/orders/save", order);
  }
  addOD(od){
    return this.http.post("http://localhost:8080/api/v1/orderDetail/save",od);
  }
  deleteOrder(id){
    return this.http.delete("http://localhost:8080/api/v1/orders/delete/"+id);
  }
}
