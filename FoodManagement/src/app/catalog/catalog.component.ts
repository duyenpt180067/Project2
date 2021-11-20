import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CatalogService } from '../services/catalog.service';
import { FoodService } from '../services/food.service';
import { LazyLoadScriptService } from '../services/lazy-load-script.service';

@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit {
  catalog: any;
  listCaRemain: any;
  listCatalog: any;
  listDeal: any;
  listPage: any;
  searchFood: any;
  listFood: any;
  listCategory: any;
  selected:any = "default";
  id: any;
  constructor(private lazyService: LazyLoadScriptService,private foodService: FoodService ,private routes:ActivatedRoute,private route:ActivatedRoute, private router : Router, private catalogService:  CatalogService) { }

  ngOnInit(): void {
    
    this.routes.params.subscribe(p => {
       this.id = p.id;
       this.foodService.getListPageCatalog(this.id).subscribe((res:any[]) =>{
        this.listPage = res.filter(x => x!=1);
      })
      this.catalogService.getAll().subscribe((res:any[])=>{
        this.catalog = res.filter(x => x.caId == this.id)[0];
        this.listCaRemain = res.filter(x => x.caId != this.id);
        this.listCatalog = [];
        this.listCategory = res;
        // for (let index = 0; index < this.listCategory.length; index++) {
        //   if(id== this.listCategory[index].caId){
        //     document.getElementById(id?.toString()).style.background = "#ffc222";
        //   } 
        //   else{
        //     document.getElementById(this.listCategory[index].caId.toString()).style.background = "#fbf7e8";
        //   }     
        // }
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
      this.route.queryParams.subscribe((params: any[]) => {
        var pages = params['page'];
        var key = params['key'];
        this.searchFood = key;
        if(key == null){
          if(pages != null){
            this.selected = "default";
            this.router.navigate([ '/user/shop/'+this.id ], { queryParams: { page: pages } });
            this.foodService.getFoodPageCatalog(this.id,pages).subscribe(res =>{
              this.listFood = res;
              console.log(this.listFood);
            })
          }if(pages == null){
            this.router.navigate([ '/user/shop/'+this.id ], { queryParams: { page: 1} });
            document.getElementById("1").style.background = "#ffc222";
            this.foodService.getFoodPageCatalog(this.id,1).subscribe(res =>{
              this.listFood = res;
              console.log(this.listFood);
            })
          }
        }else{
          this.searchFood = key;
          this.search();
        }
      });
      this.foodService.getFood().subscribe((res: any[]) => {
        this.listFood = res.filter(x => x.food.catalog.caId == this.id);
      })
      
    })
    this.foodService.getDeal().subscribe((res: any[]) => {
      this.listDeal = res;
      console.log(this.listDeal);
    })
  }
  Category(id: any){
    
  }
  search(){
    this.selected = "default";
    this.route.queryParams.subscribe((params: any[]) => {
      var pages = params['page'];
      var key = params['key'];
      if(key==null){
        this.router.navigate([ '/user/shop/'+this.id ], { queryParams: { page: 1, key: this.searchFood } });
        document.getElementById("1").style.background = "#ffc222";
        this.foodService.getFoodPageCatalog(this.id,1).subscribe((res: any[]) => {
          if(this.searchFood == ""){
            this.router.navigate([ '/user/shop/'+this.id ], { queryParams: { page: 1} });
            document.getElementById("1").style.background = "#ffc222";
            this.listFood = res;
          }
          else {
            this.listFood = res.filter(x =>(x.food.foodName.toLowerCase().indexOf(this.searchFood.toLowerCase()) >=0));
          }
        })
      }
      else{
        // if(pages == null){
        //   this.router.navigate([ '/user/shop/'+this.id ], { queryParams: { page: 1, key: this.searchFood } });
        //   this.foodService.getFoodPageCatalog(this.id,1).subscribe((res: any[]) => {
        //     if(this.searchFood == ""){
        //       this.router.navigate([ '/user/shop/' ], { queryParams: { page: 1} });
        //       document.getElementById("1").style.background = "#ffc222";
        //       this.listFood = res;
        //     }
        //     else {
        //       this.router.navigate([ '/user/shop/'+this.id ], { queryParams: { page: 1, key: this.searchFood} });
        //       document.getElementById("1").style.background = "#ffc222";
        //       this.listFood = res.filter(x =>(x.food.foodName.toLowerCase().indexOf(this.searchFood.toLowerCase()) >=0));
        //     }
        //   })
        // }else{
          this.foodService.getFoodPageCatalog(this.id,pages).subscribe((res: any[]) => {
            if(this.searchFood == ""){
              this.router.navigate([ '/user/shop/'+this.id ], { queryParams: { page: 1} });
              document.getElementById("1").style.background = "#ffc222";
              this.listFood = res;
            }
            else {
              this.listFood = res.filter(x =>(x.food.foodName.toLowerCase().indexOf(this.searchFood.toLowerCase()) >=0));
            }
          })
        // }
      }
    })
    
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
  discount(item: any): boolean{
    if(item.food.discount != 0){
      return true;
    }
    else return false;
  }
  addCart(food: any){
    const sendItem = {
      foodSend: food,
      sizeFood: food.size.sizeName,
      amount: 1,
      price: food.price
    }
    localStorage.setItem(sendItem.foodSend.fdId, JSON.stringify(sendItem));
      this.router.navigate(['/user/cart'], {relativeTo: this.route});
      console.log("done")
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
      this.routes.params.subscribe(p => {
        var id = p.id;
        this.foodService.getFood().subscribe((res: any[]) => {
          this.listFood = res.filter(x => x.food.catalog.caId == id);
        })
      })
    }
  }
  page(i : any){
    this.selected = "default";
    this.listFood = [];
    var div = document.getElementById(i)
    div.style.background = "#ffc222";
    if(this.searchFood == null){
      if(i !=1){
        this.foodService.getFoodPageCatalog(this.id,i).subscribe(res =>{
          this.listFood = res;
        })
        this.router.navigate([ '/user/shop/'+this.id ], { queryParams: { page: i } });
        document.getElementById("1").style.background = "#fbf7e8";
        for (let index = 0; index < this.listPage.length; index++) {
          if(this.listPage[index] != i){
            var div2 = document.getElementById(this.listPage[index])
            div2.style.background = "#fbf7e8";
          }
        }
      }
      else{
        this.router.navigate([ '/user/shop/'+this.id ], { queryParams: { page: 1 } });
        this.foodService.getFoodPageCatalog(this.id,1).subscribe(res =>{
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
        this.router.navigate([ '/user/shop/'+this.id ], { queryParams: { page: i, key: this.searchFood } });
        this.foodService.getFoodPageCatalog(this.id,i).subscribe((res: any[]) =>{
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
        this.router.navigate([ '/user/shop/'+this.id ], { queryParams: { page: 1,key:  this.searchFood } });
        this.foodService.getFoodPageCatalog(this.id,1).subscribe((res:any[]) =>{
          this.listFood = res.filter(x =>(x.food.foodName.toLowerCase().indexOf(this.searchFood.toLowerCase()) >=0));
        })
        for (let index = 0; index < this.listPage.length; index++) {
          var div2 = document.getElementById(this.listPage[index])
          div2.style.background = "#fbf7e8";
        }
      }
    }
  }
}
