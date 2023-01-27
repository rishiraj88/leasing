import { Component, EventEmitter, Input, Output } from '@angular/core';
import { LeasingContractDTO } from '../dto/LeasingContractDTO';
import { LeasingContractService } from '../leasing-contract.service';

@Component({
  selector: 'app-leasing-contract-form',
  templateUrl: './leasing-contract-form.component.html',
  styleUrls: ['./leasing-contract-form.component.css']
})
export class LeasingContractFormComponent {
  @Input()
  contractNumber: number = -1
  monthlyRate: number = -1
  customerName: string = ''
  vehicleDetails: string = ''

  saveEditLabel: string = 'Save'

  @Output()
  leasingContractDtoEvent: EventEmitter<LeasingContractDTO> = new EventEmitter<LeasingContractDTO>();

  save() {
    console.log(this.contractNumber)
    console.log(this.monthlyRate)
    console.log(this.customerName)
    console.log(this.vehicleDetails)
    let leasingContractDTO = new LeasingContractDTO(this.contractNumber, this.monthlyRate, this.customerName, this.vehicleDetails)
    this.leasingContractDtoEvent.emit(leasingContractDTO)
    console.log(leasingContractDTO)
    this.saveEditLabel='Edit'

  }

  clear() {
    this.monthlyRate = -1
    this.customerName = ''
    this.vehicleDetails = ''
    let leasingContractDTO = new LeasingContractDTO(this.contractNumber, this.monthlyRate, this.customerName, this.vehicleDetails)
    this.leasingContractDtoEvent.emit(leasingContractDTO)
    console.log(leasingContractDTO)
    this.saveEditLabel='Save'

  }


}
