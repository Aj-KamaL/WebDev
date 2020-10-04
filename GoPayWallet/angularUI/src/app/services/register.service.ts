import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private httpClient: HttpClient, private loginService: LoginService) { }

  registerUser(data){
    return this.httpClient.post("http://localhost:8765/userauth/api/v1/auth/register",data);
  }
  setUserId(id){
    sessionStorage.setItem("id",id);
  }
  getUserId(){
    return sessionStorage.getItem("id");
  }
  setToken(token){
    sessionStorage.setItem('token',token);
  }
  getToken(){
    return sessionStorage.getItem('token');
  }
  

  createWallet( nameOnCard, expiryDate, cvv, cardNumber ){
    var token = this.getToken();
    var userId = this.getUserId();
    console.log("in create wallet function");
    return this.httpClient.put(`http://localhost:8765/wallet/api/v1/transaction/walletUser?userId=${userId}&nameOnCard=${nameOnCard}&expiryDate=${expiryDate}&cvv=${cvv}&cardNumber=${cardNumber}`,
    {
      
        headers: new HttpHeaders().set('Authorization',`Bearer ${token}`)
     }
    );
  }
}
