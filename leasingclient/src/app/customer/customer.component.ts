import { Component } from '@angular/core';
import { CustomerService } from './customer.service';
import { CustomerDTO } from './dto/CustomerDTO';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css'],
  providers: [CustomerService]
})
export class CustomerComponent  {
  private customerDTO?: CustomerDTO
  private url = 'http://localhost:8080/customer/'

  constructor(private customerService: CustomerService) { }

  save(customer: CustomerDTO) {
    this.customerDTO = this.customerService.save(customer)
  }

}
