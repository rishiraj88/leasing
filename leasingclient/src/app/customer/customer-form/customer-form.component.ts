import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CustomerDTO } from '../dto/CustomerDTO';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent {
  firstName: string = ''
  lastName: string = ''
  birthDate: Date = new Date();

  @Output()
  customerDtoEvent: EventEmitter<CustomerDTO> = new EventEmitter<CustomerDTO>();

  save() {
    console.log(this.firstName)
    console.log(this.lastName)
    console.log(this.birthDate)
    let customerDTO = new CustomerDTO(this.firstName, this.lastName, this.birthDate)
    this.customerDtoEvent.emit(customerDTO)
    console.log(customerDTO)
  }

  clear() {
    this.firstName = ''
    this.lastName = ''
    this.birthDate = new Date();

  }
}
