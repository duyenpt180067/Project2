import { Component, OnInit } from '@angular/core';
import { CommentService } from '../services/comment.service';

@Component({
  selector: 'app-faq',
  templateUrl: './faq.component.html',
  styleUrls: ['./faq.component.css']
})
export class FaqComponent implements OnInit {

  check:boolean = true;
  listFaq: any;
  listElse: any;

  constructor(private commentService: CommentService) { }

  ngOnInit(): void {
    this.commentService.getAllFaq().subscribe((res: any[])=>{
      this.listFaq = res;
    })
  }

  Click(item: any){
    this.check = !this.check;
    if(this.check==false){
      document.getElementById(item?.faqId.toString()).style.display = "block";
      this.commentService.getAllFaq().subscribe((res: any[])=>{
        this.listElse = res.filter(x => x.faqId != item.faqId);
        for (let index = 0; index < this.listElse.length; index++) {
          document.getElementById(this.listElse[index].faqId.toString()).style.display = "none";
        }
      })
    }
    else{
      document.getElementById(item?.faqId.toString()).style.display = "none";
      this.commentService.getAllFaq().subscribe((res: any[])=>{
        this.listElse = res.filter(x => x.faqId != item.faqId);
        for (let index = 0; index < this.listElse.length; index++) {
          document.getElementById(this.listElse[index].faqId.toString()).style.display = "none";
        }
      })
    } 
  }

}
