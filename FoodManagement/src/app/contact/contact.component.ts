import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { CommentService } from '../services/comment.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  formContact: FormGroup

  constructor(private fb: FormBuilder, private commentService: CommentService) { }

  ngOnInit(): void {
    this.formContact = this.fb.group({
      name: ['', Validators.required],
      email:['', [Validators.required, Validators.email]],
      subject:[''],
      qContent:['', Validators.required],
      qStatus: false
    })
  }

  send(){
    if(this.formContact.invalid){
      this.validateForms(this.formContact);
    }else{
      const user = this.formContact.value;
      this.commentService.add(user).subscribe(res =>{
        console.log(user);
      });
      alert("Your question has been submitted");
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
