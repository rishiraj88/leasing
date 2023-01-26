import { Component, EventEmitter, Output } from '@angular/core';
import { CustomerDTO } from '../dto/CustomerDTO';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent {
  //default values added for quick review post app installation
  firstName: string = 'Alex'
  lastName: string = 'Doe'
  birthDate: Date = new Date("11.11.2022"); //11 Nov 2022

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
