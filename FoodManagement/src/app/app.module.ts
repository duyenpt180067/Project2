import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule} from '@angular/common/http';
import { HomeModule } from './home/home.module';
import { MenuModule } from './menu/menu.module';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { TeamComponent } from './team/team.component';
import { BlogComponent } from './blog/blog.component';
import { ShopComponent } from './shop/shop.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FaqComponent } from './faq/faq.component';
import { FoodDetailComponent } from './food-detail/food-detail.component';
import { CartComponent } from './cart/cart.component';
import { CatalogComponent } from './catalog/catalog.component';
import { PageComponent } from './page/page.component';
import { UserComponent } from './user/user.component';
import { DealComponent } from './deal/deal.component';
import { BlogDetailComponent } from './blog-detail/blog-detail.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { HistoryComponent } from './history/history.component';
import { OrderComponent } from './order/order.component';
import { OrderAllComponent } from './order-all/order-all.component';

@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    ContactComponent,
    TeamComponent,
    BlogComponent,
    ShopComponent,
    LoginComponent,
    RegisterComponent,
    FaqComponent,
    FoodDetailComponent,
    CartComponent,
    CatalogComponent,
    PageComponent,
    UserComponent,
    DealComponent,
    BlogDetailComponent,
    NotFoundComponent,
    HistoryComponent,
    OrderComponent,
    OrderAllComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    HttpClientModule,
    HomeModule,
    MenuModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
