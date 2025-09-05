import { Injectable } from '@angular/core';
import { VehicleDTO } from './vehicle/dto/VehicleDTO';
import axios from 'axios';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  vehicles: VehicleDTO[] =[]

  private endpoint = 'http://localhost:8080/api/v2/vehicles/'

  constructor(private httpClient: HttpClient) {}

  getVehicles(): Observable<VehicleDTO[]> {
    return this.httpClient.get<VehicleDTO[]>(`${this.endpoint}`)
  }

  addVehicle(vehicle: VehicleDTO): Observable<VehicleDTO>{
    return this.httpClient.post<VehicleDTO>(`${this.endpoint}`,vehicle)
    }

  save(vehicle: VehicleDTO): VehicleDTO {
    console.log("in vehicle.service#save")
     const data = {
       "brand": vehicle.brand,
       "model": vehicle.model,
       "makeYear": vehicle.makeYear,
       "vin": vehicle.vin,
       "price": vehicle.price
     };
     console.log("brand: "+data.brand)
     console.log("model: "+data.model)
     console.log("make year: "+data.makeYear)
     console.log("vin: "+data.vin)
     console.log("price: "+data.price)
     axios
       .post(this.endpoint, data, {
         headers: {
           Accept: "application/json",
           "Content-Type": "application/json;charset=UTF-8",
           'Access-Control-Allow-Credentials': 'false'
         },
       })
       .then(({ data }) => {
         console.log("Request to save vehicle details has been completed.")
         this.vehicles.push(vehicle)
       }).catch(({ err }) => {
         console.log("Error occured while saving vehicle details.")
         console.log(`Error is: ${err}`)
       });
       return vehicle
   }
}
