import { Component, Input } from '@angular/core';
import { ContractDTO } from './dto/ContractDTO';
import { ContractService } from '../contract.service';
import { LeaseContractFormComponent } from '../lease-contract-form/lease-contract-form.component';
import { VehicleService } from '../vehicle.service';

@Component({
  selector: 'app-lease-contract',
  standalone: true,
  imports: [LeaseContractFormComponent],
  templateUrl: './lease-contract.component.html',
  styleUrl: './lease-contract.component.css',
  providers:[VehicleService]
})
export class LeaseContractComponent {
   @Input()
    private contractDTO?: ContractDTO
  
    constructor(private _contractService: ContractService) { }
  
    save($eventDTO: ContractDTO) {
      console.log("contractpage:: contractDtoEvent: ")
      console.log($eventDTO)
      if ($eventDTO)
        this.contractDTO = this._contractService.save($eventDTO)
  }
}
