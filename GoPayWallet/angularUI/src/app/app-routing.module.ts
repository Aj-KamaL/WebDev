import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddMoneyComponent } from './add-money/add-money.component';
import { AuthenticationGaurdGuard } from './authentication-gaurd.guard';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { SendMoneyComponent } from './send-money/send-money.component';
import { TransactionHistoryComponent } from './transaction-history/transaction-history.component';
import { WalletBalanceComponent } from './wallet-balance/wallet-balance.component';


const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
    canActivate: [AuthenticationGaurdGuard]
  },
  {
    path: 'balance',
    component: WalletBalanceComponent,
    canActivate: [AuthenticationGaurdGuard]
  },
  {
    path: 'addMoney',
    component: AddMoneyComponent,
    canActivate: [AuthenticationGaurdGuard]
  },
  {
    path: 'history',
    component: TransactionHistoryComponent,
    canActivate: [AuthenticationGaurdGuard]
  },
  {
    path: 'send',
    component: SendMoneyComponent,
    canActivate: [AuthenticationGaurdGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
