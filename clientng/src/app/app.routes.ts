import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CustomerComponent } from './customer/customer.component';
import { VehicleComponent } from './vehicle/vehicle.component';
import { LeaseContractComponent } from './lease-contract/lease-contract.component';
import { AppComponent } from './app.component';

export const routes: Routes = [
    {'path':'home','title':'Home | RRLane',component:HomeComponent},
    {'path':'customer','title':'Customer | RRLane',component:CustomerComponent},
    {'path':'vehicle','title':'Vehicle | RRLane',component:VehicleComponent},
    {'path':'contract','title':'Vehicle | RRLane',component:LeaseContractComponent},
    {'path':'',redirectTo:'/home',pathMatch:'full'},
    {'path':'**','title':'Home | RRLane',component:HomeComponent},

];
