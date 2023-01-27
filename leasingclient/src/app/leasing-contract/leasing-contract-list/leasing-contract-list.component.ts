import { Component, OnInit, Output } from '@angular/core';
import { LeasingContractDTO } from '../dto/LeasingContractDTO';
import { LeasingContractService } from '../leasing-contract.service';

@Component({
  selector: 'app-leasing-contract-list',
  templateUrl: './leasing-contract-list.component.html',
  styleUrls: ['./leasing-contract-list.component.css']
})
export class LeasingContractListComponent implements OnInit{
  @Output()
  allContracts: LeasingContractDTO[] =[]
  
  constructor(private leasingContractService: LeasingContractService){
  }
  
  ngOnInit() {
    this.allContracts = this.leasingContractService.allContracts
  }

}
