import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CustomerDTO } from './dto/CustomerDTO';
import { CustomerService } from '../customer.service';
import { CustomerFormComponent } from '../customer-form/customer-form.component';

@Component({
  selector: 'app-customer',
  standalone: true,
  imports: [CustomerFormComponent],
  templateUrl: './customer.component.html',
  styleUrl: './customer.component.css'
})
export class CustomerComponent {
  @Input()
  private customerDTO?: CustomerDTO
  
  private url = 'http://localhost:8080/api/v1/customers/'

  constructor(private customerService: CustomerService) { }

  save(name:string, birthDate:Date) {
    //customer: CustomerDTO = {name, birthDate}

    this.customerDTO = this.customerService.save(this.customerDTO)
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
