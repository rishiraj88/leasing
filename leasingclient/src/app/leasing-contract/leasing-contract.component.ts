import { Component, OnInit } from '@angular/core';
import { LeasingContractDTO } from './dto/LeasingContractDTO';
import { LeasingContractService } from './leasing-contract.service';

@Component({
  selector: 'app-leasing-contract',
  templateUrl: './leasing-contract.component.html',
  styleUrls: ['./leasing-contract.component.css'],
  providers: [LeasingContractService]
})
export class LeasingContractComponent {
  
  private leasingContractDto?: LeasingContractDTO
  private allContracts: LeasingContractDTO[] = []
  
  public nextContractNumberSuggestion():number {return this.leasingContractService.latestContractNumber+1}

  constructor(private leasingContractService: LeasingContractService) { 
    this.leasingContractService.view()
    .subscribe((contracts) => {})
  }

  save(leasingContract: LeasingContractDTO) {
      this.leasingContractDto = this.leasingContractService.save(leasingContract)
  }

}
