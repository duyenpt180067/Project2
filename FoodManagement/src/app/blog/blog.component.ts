import { Component, OnInit } from '@angular/core';
import { CatalogService } from '../services/catalog.service';
import { CommentService } from '../services/comment.service';
import { FoodService } from '../services/food.service';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit {

  listCatalog: any;
  listBlog: any;
  listRecentBlog: any;

  constructor(private caService:CatalogService, private foodService: FoodService, private commentService: CommentService) { }

  ngOnInit(): void {
    this.commentService.getAllBlog().subscribe((res: any[]) =>{
      this.listBlog = res;
      this.listRecentBlog = [];
        this.listRecentBlog.push(res[res.length-1]);
        this.listRecentBlog.push(res[res.length-2]);
        this.listRecentBlog.push(res[res.length-3]);
      console.log(this.listBlog);
    })
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
  }
  Category(catalog:any){
  }
}
