import { Injectable } from '@angular/core';
import { ContractDTO } from './lease-contract/dto/ContractDTO';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class ContractService {

  constructor() { }
  private contract_endpoint = 'http://localhost:8080/api/v2/contracts/'

  save(contract: ContractDTO): ContractDTO {
    console.log("in service save")
    //const startsAt = contract.leaseStartsAt.getFullYear()+"-"+contract.leaseStartsAt.getMonth()+"-"+contract.leaseStartsAt.getDate()
    //const expiresAt = contract.leaseExpiresAt.getFullYear()+"-"+contract.leaseExpiresAt.getMonth()+"-"+contract.leaseExpiresAt.getDate()
     
    const startsAt = contract.leaseStartsAt.toLocaleDateString("ko-KR")// "2012. 12. 20."
    const expiresAt = contract.leaseStartsAt.toLocaleDateString("ko-KR")// "2012. 12. 20."
    const data = {
       "contractNumber": contract.contractNumber,
       "monthlyRate": contract.monthlyRate,
       "vehicleIN": contract.vehicleIN,
       "customerName": contract.customerName,
       "leaseStartsAt": startsAt+"T00:00:00",
       "leaseExpiresAt": expiresAt+"T23:59:59"
     };
     console.log("contractNumber: "+data.contractNumber)
     console.log("monthlyRate: "+data.monthlyRate)
     console.log("vehicleIN: "+data.vehicleIN)
     console.log("customerName: "+data.customerName)
     console.log("leaseStartsAt: "+data.leaseStartsAt)
     console.log("leaseExpiresAt: "+data.leaseExpiresAt)
     axios
       .post(this.contract_endpoint, data, {
         headers: {
           Accept: "application/json",
           "Content-Type": "application/json;charset=UTF-8",
           'Access-Control-Allow-Credentials': 'false'
         },
       })
       .then(({ data }) => {
         console.log("Request to save contract details has been fulfilled.")
       }).catch(({ err }) => {
         console.log("Error occured while saving contract details.")
         console.log(`Error is: ${err}`)
       });
       return contract
   }
}
