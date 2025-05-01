import { Component, Input } from '@angular/core';
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
  public customerDTO?: CustomerDTO

  constructor(private _customerService: CustomerService) { }

  //default values added
  // for quick review
  // post app installation
  name: string = 'Alex'
  birthDate: Date = new Date("11.11.2005");

  saveEditLabel: string = 'Save'

  save($eventDTO: CustomerDTO) {
    console.log("customerpage:: customerDtoEvent: ")
    console.log($eventDTO)
    if ($eventDTO)
      this.customerDTO = this._customerService.save($eventDTO)
  }
}
