import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { AddMoneyService } from '../services/add-money.service';
import { RegisterService } from '../services/register.service';

@Component({
  selector: 'app-add-money',
  templateUrl: './add-money.component.html',
  styleUrls: ['./add-money.component.css']
})
export class AddMoneyComponent implements OnInit {

  currency = new FormControl('');
  amount = new FormControl('');
  addMoneyForm: FormGroup;
  msg: string;
  constructor(private formBuilder: FormBuilder, private addMoneyService: AddMoneyService, private registerService: RegisterService) { }

  ngOnInit() {
    this.addMoneyForm = this.formBuilder.group({
      amount: this.amount,
      currency: this.currency
    })
  }

  addMoney(){
    console.log(this.addMoneyForm.value);
    this.addMoneyService.addMoneyToWallet(this.addMoneyForm.value).subscribe(
      data=>{
        console.log(data);
        this.msg ="Money Successfully added to your wallet!";
        

      },
      error=>{
        console.log(error);
        this.msg = "Some error occured, Try After Some Time!";
      }
    );
  }

}
