import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodService } from '../services/food.service';
import { LazyLoadScriptService } from '../services/lazy-load-script.service';

@Component({
  selector: 'app-deal',
  templateUrl: './deal.component.html',
  styleUrls: ['./deal.component.css']
})
export class DealComponent implements OnInit {

  food: any;
  sendItem: any;
  size: any = "Free Size";
  quantity:number = 1;
  listFD: any;
  price1: any;
  fdtosend: any;
  priceSend: any;
  formAdd: FormGroup;

  constructor( private fb: FormBuilder,private route:ActivatedRoute, private router : Router, private lazyService: LazyLoadScriptService,private routes: ActivatedRoute, private foodService:  FoodService) { }

  ngOnInit(): void {
    this.formAdd = this.fb.group({
      size:['', Validators.required],
      quan:[''],
      like:['']
    })
    this.routes.params.subscribe(p => {
      let id = p.id;
      this.foodService.getDeal().subscribe((res: any[]) =>{
        this.food = res.filter(x => x.bonusId == id)[0];
        console.log(this.food);
        this.sendItem = {
          foodSend: this.food,
          sizeFood: "Free Size",
          amount: this.quantity,
        }
        console.log(this.sendItem);
        this.listFD = res.filter(x => x.bonusId == id);
        this.price1 = this.listFD[0].bonusPrice;
        console.log(this.listFD);
      })
    })
  }
  Minus(sendItem: any){
    this.quantity -=1;
    if(this.quantity <= 1){
      this.quantity = 1;
    }
    this.getFoodSend(sendItem);
  }
  Plus(sendItem: any){
    this.quantity +=1;
    this.getFoodSend(sendItem);
  }
  addCart(sendItem: any){
    this.getFoodSend(sendItem);
    console.log(this.fdtosend);
    sendItem = {
      foodSend: this.fdtosend,
      sizeFood: this.size,
      amount: this.quantity,
      price: this.price1*this.quantity
    }
    
      localStorage.setItem(sendItem.foodSend.bonusId, JSON.stringify(sendItem));
      this.router.navigate(['/user/cart'], {relativeTo: this.route});
      console.log("done")
    
  }
  getFoodSend(sendItem: any){
    sendItem = {
      foodSend: this.food,
      sizeFood: this.size,
      amount: this.quantity,
    }
    console.log(sendItem);
    this.routes.params.subscribe(p => {
      let id = p.id;
      this.foodService.getDeal().subscribe((res: any[]) =>{
        this.fdtosend = res.filter(x => (x.bonusId == id))[0];
        console.log(this.fdtosend);
        this.priceSend = sendItem.amount*this.fdtosend.bonusPrice;
        console.log(this.priceSend);
      })
    })
  }
}
