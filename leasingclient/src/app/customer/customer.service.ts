import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import axios from "axios";
import { throwError } from "rxjs/internal/observable/throwError";
import { catchError } from "rxjs/internal/operators/catchError";
import { map } from "rxjs/internal/operators/map";
import { CustomerDTO } from "./dto/CustomerDTO";

@Injectable()
export class CustomerService {
  constructor(private httpClient: HttpClient) { }

  private url = 'http://localhost:8080/customer/'

  view() {
    return this.httpClient
      .get<CustomerResponse>(this.url, { withCredentials: false })
      .pipe(
        catchError((error) =>
          throwError(() => console.log("error: " + error))
        ),
        map((res) => {
          console.log("response: " + res.item)
          return res.item
        }));
  }

  save(customer: CustomerDTO): CustomerDTO {
    console.log("in service save")
     const data = {
       "name": customer.name,
       "birthDate": customer.birthDate
     };
     console.log("date: "+data.birthDate)
     console.log("name: "+data.name)
     axios
       .post(this.url, data, {
         headers: {
           Accept: "application/json",
           "Content-Type": "application/json;charset=UTF-8",
           'Access-Control-Allow-Credentials': 'false'
         },
       })
       .then(({ data }) => {
         console.log("Request to save customer details has been fulfilled.")
       }).catch(({ err }) => {
         console.log("Error occured while saving customer details.")
         console.log(`Error is: ${err}`)
       });
       return customer
   }
 
}

interface CustomerResponse extends Response {
  item: CustomerDTO;
}
