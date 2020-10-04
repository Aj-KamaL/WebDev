import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(private httpClient: HttpClient, private loginService: LoginService) { }

  getTransactionHistory(userId):Observable<any>{
    var token = this.loginService.getToken();
    return this.httpClient.get(`http://localhost:8765/wallet/api/v1/transaction/all?userId=${userId}`,{
      headers: new HttpHeaders().set('Authorization',`Bearer ${token}`)
    });
  }
}
