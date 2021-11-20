import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  constructor(private route: ActivatedRoute) { }

  listOrderDetail: any[] = [];
  order: any;

  ngOnInit(): void {
    this.route.queryParams.subscribe((param: any) => {
      this.order = param;
    })
    console.log(this.order);
  }

}
