import { Injectable } from '@angular/core';
import { CustomerDTO } from './customer/dto/CustomerDTO';
import axios from 'axios';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpClient: HttpClient) { }

  private url = 'http://localhost:8080/customer/'

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
