import { Component, EventEmitter, Output } from '@angular/core';
import { CustomerDTO } from '../dto/CustomerDTO';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent {
  //default values added for quick review post app installation
  name: string = 'Alex'
  birthDate: Date = new Date("11.11.2005"); //11 Nov 2005

  saveEditLabel: string = 'Save'

  @Output()
  customerDtoEvent: EventEmitter<CustomerDTO> = new EventEmitter<CustomerDTO>();

  save() {
    console.log(this.name)
    console.log(this.birthDate)
    let customerDTO = new CustomerDTO(this.name, this.birthDate)
    this.customerDtoEvent.emit(customerDTO)
    console.log(customerDTO)
    this.saveEditLabel= 'Edit'
  }

  clear() {
    this.name = ''
    this.birthDate = new Date();
    this.saveEditLabel = 'Save'
  }
}
