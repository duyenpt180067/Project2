import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodService } from '../services/food.service';
import { LazyLoadScriptService } from '../services/lazy-load-script.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-food-detail',
  templateUrl: './food-detail.component.html',
  styleUrls: ['./food-detail.component.css']
})
export class FoodDetailComponent implements OnInit {

  _like: boolean = false;
  listFD: any;
  food: any;
  quantity: number = 1;
  foodDetailImage: any;
  price1: any; price1Sale: any;
  price2: any; price2Sale: any;
  listFoodRelated: any;
  check: boolean = true;
  listComment: any;
  sizeofcomment: any;
  formComment: FormGroup;
  formAdd: FormGroup;
  size: any;
  sendItem: any;
  changePage: boolean = false;
  fdtosend: any;
  priceSend: any;
  check2: any;
  price: any;
  priceSale: any;
  comment: string;
  star: any = 0;
  checkSize: any;

  checked_5: boolean;
  checked_4: boolean;
  checked_3: boolean;
  checked_2: boolean;
  checked_1: boolean;

  constructor(private userService: UserService, private route: ActivatedRoute, private router: Router, private fb: FormBuilder, private lazyService: LazyLoadScriptService, private routes: ActivatedRoute, private foodService: FoodService) { }

  ngOnInit(): void {
    this.lazyService.loadScript('/assets/js/star.js').subscribe(_ => {
      console.log('Jquery is loaded!')
    });
    this.formComment = this.fb.group({
      rating: ['', [Validators.required]],
      content: ['', [Validators.required, Validators.minLength(6)]],
    })
    this.formAdd = this.fb.group({
      size: ['', Validators.required],
      quan: [''],
      like: ['']
    })

    // console.log(this.formAdd.value);
    this.routes.params.subscribe(p => {
      let id = p.id;
      this.foodService.getComment().subscribe((res: any[]) => {
        this.listComment = res.filter(x => (x.food?.foodId == id));
        this.sizeofcomment = this.listComment.length;
        for (let i = 0; i < this.listComment.length; i++) {
          for (let j = 0; j < this.listComment[i].rating.length; j++) {
            document.getElementById(j.toString()).style.color = "#ffc222";

          }
        }
        console.log(this.listComment);
      })
      this.foodService.findFoodById(id).subscribe((res: any) => {
        this.food = res;
        console.log(this.food.imageURL);

        this.foodService.getAllfd().subscribe((res: any[]) => {
          this.listFD = res.filter(x => x.food.foodId == id);
          this.size = this.listFD[0].size.sizeName;

          this.sendItem = {
            foodSend: this.food,
            sizeFood: this.size,
            amount: this.quantity,
          }
          console.log(this.sendItem);
          console.log(this.sendItem.foodSend.foodId)
          if (this.listFD[0].size.sizeName == "Free Size") {
            this.checkSize = true;
            this.check = true;
            this.price = this.listFD[0].price;
            this.priceSale = this.listFD[0].price * (100 - this.listFD[0].food.discount) / 100;
          } else {
            this.checkSize = false;
            this.price1 = this.listFD[0].price;
            this.price1Sale = this.listFD[0].price * (100 - this.listFD[0].food.discount) / 100;
            this.price2 = this.listFD[this.listFD.length - 1].price;
            this.price2Sale = this.listFD[this.listFD.length - 1].price * (100 - this.listFD[this.listFD.length - 1].food.discount) / 100;
            console.log(this.listFD);
          }

        })
      })
      this.foodService.getImage().subscribe((res: any[]) => {
        this.foodDetailImage = res.filter(x => x.food.foodId == id)[0];
        console.log(this.foodDetailImage);
      })
      this.foodService.getFood().subscribe((res: any[]) => {
        console.log(this.food);
        this.listFoodRelated = res.filter(x => (x.food.catalog.caId == this.food?.catalog?.caId) && (x.food.foodId != this.food.foodId));

      })
    })
  }

  Minus() {
    this.quantity -= 1;
    if (this.quantity <= 1) {
      this.quantity = 1;
    }
  }
  Plus() {
    this.quantity += 1;
  }
  check_like() {
    this._like = !this._like;
  }
  des() {
    this.check = true;
  }
  com() {
    this.check = false;
  }
  addCart(sendItem: any) {
    this.routes.params.subscribe(p => {
      let id = p.id;
      this.foodService.getAllfd().subscribe((res: any[]) => {
        //this.fdtosend = res.filter(x => x.size.sizeName == sendItem.sizeFood)[0];
        this.fdtosend = res.filter(x => (x.food.foodId == id) && (x.size.sizeName == sendItem.sizeFood))[0];
        console.log(this.fdtosend);
        sendItem = {
          foodSend: this.fdtosend,
          sizeFood: this.size,
          amount: this.quantity,
          price: this.priceSend
        }
        console.log(sendItem);
        if (sendItem.sizeFood == null) {
          this.changePage = false;
          alert("You must choose a size first!");

        }
        else {
          this.changePage = true;
          localStorage.setItem(sendItem.foodSend.fdId, JSON.stringify(sendItem));
          this.router.navigate(['/user/cart'], { relativeTo: this.route });
          console.log("done")
          
        }
      })
    })
  }
  getFoodSend(sendItem: any) {
    sendItem = {
      foodSend: this.food,
      sizeFood: this.size,
      amount: this.quantity,
    }
    console.log(sendItem);
    this.routes.params.subscribe(p => {
      let id = p.id;
      this.foodService.getAllfd().subscribe((res: any[]) => {
        this.fdtosend = res.filter(x => (x.food.foodId == id) && (x.size.sizeName == sendItem.sizeFood))[0];
        console.log(this.fdtosend);
        this.priceSend = sendItem.amount * this.fdtosend.price * (100 - this.fdtosend.food.discount) / 100;
        console.log(this.priceSend);
      })
    })
  }
  discount(item: any): boolean {
    if (item != 0) {
      return true;
    }
    else return false;
  }
  addToCart(food: any) {
    if (food.food != null) {
      const sendItem = {
        foodSend: food,
        sizeFood: food.size.sizeName,
        amount: 1,
        price: food.price
      }
      localStorage.setItem(sendItem.foodSend.fdId, JSON.stringify(sendItem));
      this.router.navigate(['/user/cart'], { relativeTo: this.route });
      console.log("done")
    } else {
      this.foodService.getAllfd().subscribe((res: any[]) => {
        var foodDeal = res.filter(x => x.fdId == food.foodDetail.fdId)[0];
        console.log(foodDeal);
        const sendItem = {
          foodSend: foodDeal,
          sizeFood: foodDeal.size.sizeName,
          amount: 1,
          price: foodDeal.price
        }
        localStorage.setItem(sendItem.foodSend.fdId, JSON.stringify(sendItem));
        this.router.navigate(['/user/cart'], { relativeTo: this.route });
        console.log("done")
      })

    }
  }
  send(event: any) {
    this.star = event;
  }
  addComment() {
    var today = new Date();
    if (this.star == 0) {
      alert("Please point your rating!");
    } else {
      console.log(this.comment);
      if (this.comment == null) {
        alert("Please write your comment!");
      } else {
        this.userService.getAll().subscribe((res: any[]) => {
          const commentAdd = {
            user: res.filter(x => x.userName == localStorage.getItem("key"))[0],
            food: this.sendItem.foodSend,
            content: this.comment,
            commentStatus: true,
            created: today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate(),
            parentId: 0,
            rating: this.star
          }
          this.foodService.addComment(commentAdd).subscribe(res => {
            console.log(res);
          })
          console.log(commentAdd);
        })
      }
    }
  }

}
