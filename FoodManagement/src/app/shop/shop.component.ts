import { Component, OnInit } from '@angular/core';
import { CatalogService } from '../services/catalog.service';
import { FoodService } from '../services/food.service';
import { FormBuilder, FormGroup, Validators,FormControl } from '@angular/forms';
import { Router, NavigationExtras, ActivatedRoute } from '@angular/router';
import { LazyLoadScriptService } from '../services/lazy-load-script.service';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  listCatalog: any;
  listFood: any;
  listDeal: any;
  searchFood: any;
  listPage: any;
  selected:any = "default";
  listAll: any;

  constructor(private route:ActivatedRoute, private router : Router, private lazyService: LazyLoadScriptService, private caService:CatalogService, private foodService: FoodService) { }

  ngOnInit(): void {
    
    this.foodService.getListPage().subscribe((res:any[]) =>{
      this.listPage = res.filter(x => x!=1);
    })
    this.route.queryParams.subscribe((params: any[]) => {
      var pages = params['page'];
      var key = params['key'];
      this.searchFood = key;
      if(key == null){
        if(pages != null){
          this.selected = "default";
          this.router.navigate([ '/user/shop' ], { queryParams: { page: pages } });
          this.foodService.getFoodPage(pages).subscribe(res =>{
            this.listFood = res;
            console.log(this.listFood);
          })
        }if(pages == null){
          this.router.navigate([ '/user/shop' ], { queryParams: { page: 1} });
          document.getElementById("1").style.background = "#ffc222";
          this.foodService.getFoodPage(1).subscribe(res =>{
            this.listFood = res;
            console.log(this.listFood);
          })
        }
      }else{
        this.searchFood = key;
        this.search();
      }
    });
    this.foodService.getAll().subscribe((res: any[]) =>{
      if(this.searchFood==null){
        this.listAll = res;
      }else{
        this.listAll = res.filter(x =>(x.foodName.toLowerCase().indexOf(this.searchFood.toLowerCase()) >=0));
      }
    })
    this.lazyService.loadScript('/assets/js/main.js').subscribe(_ => {
      console.log('Jquery is loaded!')
    });
    this.caService.getAll().subscribe((res:any[])=>{
      this.listCatalog = [];
      for (let index = 0; index < res.length; index++) {
        var sizeFood ;
        this.foodService.getFood().subscribe((resFood: any[]) => {
          var foodList = resFood.filter(x => x.food.catalog.caId == res[index].caId);
          sizeFood = foodList.length;
          const cate ={
            category: res[index],
            size: sizeFood
          }
          this.listCatalog.push(cate);
        })          
      }
    })
    this.foodService.getDeal().subscribe((res: any[]) => {
      this.listDeal = res;
      console.log(this.listDeal);
    })
  }

  Category(catalog:any){
  }
  compare(a: any, b: any) {
    if (a < b) {
      return 1;
    }
    if (a > b) {
      return -1;
    }
    return 0;
  }
  compare2(a: any, b: any) {
    if (a > b) {
      return 1;
    }
    if (a < b) {
      return -1;
    }
    return 0;
  }
  sorted(){
    if(this.selected==='late'){
      this.listFood = this.listFood.sort((item1, item2) => {
        return this.compare(item1.created, item2.created)
      });
    }
    else if( this.selected === 'high'){
      this.listFood = this.listFood.sort((item1, item2) => {
        return this.compare(item2.price*(100-item2.food.discount), item1.price*(100-item1.food.discount))
      });
    }
    else if (this.selected === 'low'){
      this.listFood = this.listFood.sort((item1, item2) => {
        return this.compare2(item2.price*(100-item2.food.discount), item1.price*(100-item1.food.discount))
      });
    }
    else{
      this.foodService.getFood().subscribe((res: any[]) => {
        this.listFood = res;
      })
    }
  }
  search(){
    this.selected = "default";
    this.route.queryParams.subscribe((params: any[]) => {
      var pages = params['page'];
      var key = params['key'];
      if(key==null){
        this.router.navigate([ '/user/shop' ], { queryParams: { page: 1, key: this.searchFood } });
        document.getElementById("1").style.background = "#ffc222";
        this.foodService.getFoodPage(1).subscribe((res: any[]) => {
          if(this.searchFood == ""){
            this.router.navigate([ '/user/shop' ], { queryParams: { page: 1} });
            document.getElementById("1").style.background = "#ffc222";
            this.listFood = res;
          }
          else {
            this.listFood = res.filter(x =>(x.food.foodName.toLowerCase().indexOf(this.searchFood.toLowerCase()) >=0));
          }
        })
      }
      else{
        if(pages == null){
          this.router.navigate([ '/user/shop' ], { queryParams: { page: 1, key: this.searchFood } });
          this.foodService.getFoodPage(1).subscribe((res: any[]) => {
            if(this.searchFood == ""){
              this.router.navigate([ '/user/shop' ], { queryParams: { page: 1} });
              document.getElementById("1").style.background = "#ffc222";
              this.listFood = res;
            }
            else {
              this.router.navigate([ '/user/shop' ], { queryParams: { page: 1, key: this.searchFood} });
              document.getElementById("1").style.background = "#ffc222";
              this.listFood = res.filter(x =>(x.food.foodName.toLowerCase().indexOf(this.searchFood.toLowerCase()) >=0));
            }
          })
        }else{
          this.foodService.getFoodPage(pages).subscribe((res: any[]) => {
            if(this.searchFood == ""){
              this.router.navigate([ '/user/shop' ], { queryParams: { page: 1} });
              document.getElementById("1").style.background = "#ffc222";
              this.listFood = res;
            }
            else {
              this.listFood = res.filter(x =>(x.food.foodName.toLowerCase().indexOf(this.searchFood.toLowerCase()) >=0));
            }
          })
        }
      }
    })
    
  }

  page(i : any){
    this.selected = "default";
    this.listFood = [];
    var div = document.getElementById(i)
    div.style.background = "#ffc222";
    if(this.searchFood == null){
      if(i !=1){
        this.foodService.getFoodPage(i).subscribe(res =>{
          this.listFood = res;
        })
        this.router.navigate([ '/user/shop' ], { queryParams: { page: i } });
        document.getElementById("1").style.background = "#fbf7e8";
        for (let index = 0; index < this.listPage.length; index++) {
          if(this.listPage[index] != i){
            var div2 = document.getElementById(this.listPage[index])
            div2.style.background = "#fbf7e8";
          }
        }
      }
      else{
        this.router.navigate([ '/user/shop' ], { queryParams: { page: 1 } });
        this.foodService.getFoodPage(1).subscribe(res =>{
          this.listFood = res;
        })
        for (let index = 0; index < this.listPage.length; index++) {
          var div2 = document.getElementById(this.listPage[index])
          div2.style.background = "#fbf7e8";
        }
      }
    }
    else{
      if(i !=1){
        this.router.navigate([ '/user/shop' ], { queryParams: { page: i, key: this.searchFood } });
        this.foodService.getFoodPage(i).subscribe((res: any[]) =>{
          this.listFood = res.filter(x =>(x.food.foodName.toLowerCase().indexOf(this.searchFood.toLowerCase()) >=0));
          console.log(this.listFood);
        })
        document.getElementById("1").style.background = "#fbf7e8";
        for (let index = 0; index < this.listPage.length; index++) {
          if(this.listPage[index] != i){
            var div2 = document.getElementById(this.listPage[index])
            div2.style.background = "#fbf7e8";
          }
        }
      }
      else{
        this.router.navigate([ '/user/shop' ], { queryParams: { page: 1,key:  this.searchFood } });
        this.foodService.getFoodPage(1).subscribe((res:any[]) =>{
          this.listFood = res.filter(x =>(x.food.foodName.toLowerCase().indexOf(this.searchFood.toLowerCase()) >=0));
        })
        for (let index = 0; index < this.listPage.length; index++) {
          var div2 = document.getElementById(this.listPage[index])
          div2.style.background = "#fbf7e8";
        }
      }
    }
  }
  discount(item: any): boolean{
    if(item.food.discount != 0){
      return true;
    }
    else return false;
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
  post(){
    
  }
}
