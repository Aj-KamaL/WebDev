import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class AddMoneyService {

  constructor(private httpClient: HttpClient, private loginService: LoginService) { }

  addMoneyToWallet(data): Observable<any>{
    var userId;
    if(data['userId']!=null){
      userId = data['userId'];
    }
    else{
      userId = this.loginService.getUserId();
    }
    var amount = data["amount"];
    var token = this.loginService.getToken(); 
    var currency = data["currency"];
    console.log("userId is: "+userId);
    console.log("amount is: "+amount);
    console.log("currency is: "+currency);
    return this.httpClient.put(`http://localhost:8765/wallet/api/v1/transaction/credit?userId=${userId}&amount=${amount}&currency=${currency}`,{
      headers: new HttpHeaders().set('Authorization',`Bearer ${token}`)
    });
  }
}
