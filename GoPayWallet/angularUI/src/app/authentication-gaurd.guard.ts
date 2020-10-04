import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from './services/login.service';
import { RouterService } from './services/router.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationGaurdGuard implements CanActivate {
  constructor(private loginService: LoginService, private routerService: RouterService){}
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if(this.loginService.isAuthenticated()){
      return true;
    }
    else{
      this.routerService.routeToLogin();
    }
  }
  
}
