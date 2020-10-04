import { Component, OnInit } from '@angular/core';
import { LogoutService } from '../services/logout.service';
import { RouterService } from '../services/router.service';

@Component({
  selector: 'app-logout-header',
  templateUrl: './logout-header.component.html',
  styleUrls: ['./logout-header.component.css']
})
export class LogoutHeaderComponent implements OnInit {

  constructor(private routerService: RouterService, private logoutService: LogoutService) { }

  ngOnInit() {
  }
  logout(){
    this.logoutService.logoutUser();
    this.routerService.routeToHome();
  }
  dashboard(){
    this.routerService.routeToDashboard();
  }

}
