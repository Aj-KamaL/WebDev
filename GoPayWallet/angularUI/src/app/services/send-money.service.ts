import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class SendMoneyService {

  constructor(private httpClient: HttpClient, private loginService: LoginService) { }

  sendMoney(data){
    var userId = this.loginService.getUserId();
    var amount = data['amount'];
    var currency = data['currency'];
    var token = this.loginService.getToken();
    return this.httpClient.put(`http://localhost:8765/wallet/api/v1/transaction/debit?userId=${userId}&amount=${amount}&currency=${currency}`,{
      headers: new HttpHeaders().set('Authorization',`Bearer ${token}`)
    });
  }

  exchangeRate(first, second):Observable<any>{
    return this.httpClient.get(`https://api.exchangeratesapi.io/latest?base=${first}`);
  }
}
