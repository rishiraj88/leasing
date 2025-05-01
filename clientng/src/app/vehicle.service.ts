import { Injectable } from '@angular/core';
import { VehicleDTO } from './vehicle/dto/VehicleDTO';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  constructor() { }
  private vehicle_endpoint = 'http://localhost:8080/api/v2/vehicles'

  save(vehicle: VehicleDTO): VehicleDTO {
    console.log("in service save")
     const data = {
       "brand": vehicle.brand,
       "model": vehicle.model,
       "myear": vehicle.year,
       "vin": vehicle.vin,
       "price": vehicle.price
     };
     console.log("brand: "+data.brand)
     console.log("model: "+data.model)
     console.log("make year: "+data.myear)
     console.log("vin: "+data.vin)
     console.log("price: "+data.price)
     axios
       .post(this.vehicle_endpoint, data, {
         headers: {
           Accept: "application/json",
           "Content-Type": "application/json;charset=UTF-8",
           'Access-Control-Allow-Credentials': 'false'
         },
       })
       .then(({ data }) => {
         console.log("Request to save vehicle details has been completed.")
       }).catch(({ err }) => {
         console.log("Error occured while saving vehicle details.")
         console.log(`Error is: ${err}`)
       });
       return vehicle
   }
}
