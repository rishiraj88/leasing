import { Component, EventEmitter, Output } from '@angular/core';
import { CustomerDTO } from '../customer/dto/CustomerDTO';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-customer-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './customer-form.component.html',
  styleUrl: './customer-form.component.css'
})
export class CustomerFormComponent {
  //default values added for quick review post app installation
  name: string = 'Alex'
  birthDate: Date = new Date("12.12.2010"); //12 Dec 2010

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
