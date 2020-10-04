import { Component, OnInit } from '@angular/core';
import { LoginService } from '../services/login.service';
import { LogoutService } from '../services/logout.service';
import { RouterService } from '../services/router.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  userName: string;
  constructor(private routerService: RouterService, private logoutService: LogoutService, private loginService: LoginService) { }

  ngOnInit() {
    this.userName = this.loginService.getName();
  }

  addMoney(){
    console.log("add money card clicked");
    this.routerService.routeToAddMoney();

  }
  history(){
    console.log("pay history is clicked");
    this.routerService.routeToTransactionHistory();
  }
  balance(){
    console.log("wallet balance is clicked");
    this.routerService.routeToWalletBalance();
  }
  sendMoney(){
    console.log("send Money is clicked");
    this.routerService.routeToSendMoney();
  }
  logout(){
    this.logoutService.logoutUser();
    this.routerService.routeToHome();
  }

}
