import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  formLogin : FormGroup;


  constructor( private fb: FormBuilder, private userService: UserService, private router : Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.formLogin = this.fb.group({
      userName: ['', [Validators.required]],
      pass: ['',[ Validators.required, Validators.minLength(6)]]
    })
  }

  submitLogin(){
    if(this.formLogin.invalid){
      this.validateForms(this.formLogin)
    }else{
      const user = this.formLogin.value;
      this.userService.getAll().subscribe((res: any[]) => {
        const userGet = res.filter(x =>( x.userName == user.userName && x.pass == user.pass));
        console.log(userGet);
        localStorage.setItem("key", user.userName);
        if(userGet.length > 0){
          this.router.navigate(['/user/home'], {relativeTo: this.route});
        }else{
          alert('Tên tài khoản hoặc mật khẩu không đúng!')
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
