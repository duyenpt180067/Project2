import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { BlogDetailComponent } from './blog-detail/blog-detail.component';
import { BlogComponent } from './blog/blog.component';
import { CartComponent } from './cart/cart.component';
import { CatalogComponent } from './catalog/catalog.component';
import { ContactComponent } from './contact/contact.component';
import { DealComponent } from './deal/deal.component';
import { FaqComponent } from './faq/faq.component';
import { FoodDetailComponent } from './food-detail/food-detail.component';
import { HistoryComponent } from './history/history.component';
import { HomeComponent } from './home/home.component';
import { HomeModule } from './home/home.module';
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';
import { MenuModule } from './menu/menu.module';
import { NotFoundComponent } from './not-found/not-found.component';
import { OrderAllComponent } from './order-all/order-all.component';
import { OrderComponent } from './order/order.component';
import { PageComponent } from './page/page.component';
import { RegisterComponent } from './register/register.component';
import { ShopComponent } from './shop/shop.component';
import { TeamComponent } from './team/team.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  {path: 'user', loadChildren:() => import('./home/home.module').then(m => m.HomeModule)},
  {path: 'user/menu', component:MenuComponent},
  {path: 'user/about', component:AboutComponent},
  {path: 'user/contact', component:ContactComponent},
  {path: 'user/team', component:TeamComponent},
  {path: 'user/blog', component:BlogComponent},
  {path: 'user/blog/:id', component:BlogDetailComponent},
  {path: 'user/shop', component:ShopComponent},
  {path: '', component:LoginComponent},
  {path: 'user/register', component:RegisterComponent},
  {path: 'user/faq', component:FaqComponent},
  {path: 'user/food/:id', component:FoodDetailComponent},
  {path: 'user/deal/:id', component:DealComponent},
  {path: 'user/cart', component:CartComponent},
  {path: 'user/shop/:id', component:CatalogComponent},
  {path: 'user/user', component:UserComponent},
  // {path: '**', component: NotFoundComponent},
  {path: 'user/order/:id', component: OrderComponent},
  {path: 'user/orderall', component: OrderAllComponent}
 ];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    HomeModule,
    MenuModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
