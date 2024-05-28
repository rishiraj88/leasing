import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import axios from "axios";
import { throwError } from "rxjs/internal/observable/throwError";
import { catchError } from "rxjs/internal/operators/catchError";
import { map } from "rxjs/internal/operators/map";
import { VehicleDTO } from "./dto/VehicleDTO";

@Injectable()
export class VehicleService {
  constructor(private httpClient: HttpClient) { }

  private url = 'http://localhost:8080/vehicle/'

  view() {
    return this.httpClient
      .get<VehicleResponse>(this.url, { withCredentials: false })
      .pipe(
        catchError((error) =>
          throwError(() => console.log("error: " + error))
        ),
        map((res) => {
          console.log("response: " + res.item)
          return res.item
        }));
  }

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
     console.log("year: "+data.myear)
     console.log("vin: "+data.vin)
     console.log("price: "+data.price)
     axios
       .post(this.url, data, {
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

interface VehicleResponse extends Response {
  item: VehicleDTO;
}
