import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class WalletBalanceService {

  constructor(private httpClient : HttpClient, private loginService : LoginService) { }

  getWalletBalance(): Observable<any>{
    var userId = this.loginService.getUserId();
    var token = this.loginService.getToken();
    return this.httpClient.get(`http://localhost:8765/wallet/api/v1/transaction/wallet?userId=${userId}`,{
      headers: new HttpHeaders().set('Authorization',`Bearer ${token}`)
    });
  }
}
