import { Component, OnInit } from '@angular/core';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-order-all',
  templateUrl: './order-all.component.html',
  styleUrls: ['./order-all.component.css']
})
export class OrderAllComponent implements OnInit {

  listOrder: any[];

  constructor(private cartService: CartService) { }

  ngOnInit(): void {
    this.cartService.getAllOrder().subscribe((res: any[])=>{
      this.listOrder = res.filter(x => (x.user?.userName==localStorage.getItem("key"))&&(x.orderStatus != "da thanh toan"));
      console.log(this.listOrder);
    })
  }

}
