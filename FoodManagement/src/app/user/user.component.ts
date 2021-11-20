import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CartService } from '../services/cart.service';
import { FoodService } from '../services/food.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  userForm: FormGroup;
  listOrder: any;
  userName: any;
  address: any;
  phone: any;
  user: any;

  constructor(private fb : FormBuilder ,private cartService: CartService, private foodService: FoodService, private userService: UserService) { }

  ngOnInit(): void {
    this.userForm = this.fb.group({
      username: [''],
      addresses: [],
      phoneNumber: []
    })

    this.cartService.getAllOrderDetail().subscribe((res:any[])=>{
      this.listOrder = res.filter(x=>x.order?.user?.userName==localStorage.getItem("key"));
    })
    this.userService.getAll().subscribe((res: any[])=>{
      this.user = res.filter(x=>x.userName == localStorage.getItem("key"))[0];
      this.userName = this.user.userName;
      this.address = this.user.addresses;
      this.phone = this.user.phone;
      console.log(this.user)
    })
  }
  changeProfile(){
    const userUpdate = {
      userName: this.userName,
      pass: this.user.pass,
      phone: this.phone,
      addresses: this.address,
      permission: this.user.permission,
      userStatus: this.user.userStatus,
      isadmin: this.user.isadmin  
    }
    console.log(JSON.stringify(userUpdate));
    
     this.userService.update(this.user.userId,userUpdate).subscribe(res =>{
       console.log(res);
     });
    localStorage.setItem("key", this.userName);
    alert("Change Profile successfully!");
  }
}
