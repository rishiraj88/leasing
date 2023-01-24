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

const appRoute: Routes  =[
  {path: '',redirectTo: 'home', pathMatch: 'full'},
  {path: 'home',component:HomeComponent, pathMatch: 'full'},
  {path: 'customers',component:CustomerComponent},
  {path: 'vehicles',component:VehicleComponent},
  {path: 'lcontracts',component:LeasingContractComponent },
  {path: '*',component:ErrorComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    CustomerComponent,
    VehicleComponent,
    LeasingContractComponent,
    ErrorComponent
  ],
  imports: [
    BrowserModule,FormsModule, RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
