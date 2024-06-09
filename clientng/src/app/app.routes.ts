import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CustomerComponent } from './customer/customer.component';
import { VehicleComponent } from './vehicle/vehicle.component';
import { LeaseContractComponent } from './lease-contract/lease-contract.component';

export const routes: Routes = [
    {'path':'',component:HomeComponent},
    {'path':'customer',component:CustomerComponent},
    {'path':'vehicle',component:VehicleComponent},
    {'path':'contract',component:LeaseContractComponent},
    
];
