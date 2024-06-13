import { Component, EventEmitter, Output } from '@angular/core';
import { CustomerDTO } from './dto/CustomerDTO';

@Component({
  selector: 'app-customer',
  standalone: true,
  imports: [],
  templateUrl: './customer.component.html',
  styleUrl: './customer.component.css'
})
export class CustomerComponent {
  private customerDTO?: CustomerDTO
  private url = 'http://localhost:8080/customer/'

  constructor(private customerService: CustomerService) { }

  save(customer: CustomerDTO) {
    this.customerDTO = this.customerService.save(customer)
  }

  //default values added for quick review post app installation
  name: string = 'Alex'
  birthDate: Date = new Date("11.11.2005"); //11 Nov 2005

  saveEditLabel: string = 'Save'

  @Output()
  customerDtoEvent: EventEmitter<CustomerDTO> = new EventEmitter<CustomerDTO>();

  prepareCustomerDTO() {
    console.log(this.name)
    console.log(this.birthDate)
    let customerDTO = new CustomerDTO(this.name, this.birthDate)
    this.customerDtoEvent.emit(customerDTO)
    console.log(customerDTO)
    this.saveEditLabel= 'Edit'
  }


}
