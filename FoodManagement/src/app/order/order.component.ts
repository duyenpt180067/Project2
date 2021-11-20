import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  constructor(private route: ActivatedRoute, private cartService: CartService, private router: Router) { }

  listOrderDetail: any[] = [];
  orderid: any;
  order: any;
  check: any;
  orderNeed: any;

  ngOnInit(): void {
    this.orderid = this.route.snapshot.paramMap.get('id');
    // this.routes.params.subscribe(p => {
    //   let id = p.id;
    //console.log(this.orderid);
    this.cartService.findOrderById(this.orderid).subscribe(res =>{
      this.orderNeed = res;
    })
    this.cartService.getOrderDetailByOrderId(this.orderid).subscribe((res: any[]) => {
      this.listOrderDetail = res;
    })
    console.log(this.orderid);
    
    this.cartService.getOrderDetailByOrderId(this.orderid).subscribe(res =>{
      this.order = res;
      if(this.orderNeed.orderStatus != "chờ xử lý"){
        this.check = false;
      }
      else {
        this.check = true;
      }
      
    })
    console.log(this.check);
  }
  delete(){
    // if(this.order.orderStatus != "da thanh toan"){
    //   document.getElementById("btn-delete").setAttribute.di
    // }
    console.log(this.orderNeed.orderStatus);
    console.log(this.check);
    if(this.check == true){
      if(confirm("Ban co chac muon huy don hang nay?") == true){
        this.cartService.deleteOrder(this.orderid).subscribe(res=>{
          alert("Delete success!");
        })
        this.router.navigate(['/user/shop'], {relativeTo: this.route});
      }
    }else{
      alert("Ban khong the huy don hang vi don hang dang van chuyen!");
    }

  }
}
