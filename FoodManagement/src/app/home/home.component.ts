import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CatalogService } from '../services/catalog.service';
import { FoodService } from '../services/food.service';
import { LazyLoadScriptService } from '../services/lazy-load-script.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  listCatalog: any;
  listCategory: any;
  listFood: any;
  listRecipes: any[] = [];
  listRecipes2: any[] = [];

  constructor(private route:ActivatedRoute, private router : Router,private lazyService: LazyLoadScriptService, private caService:CatalogService, private foodService: FoodService) { }

  ngOnInit(): void {
    this.lazyService.loadScript('/assets/js/main.js').subscribe(_ => {
      console.log('Jquery is loaded!')
    });
    this.caService.getAll().subscribe((res: any[]) => {
      this.listCatalog = res.filter(x => x.caId > 1);
      this.listCategory = res;
    })
    this.foodService.getFood().subscribe((res: any[]) => {
      this.listFood = res.filter(x =>( (x.food.catalog.caId == 1)));
      console.log(this.listFood);
    })
    this.foodService.getAllfd().subscribe((res: any[]) => {
      this.listRecipes.push(res[46]);
      this.listRecipes.push(res[24]);
      this.listRecipes.push(res[36]);
      this.listRecipes2.push(res[3]);
      this.listRecipes2.push(res[16]);
      this.listRecipes2.push(res[5]);
      console.log(this.listRecipes);
    })
    document.getElementById("1").style.background = "#ffc222";
  }
  // Category1(){
  //   document.getElementById("1").style.background = "#ffc222";
  //   this.foodService.getAll().subscribe((res: any[]) => {
  //     this.listFood = res.filter(x =>( x.food.catalog.caId == 1));
  //     console.log(this.listFood);
  //   })
  // }

  Category(catalog:any){
    if(catalog == 1){
      document.getElementById("1").style.background = "#ffc222";
      for (let index = 0; index < this.listCatalog.length; index++) {
        if(this.listCatalog[index].caId != 1){
          document.getElementById(this.listCatalog[index].caId).style.background = "#fff";
        }
      }
      this.foodService.getFood().subscribe((res: any[]) => {
        this.listFood = res.filter(x =>( x.food.catalog.caId == 1));
        console.log(this.listFood);
      })
    }
    else if(catalog.caId == 2){
      document.getElementById("2").style.background = "#ffc222";
      document.getElementById("1").style.background = "#fff";
      for (let index = 0; index < this.listCatalog.length; index++) {
        if(this.listCatalog[index].caId != 2){
          document.getElementById(this.listCatalog[index].caId).style.background = "#fff";
        }
      }
      this.foodService.getFood().subscribe((res: any[]) => {
        this.listFood = res.filter(x =>( x.food.catalog.caId == 2));
        console.log(this.listFood);
      })
    }
    else if(catalog.caId == 3){
      document.getElementById("3").style.background = "#ffc222";
      for (let index = 0; index < this.listCatalog.length; index++) {
        if(this.listCatalog[index].caId != 3){
          document.getElementById(this.listCatalog[index].caId).style.background = "#fff";
        }
      }
      this.foodService.getFood().subscribe((res: any[]) => {
        this.listFood = res.filter(x =>( x.food.catalog.caId == 3));
        console.log(this.listFood);
      })
    }
    else if(catalog.caId == 4){
      document.getElementById("4").style.background = "#ffc222";
      for (let index = 0; index < this.listCatalog.length; index++) {
        if(this.listCatalog[index].caId != 4){
          document.getElementById(this.listCatalog[index].caId).style.background = "#fff";
        }
      }
      this.foodService.getFood().subscribe((res: any[]) => {
        this.listFood = res.filter(x =>( x.food.catalog.caId == 4));
        console.log(this.listFood);
      })
    }
    else if(catalog.caId == 5){
      document.getElementById("5").style.background = "#ffc222";
      for (let index = 0; index < this.listCatalog.length; index++) {
        if(this.listCatalog[index].caId != 5){
          document.getElementById(this.listCatalog[index].caId).style.background = "#fff";
        }
      }
      this.foodService.getFood().subscribe((res: any[]) => {
        this.listFood = res.filter(x =>( x.food.catalog.caId == 5));
        console.log(this.listFood);
      })
    }
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
  changeToPage1(){
    this.router.navigate([ '/user/shop' ], { queryParams: { page: 1 } });
  }
}
