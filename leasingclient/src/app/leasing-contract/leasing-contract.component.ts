import { Component } from '@angular/core';
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

  constructor(private LeasingContractService: LeasingContractService) { }

  save(leasingContract: LeasingContractDTO) {
      this.leasingContractDto = this.LeasingContractService.save(leasingContract)
  }


}
