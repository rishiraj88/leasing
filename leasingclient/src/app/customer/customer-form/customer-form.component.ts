import { Component } from '@angular/core';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent {
  firstName: string = ''
  lastName: string = ''
  birthDate: Date = new Date();

  save() {
    console.log(this.firstName)
    
    console.log(this.lastName)
    
    console.log(this.birthDate)
  }

  clear() {
    this.firstName = ''
    this.lastName = ''
    this.birthDate = new Date();
    
  }
}
