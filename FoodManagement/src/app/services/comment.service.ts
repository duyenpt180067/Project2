import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http: HttpClient) { }
  add(comment:any){
    return this.http.post("http://localhost:8080/api/v1/contact/save", comment);
  }
  getAllFaq(){
    return this.http.get("http://localhost:8080/api/v1/faq/findAllFaq");
  }
  getAllBlog(){
    return this.http.get("http://localhost:8080/api/v1/blog/findAllBlog");
  }
}
