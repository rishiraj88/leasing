import { Component } from '@angular/core';
import axios from 'axios';
import { CustomerDTO } from './dto/CustomerDTO';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent {

  save(customerDto: CustomerDTO) {
    console.log(customerDto)

    const url = 'http://localhost:8080/customer/'
    const data = {
      "firstName":"Pukar",
      "lastName":"Thakur",
      "birthDate":"06.06.2021"
    };
    axios
      .post(url, data, {
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json;charset=UTF-8",
          'Access-Control-Allow-Credentials':'false'

        },
      })
      .then(({ data }) => {
        console.log("Request to save customer details has been completed.")
      }).catch(({err}) => {
        console.log("Error occured while saving customer details.")
      });
  }

}
