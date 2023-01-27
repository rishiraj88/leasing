import { NgModule, LOCALE_ID, DEFAULT_CURRENCY_CODE } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { CustomerComponent } from './customer/customer.component';
import { VehicleComponent } from './vehicle/vehicle.component';
import { LeasingContractComponent } from './leasing-contract/leasing-contract.component';
import { ErrorComponent } from './error/error.component';
import { CustomerFormComponent } from './customer/customer-form/customer-form.component';
import { VehicleFormComponent } from './vehicle/vehicle-form/vehicle-form.component';
import { LeasingContractFormComponent } from './leasing-contract/leasing-contract-form/leasing-contract-form.component';
import { HttpClientModule } from '@angular/common/http';
import { LeasingContractListComponent } from './leasing-contract/leasing-contract-list/leasing-contract-list.component';
import { FooterComponent } from './footer/footer.component';
import { registerLocaleData } from '@angular/common';

import localeDe from '@angular/common/locales/de'; 
registerLocaleData(localeDe);

const appRoute: Routes  =[
  {path: 'home',component:HomeComponent, pathMatch: 'full'},
  {path: 'customers',component:CustomerComponent},
  {path: 'vehicles',component:VehicleComponent},
  {path: 'lcontracts',component:LeasingContractComponent },
  {path: '',redirectTo: 'home', pathMatch: 'full'},
  {path: '**',component:ErrorComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    CustomerComponent,
    VehicleComponent,
    LeasingContractComponent,
    ErrorComponent,
    CustomerFormComponent,
    VehicleFormComponent,
    LeasingContractFormComponent,
    LeasingContractListComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,FormsModule, RouterModule.forRoot(appRoute), HttpClientModule
  ],
  providers: [
    {
      provide: LOCALE_ID,
      useValue: 'pt-BR'
     },
     {
       provide: DEFAULT_CURRENCY_CODE,
       useValue: 'BRL'
     },],
  bootstrap: [AppComponent]
})
export class AppModule { }
