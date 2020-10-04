import { Component, OnInit } from '@angular/core';
import { Balance } from '../classes/balance';
import { WalletBalanceService } from '../services/wallet-balance.service';

@Component({
  selector: 'app-wallet-balance',
  templateUrl: './wallet-balance.component.html',
  styleUrls: ['./wallet-balance.component.css']
})
export class WalletBalanceComponent implements OnInit {

   walletBalance: Map<String,number>;
   rupee: number;
   pound: number;
   euro;
   franc;
   usd;
   cad;
  constructor(private walletService : WalletBalanceService) { }

  ngOnInit() {
    this.walletService.getWalletBalance().subscribe(
      data =>{
        this.walletBalance = data;
        // console.log(this.walletBalance);
        this.rupee = data['INR'];
        this.pound = data['GBP'];
        this.euro = data['EUR'];
        this.franc = data['CHF'];
        this.usd = data['USD'];
        this.cad = data['CAD'];
        // console.log("rupee balance in wallet "+this.rupee);
      },
      error=>{
        console.log(error);
      }
    );
  }

}
