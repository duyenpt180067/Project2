import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  upUser: string =  "http://localhost:8080/api/v1/webUser/updateWebUser";

  constructor(private http : HttpClient ) { }

  add(user:any){
    return this.http.post("http://localhost:8080/api/v1/webUser/postWebUser", user);
  }
  getAll(){
    return this.http.get("http://localhost:8080/api/v1/webUser/findAllWebUser");
  }
  update(id, user){
    return this.http.put(this.upUser+"/"+id, user);
  }
}
