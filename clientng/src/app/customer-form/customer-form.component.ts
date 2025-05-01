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

  public customerDTO: CustomerDTO = new CustomerDTO("null",new Date())
  public saveEditLabel: string = 'Save'

  //default values added
  // for quick review
  // post app installation
  name: string = 'Alex'
  birthDate: Date = new Date("03.03.2010");

  @Output()
  customerDtoEvent: EventEmitter<CustomerDTO> = new EventEmitter<CustomerDTO>();

  public save() {
    console.log("form:: name: "+this.customerDTO.name)
    console.log("form:: dob: "+this.customerDTO.birthDate)
    this.customerDTO = new CustomerDTO(this.name, this.birthDate)
    console.log("form:: dto: "+this.customerDTO)
    this.saveEditLabel= 'Edit'
    this.customerDtoEvent.emit(this.customerDTO)
  }

  public clear() {
    this.name = ''
    this.birthDate = new Date();
    this.saveEditLabel = 'Save'
  }
}
