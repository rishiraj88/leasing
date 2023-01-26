import { Component, EventEmitter, Output } from '@angular/core';
import { LeasingContractDTO } from '../dto/LeasingContractDTO';

@Component({
  selector: 'app-leasing-contract-form',
  templateUrl: './leasing-contract-form.component.html',
  styleUrls: ['./leasing-contract-form.component.css']
})
export class LeasingContractFormComponent {
//default values only for quick review post app installation
  contractNo: number = 1234567//0
  mRate: number = 350.00//-1
  customer: string = 'Alex Doe'
  vehicle: string = 'BMW X3 2022'//VIN unavailable //'BMW X3 (2022) VIN: X123456'//''

  @Output()
  leasingContractDtoEvent: EventEmitter<LeasingContractDTO> = new EventEmitter<LeasingContractDTO>();

  save() {
    console.log(this.contractNo)
    console.log(this.mRate)
    console.log(this.customer)
    console.log(this.vehicle)
    let leasingContractDTO = new LeasingContractDTO(this.contractNo, this.mRate, this.customer, this.vehicle)
    this.leasingContractDtoEvent.emit(leasingContractDTO)
    console.log(leasingContractDTO)
  }

  clear() {
    this. contractNo = 0
    this.mRate= -1
    this.customer = ''
    this.vehicle = ''
    let leasingContractDTO = new LeasingContractDTO(this.contractNo, this.mRate, this.customer, this.vehicle)
    this.leasingContractDtoEvent.emit(leasingContractDTO)
    console.log(leasingContractDTO)
  }


}
