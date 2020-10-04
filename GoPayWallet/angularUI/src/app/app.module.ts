import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {DashboardComponent } from './dashboard/dashboard.component';
import {MatCardModule} from '@angular/material/card';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { WalletBalanceComponent } from './wallet-balance/wallet-balance.component';
import { AddMoneyComponent } from './add-money/add-money.component';
import {MatSelectModule} from '@angular/material/select';
import { TransactionHistoryComponent } from './transaction-history/transaction-history.component';
import { SendMoneyComponent } from './send-money/send-money.component';
import { LogoutHeaderComponent } from './logout-header/logout-header.component';
// import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HeaderComponent,
    HomeComponent,
    FooterComponent,
    DashboardComponent,
    WalletBalanceComponent,
    AddMoneyComponent,
    TransactionHistoryComponent,
    SendMoneyComponent,
    LogoutHeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatSelectModule
      ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
