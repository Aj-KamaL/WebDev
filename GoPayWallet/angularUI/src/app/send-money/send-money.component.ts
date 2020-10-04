import { Component, OnInit, OnChanges } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { User } from '../classes/user';
import { AddMoneyService } from '../services/add-money.service';
import { LoginService } from '../services/login.service';
import { SendMoneyService } from '../services/send-money.service';

@Component({
  selector: 'app-send-money',
  templateUrl: './send-money.component.html',
  styleUrls: ['./send-money.component.css']
})
export class SendMoneyComponent implements OnInit {

  sendIn: string;
  recieveIn: string;
  amountSend: number;
  amount = new FormControl('');
  currency = new FormControl('');
  sendMoneyForm: FormGroup;
  recievedIn = new FormControl('');
  exchangeRate = 0;
  msg: string;
  contacts: User[];
  userToSend= new FormControl('');
  userName: string;
  amountTheyRecieve= new FormControl('');
  constructor(private fromBuilder: FormBuilder, private sendMoneyService: SendMoneyService, private loginService: LoginService,
              private addMoney: AddMoneyService) { }

  ngOnInit() {
    this.userName = this.loginService.getName();
    this.sendMoneyForm = this.fromBuilder.group({
      amount: this.amount,
      currency: this.currency
    });

    this.loginService.getAllUsers().subscribe(
      data=>{
        console.log(data);
        this.contacts = data;
      },
      error=>{
        console.log(error);
      }
    );
  }

  ngOnChanges(){
    console.log("something is changed");
    this.loginService.getAllUsers().subscribe(
      data=>{
        console.log(data);
      },
      error=>{
        console.log(error);
      }
    );
  }

  sendMoney(){
    if(this.userToSend.value == this.loginService.getUserId()){
      this.msg = "Cannot send to self";
    }
    else{
    console.log("user id to be send is "+this.userToSend.value);
    console.log("amount to send is: "+(this.exchangeRate*this.amount.value));
    var sendData = {
      "userId": this.userToSend.value,
      "amount": this.exchangeRate*this.amount.value,
      "currency": this.recieveIn
    }
    this.addMoney.addMoneyToWallet(sendData).subscribe(
      data=>{
        this.sendMoneyService.sendMoney(this.sendMoneyForm.value).subscribe(
          data=>{
            console.log("debited");
            this.msg = "Money is successfully transferred!";
          },
          error=>{
            console.log(error);
            if(error.status=='404'){
              this.msg="Insufficient funds in your wallet!";
            }
            else{
              this.msg = "Some error occured, please try after some time!";
            }
            
          }
        );
      },
      error=>{

      }
    );
    }
  }

  findExchangeRate(){
    console.log(this.sendIn);
    console.log(this.recievedIn.value);
    this.sendMoneyService.exchangeRate(this.sendIn, this.recievedIn.value).subscribe(
      data=>{
        console.log(data);

        if(this.recievedIn.value == "INR"){
          this.exchangeRate = data.rates['INR'];
        }
        if(this.recievedIn.value == "USD"){
          this.exchangeRate = data.rates['USD'];
        }
        if(this.recievedIn.value == "CHF"){
          this.exchangeRate = data.rates['CHF'];
        }
        if(this.recievedIn.value == "GBP"){
          this.exchangeRate = data.rates['GBP'];
        }
        if(this.recievedIn.value == "CAD"){
          this.exchangeRate = data.rates['CAD'];
        }
        if(this.recievedIn.value == "EUR"){
          this.exchangeRate = data.rates['EUR'];
        }
        // this.exchangeRate = data[this.recievedIn.value];
        console.log(this.exchangeRate);
      },
      error=>{
        console.log(error.msg);
      }
    );
  }

}
