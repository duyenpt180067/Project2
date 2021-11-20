import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  formRegister: FormGroup;

  constructor(private fb: FormBuilder, private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getAll().subscribe((res: any[]) =>{
      console.log(res);
    })
    this.formRegister = this.fb.group({
      userName:['', Validators.required],
      phone:['',Validators.required],
      addresses:['',Validators.required],
      pass:['',[Validators.required, Validators.minLength(6)]],
      rePass:['',[Validators.required, Validators.minLength(6)]],
      userStatus:"active",
      isAdmin: false,
      permission: false
    })
  }
  register(){
    
    if(this.formRegister.invalid){
      this.validateForms(this.formRegister);
    }else {
      const user = this.formRegister.value;
      console.log(user)
      this.userService.getAll().subscribe((res: any[]) =>{
        const findUser = res.filter(x => x.userName == user.userName)[0];
        console.log(findUser);
        
        if(findUser == undefined){
          const resUser = {
            userName: user.userName,
            pass: user.pass,
            phone: user.phone,
            addresses: user.addresses,
            permission: false,
            userStatus: "active",
            isadmin: false
          }
          console.log(resUser);
          this.userService.add(resUser).subscribe(res => {
            alert("Register account successfully!");
          })
        }else{
          alert("This userName is already exists!");
        }
      })
      
    }
  }
  validateForms(fg: FormGroup){
    Object.keys(fg.controls).forEach(field => {
      const control = fg.get(field);
      if (control instanceof FormControl) {
        control.markAllAsTouched();
      } else if (control instanceof FormGroup){
        control.markAllAsTouched();
        this.validateForms(control);
      }
    })
  }

}
