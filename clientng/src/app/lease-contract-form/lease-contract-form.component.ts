import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ContractDTO } from '../lease-contract/dto/ContractDTO';

@Component({
  selector: 'app-lease-contract-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './lease-contract-form.component.html',
  styleUrl: './lease-contract-form.component.css'
})
export class LeaseContractFormComponent {

    public contractDTO: ContractDTO = new ContractDTO("null",102.33,"null","null",new Date("1999-09-09"),new Date("1989-01-09"))
  
    public saveEditLabel: string = 'Save'
    
    //default values added
    // for quick review
    // post app installation
    contractNumber: string = 'OM0001'
    monthlyRate: number = 123.33
    vehicleIN: string = 'DEMK890E'
    customerName: string = "Alex"
    leaseStartsAt: Date = new Date("1980-10-10")
    leaseExpiresAt: Date = new Date("1980-03-03")
  
  @Output()
  contractDTOEvent: EventEmitter<ContractDTO> = new EventEmitter<ContractDTO>();
    
      public save() {
        console.log("form:: brand: "+this.contractDTO.contractNumber)
        console.log("form:: model: "+this.contractDTO.monthlyRate)
        console.log("form:: myear: "+this.contractDTO.vehicleIN)
        console.log("form:: vin: "+this.contractDTO.customerName)
        console.log("form:: price: "+this.contractDTO.leaseStartsAt)
        console.log("form:: price: "+this.contractDTO.leaseExpiresAt)
        this.contractDTO = new ContractDTO(this.contractNumber,this.monthlyRate,this.vehicleIN,this.customerName,
          this.leaseStartsAt,this.leaseExpiresAt)
        console.log("form:: dto: "+this.contractDTO)
          this.saveEditLabel= 'Edit'
        this.contractDTOEvent.emit(this.contractDTO)
      }
    public clear() {
      this.contractNumber=""
      this.monthlyRate=0
      this.vehicleIN=""
      this.customerName=""
      this.leaseStartsAt=new Date("1999-02-02")
      this.leaseExpiresAt=new Date("1999-01-01");
      this.saveEditLabel = 'Save'
    }
}
