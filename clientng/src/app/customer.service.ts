import { Injectable } from '@angular/core';
import { CustomerDTO } from './customer/dto/CustomerDTO';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  //constructor(private httpClient: HttpClient) { }

  private customer_endpoint = 'http://localhost:8080/api/v2/customers/'

  save(customer: CustomerDTO): CustomerDTO {
    console.log("in service save")
     const data = {
       "name": customer==undefined? "default name": customer.name,
       "birthDate": customer==undefined? new Date():  customer.birthDate
     };
     console.log("date: "+data.birthDate)
     console.log("name: "+data.name)
     axios
       .post(this.customer_endpoint, data, {
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
       return customer==undefined? new CustomerDTO("default names",new Date()) : customer
   }
}
