import { Component, OnInit } from '@angular/core';
import { LazyLoadScriptService } from '../services/lazy-load-script.service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  constructor(private lazyService: LazyLoadScriptService) { }

  ngOnInit(): void {
    this.lazyService.loadScript('/assets/js/main.js').subscribe(_ => {
      console.log('Jquery is loaded!')
    });
  }

}
