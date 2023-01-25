import { Component, OnChanges, SimpleChanges } from '@angular/core';
import axios from 'axios';
import { CustomerService } from './customer.service';
import { CustomerDTO } from './dto/CustomerDTO';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css'],
  providers: [CustomerService]
})
export class CustomerComponent implements OnChanges {
  private customerDto?: CustomerDTO
  private url = 'http://localhost:8080/customer/'

  constructor(private customerService: CustomerService) {}


  ngOnInit() {
    this.customerService.viewCustomer()
  }
  

  ngOnChanges(changes: SimpleChanges) {
    console.log(this.customerDto + " in ngOnChanges")
  }

  save(customer: CustomerDTO) {
   console.log("in save")

    const data = {
      "firstName": customer.firstName,
      "lastName": customer.lastName,
      "birthDate": customer.birthDate
    };
    console.log("date: "+data.birthDate)
    axios
      .post(this.url, data, {
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json;charset=UTF-8",
          'Access-Control-Allow-Credentials': 'false'
        },
      })
      .then(({ data }) => {
        console.log("Request to save customer details has been completed.")
        this.customerDto = customer

      }).catch(({ err }) => {
        console.log("Error occured while saving customer details.")
        console.log(`Error is: ${err}`)
      });
  }

}
