import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuComponent } from './menu.component';
import { Routes,RouterModule } from '@angular/router';

const routes: Routes = [
  {path: '', component: MenuComponent,},
];

@NgModule({
  declarations: [MenuComponent],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class MenuModule { }
