import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from '../services/cart.service';
import { FoodService } from '../services/food.service';
import { LazyLoadScriptService } from '../services/lazy-load-script.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  quantity:number = 1;
  food: any;
  fD:any;
  listFoodRelated: any[] = [];
  listBuy: any[] = [];
  total: any;
  addresses: string;
  user: any;
  name:any;
  phone: any;
  listDeal: any[] = [];
  listCare: any[] ;

  constructor(private route:ActivatedRoute, private router : Router,private userService: UserService ,private lazyService: LazyLoadScriptService,private routes: ActivatedRoute, private foodService:  FoodService, private cartService: CartService) { }

  ngOnInit(): void {
    this.lazyService.loadScript('/assets/js/main.js').subscribe(_ => {
      console.log('Jquery is loaded!')
    });
    for (let index = 0; index < localStorage.length; index++) {
      if((localStorage.key(index) != "key")&&(JSON.parse(localStorage.getItem(localStorage.key(index))).foodSend.food!=null)){
        this.listBuy.push(JSON.parse(localStorage.getItem(localStorage.key(index))));
        this.getTotal();
      }
      if((localStorage.key(index) != "key")&&(JSON.parse(localStorage.getItem(localStorage.key(index))).foodSend.food==null)){
        this.listDeal.push(JSON.parse(localStorage.getItem(localStorage.key(index))));
        this.getTotal();
      }
    }
    this.foodService.getFood().subscribe((res: any[]) => {
      this.listCare = res.filter(x =>( x.food.discount!=0));
      for (let index = 0; index < this.listBuy.length; index++) {
        this.listCare = this.listCare.filter(x => x.food?.foodId != this.listBuy[index].foodSend?.food?.foodId);
      }
      for (let i = 0; i < 9; i++) {
        this.listFoodRelated.push(this.listCare[i]);
      }
    })
    
    this.userService.getAll().subscribe((res: any[])=>{
      this.user = res.filter(x =>(x.userName == localStorage.getItem("key")))[0];
      console.log(this.user);
      this.addresses =this.user.addresses;
      this.phone = this.user.phone;
      this.name = this.user.userName;
    })
    // this.getData();
  }
  Minus(item:any){
    item.amount -=1;
    if(item.foodSend.food != null){
      item.price = item.amount*item.foodSend?.price*(100-item.foodSend?.food?.discount)/100;
      if(item.amount <= 1){
        item.amount = 1;
        item.price =item.amount*item.foodSend?.price*(100-item.foodSend?.food?.discount)/100;
      }
    }else{
      item.price = item.amount*item.foodSend?.bonusPrice;
    }
    this.updateLocalStorage(item);
    this.getTotal();
  }
  Plus(item:any){
    item.amount +=1;
    if(item.foodSend.food != null){
      item.price = item.amount*item.foodSend?.price*(100-item.foodSend?.food?.discount)/100;
    }else{
      item.price = item.amount*item.foodSend?.bonusPrice;
    }
    this.updateLocalStorage(item);
    this.getTotal();
    console.log(item)
  }
  // getData(){
  //   console.log(localStorage.getItem("keyFood"));
  //   console.log(localStorage);
  // }
  remove(item : any){
    this.listBuy = this.listBuy.filter(x => x.foodSend.fdId != item.foodSend.fdId);
    localStorage.removeItem(item.foodSend.fdId);
    this.listDeal = this.listDeal.filter(x => x.foodSend.bonusId != item.foodSend.bonusId);
    localStorage.removeItem(item.foodSend.bonusId);
    this.getTotal();
  }
  getTotal(){
    this.total = 0;
    for (let i = 0; i < this.listBuy.length; i++) {
      this.total += (this.listBuy[i].amount*this.listBuy[i].foodSend?.price*(100-this.listBuy[i].foodSend?.food?.discount)/100);
    }
    for (let i=0; i< this.listDeal.length; i++){
      this.total += this.listDeal[i].foodSend.bonusPrice * this.listDeal[i].amount;
    }
    this.total = parseFloat(this.total).toFixed(2);
  }
  updateLocalStorage(item: any){
    for (let index = 0; index < localStorage.length; index++) {
      if((localStorage.key(index) != "key")&&(JSON.parse(localStorage.getItem(localStorage.key(index))).foodSend.food!=null)){
        if(JSON.parse(localStorage.getItem(localStorage.key(index))).foodSend.fdId == item.foodSend.fdId){
          localStorage.removeItem(item.foodSend.fdId);
          localStorage.setItem(item.foodSend.fdId,JSON.stringify(item));
        };
      }
      if((localStorage.key(index) != "key")&&(JSON.parse(localStorage.getItem(localStorage.key(index))).foodSend.food==null)){
        if(JSON.parse(localStorage.getItem(localStorage.key(index))).foodSend.bonusId == item.foodSend.bonusId){
          localStorage.removeItem(item.foodSend.bonusId);
          localStorage.setItem(item.foodSend.bonusId,JSON.stringify(item));
        };
      }
    }
    
  }
  discount(item: any): boolean{
    if(item.foodSend.food.discount != 0){
      return true;
    }
    else return false;
  }
  order(){
    var today = new Date();
    const order ={
      addresses: this.addresses,
      created: today.getFullYear()+'-'+(today.getMonth()+1)+'-'+ today.getDate(),
      user: this.user,
      nameReceiver: this.name,
      phone: this.phone,
      orderStatus: "cho xu ly"
    }
    this.cartService.addOrder(order).subscribe((res:any) =>{
      console.log(res);
      for (let index = 0; index < this.listBuy.length; index++) {
        const od ={
          order: res,
          foodDetail: this.listBuy[index].foodSend,
          quantity: this.listBuy[index].amount,
          price: this.listBuy[index].foodSend?.price*this.listBuy[index].amount*(100 - this.listBuy[index].foodSend?.food?.discount)/100
        }
        this.cartService.addOD(od).subscribe(res2 =>{
          console.log(res2);
        });
        localStorage.removeItem(this.listBuy[index].foodSend.fdId);
        //alert("Order successfully! Please pay when receiving! Thank you so much!");
      }
      this.router.navigate(['/user/order/',res.orderId], { relativeTo: this.route });
    });
  }
  addCart(food: any){
    if(food.food !=null){
      const sendItem = {
        foodSend: food,
        sizeFood: food.size.sizeName,
        amount: 1,
        price: food.price
      }
      localStorage.setItem(sendItem.foodSend.fdId, JSON.stringify(sendItem));
      this.router.navigate(['/user/cart'], {relativeTo: this.route});
      console.log("done")
    }else{
      this.foodService.getAllfd().subscribe((res: any[]) =>{
        var foodDeal = res.filter(x=>x.fdId == food.foodDetail.fdId)[0];
        console.log(foodDeal);
        const sendItem = {
          foodSend: foodDeal,
          sizeFood: foodDeal.size.sizeName,
          amount: 1,
          price: foodDeal.price
        }
        localStorage.setItem(sendItem.foodSend.fdId, JSON.stringify(sendItem));
          this.router.navigate(['/user/cart'], {relativeTo: this.route});
          console.log("done")
      })
      
    }
  }
}
