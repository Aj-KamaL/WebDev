import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RouterService {

  constructor(private router: Router) { }
  routeToLogin(){
    this.router.navigate(['/login']);
  }
  routeToRegister(){
    this.router.navigate(['/register']);
  }
  routeToDashboard(){
    this.router.navigate(['/dashboard']);
  }
  routeToAddMoney(){
    this.router.navigate(['/addMoney']);
  }
  routeToTransactionHistory(){
    this.router.navigate(['/history']);
  }
  routeToSendMoney(){
    this.router.navigate(['/send']);
  }
  routeToWalletBalance(){
    this.router.navigate(['/balance']);
  }
  routeToHome(){
    this.router.navigate(['/']);
  }
}
