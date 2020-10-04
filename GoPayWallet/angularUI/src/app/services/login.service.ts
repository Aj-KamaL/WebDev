import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  userId: number;
  constructor(private httpClient: HttpClient) { }

  setToken(token){
    localStorage.setItem('token',token);
  }
  getToken(){
    return localStorage.getItem('token');
  }
  isAuthenticated(){
    if(this.getToken()){
      return true;
    }
    return false;
  }
  setUserId(id){
    localStorage.setItem("userId",id);
  }
  getUserId(){
    return localStorage.getItem("userId");
  }
  setName(name){
    localStorage.setItem("userName",name);
  }
  getName(){
    return localStorage.getItem("userName");
  }

  authenticateUser(data){
    //call api for backend
    var userName = data["userName"];
    var userPassword = data["userPassword"];
    // return this.httpClient.post(`http://localhost:8085/api/v1/auth/login?userName=${userName}&userPassword=${userPassword}`,data);
    return this.httpClient.post(`http://localhost:8765/userauth/api/v1/auth/login?userName=${userName}&userPassword=${userPassword}`,data);
  }

  getAllUsers(): Observable<any>{
    return this.httpClient.get("http://localhost:8765/userauth/api/v1/auth/userContacts");
  }
}
