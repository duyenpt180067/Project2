import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FoodService {
  foodURL = "http://localhost:8080/api/v1/food/findAllFood";
  fdURL = "http://localhost:8080/api/v1/foodDetail/findAllFoodDetail";
  food = "http://localhost:8080/api/v1/foodDetail/findAllFood";
  deal ="http://localhost:8080/api/v1/bonus/findAllBonus";
  foodId ="http://localhost:8080/api/v1/food/findFoodById";
  imageUrl = "http://localhost:8080/api/v1/imageFood/findAllImageFood";
  commnetURL = "http://localhost:8080/api/v1/comment/findAllComment";
  foodPage = "http://localhost:8080/api/v1/foodDetail/findFoodPage";
  listPage = "http://localhost:8080/api/v1/foodDetail/listPage";
  listPageCatalog = "http://localhost:8080/api/v1/foodDetail/listPageOneCatalog";

  constructor(private http : HttpClient ) { }

  getAll(){
    return this.http.get(this.foodURL);
  }
  getAllfd(){
    return this.http.get(this.fdURL);
  }
  getFood(){
    return this.http.get(this.food);
  }
  getDeal(){
    return this.http.get(this.deal);
  }
  findFoodById(id){
    return this.http.get(this.foodId + "/" + id);
  }
  getImage(){
    return this.http.get(this.imageUrl);
  }
  getComment(){
    return this.http.get(this.commnetURL);
  }
  addComment(comment){
    return this.http.post("http://localhost:8080/api/v1/comment/save", comment);
  }
  getFoodPage(page: any){
    return this.http.get(this.foodPage + "/" + page);
  }
  getListPage(){
    return this.http.get(this.listPage);
  }
  getListPageCatalog(caId: any){
    return this.http.get(this.listPageCatalog+"/"+caId);
  }
  getFoodPageCatalog(caId: any, page: any){
    return this.http.get("http://localhost:8080/api/v1/foodDetail/findFoodPageOneCatalog"+"/"+caId+"/"+page);
  }
}
