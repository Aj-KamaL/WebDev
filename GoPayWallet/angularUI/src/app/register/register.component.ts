import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { RegisterService } from '../services/register.service';
import { RouterService } from '../services/router.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  userName = new FormControl('');
  email = new FormControl('');
  contact = new FormControl('');
  userPassword = new FormControl('');
  userLocation = new FormControl('');
  nameOnCard = new FormControl('');
  expiryDate = new FormControl('');
  cardNumber = new FormControl('');
  cvv = new FormControl('');
  registerForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private registerService: RegisterService, private routerService: RouterService) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      userName: this.userName,
      email: this.email,
      contact: this.contact,
      userPassword: this.userPassword,
      userLocation: this.userLocation
      // nameOnCard: this.nameOnCard,
      // expiryDate: this.expiryDate,
      // cardNumber: this.cardNumber,
      // cvv: this.cvv
    })
  }
  register(){
    console.log(this.registerForm.value);
    console.log(this.nameOnCard.value);
    console.log(this.expiryDate.value);
    console.log(this.cardNumber.value);
    console.log(this.cvv.value);
    this.registerService.registerUser(this.registerForm.value).subscribe(
      data=>{
        this.registerService.setUserId(data['userId']);
        this.registerService.setToken(data['token']);
        this.registerService.createWallet(this.nameOnCard.value,this.expiryDate.value,this.cvv.value,this.cardNumber.value).subscribe(
          data=>{
            console.log("created wallet");
          },
          error=>{
            console.log("error in created wallet"+ error.msg);
          }
        );
        this.routerService.routeToLogin();
      },
      error=>{
        console.log(error.msg);
      }
    )
  }

  home(){
    this.routerService.routeToHome();
  }
  login(){
    this.routerService.routeToLogin();
  }

}
