import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CatalogService } from '../services/catalog.service';
import { CommentService } from '../services/comment.service';
import { FoodService } from '../services/food.service';

@Component({
  selector: 'app-blog-detail',
  templateUrl: './blog-detail.component.html',
  styleUrls: ['./blog-detail.component.css']
})
export class BlogDetailComponent implements OnInit {
//blog = item
  item: any;
  listCatalog: any;  
  prevBlog: any;
  nextBlog: any;
  listRecentBlog: any[];
  check1: boolean = true;
  check2: boolean;

  constructor(private routes: ActivatedRoute,private commentService: CommentService,private caService:CatalogService, private foodService: FoodService) { }

  ngOnInit(): void {
    this.routes.params.subscribe(p => {
      let id = p.id;
      this.commentService.getAllBlog().subscribe((res: any[])=>{
        this.item = res.filter(x => x.blogId == id)[0];
        this.listRecentBlog = [];
        this.listRecentBlog.push(res[res.length-1]);
        this.listRecentBlog.push(res[res.length-2]);
        this.listRecentBlog.push(res[res.length-3]);
        if(id==1){
          this.check1 = false;
          this.check2 = true;
          this.nextBlog = res[1];
          this.prevBlog = res[res.length - 1]
        }
        else if(id== res.length){
          this.check2 = false;
          this.check1 = true;
          this.nextBlog = res[0];
          this.prevBlog = res[res.length - 2]
        }else{
          this.check1 = this.check2 = true;
          this.nextBlog = res[id];
          this.prevBlog = res[id-2];
        }
        console.log(this.item);
      })
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
  Category(item){

  }
}
