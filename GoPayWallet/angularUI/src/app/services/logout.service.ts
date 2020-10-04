import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LogoutService {

  constructor() { }
  logoutUser(){
    sessionStorage.clear();
    localStorage.clear();
  }
}
