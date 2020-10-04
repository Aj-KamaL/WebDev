import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { LoginService } from '../services/login.service';
import { RouterService } from '../services/router.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userName = new FormControl('');
  userPassword = new FormControl('');
  loginForm: FormGroup;
  constructor(private formBuilder: FormBuilder, private loginService: LoginService, private routerService: RouterService) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      userName: this.userName,
      userPassword: this.userPassword
    })
  }

  login(){
    this.loginService.authenticateUser(this.loginForm.value).subscribe(
      data => {
               console.log("in ts file of login");
              //  console.log("user id "+data[''])
              this.loginService.setUserId(data['userId']);
              this.loginService.setToken(data['token']);
              this.loginService.setName(data['userName']);
              //  this.loginService.setUsername(this.userName);
               this.routerService.routeToDashboard();
               console.log("username: "+this.loginForm.value['userName']);
               this.loginService.setName(this.loginForm.value['userName']);
             },
             error=>{
               if(error.status == 401){
                 console.log('Unauthorized');
               }
               else if(error.status == 404){
                 console.log('Http failure response for http://localhost:3000/auth/v1: 404 Not Found');
               }

           }
   );
  }
  home(){
    this.routerService.routeToHome();
  }
  register(){
    this.routerService.routeToRegister();
  }


}
