import { NgModule } from '@angular/core';
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
    LeasingContractFormComponent
  ],
  imports: [
    BrowserModule,FormsModule, RouterModule.forRoot(appRoute), HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
