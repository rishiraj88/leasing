import { HttpClient } from "@angular/common/http";
import { Injectable, OnInit } from "@angular/core";
import axios from "axios";
import { throwError } from "rxjs/internal/observable/throwError";
import { catchError } from "rxjs/internal/operators/catchError";
import { map } from "rxjs/internal/operators/map";
import { LeasingContractDTO } from "./dto/LeasingContractDTO";

@Injectable()
export class LeasingContractService {
  latestContractNumber: number = -1
  allContracts: LeasingContractDTO[] =[]
  constructor(private httpClient: HttpClient) { 
  }

  private url = 'http://localhost:8080/contract/'

  view() {
    console.log('in service view')
    return this.httpClient
      .get<LeasingContractDTO[]>(this.url, { withCredentials: false })
      .pipe(
        catchError((error) =>
          throwError(() => console.log("error: " + error))
        ),
        map((res) => {
          console.log("response: " + res)
          this.allContracts.length = 0
          this.allContracts.push(...res)
          this.latestContractNumber = this.allContracts[this.allContracts.length -1].contractNumber
          console.log("this.allContracts: "+this.allContracts)
          return res
        }));
  }

  save(leasingContractDto: LeasingContractDTO): LeasingContractDTO {
    console.log("in service save")
     const data = {
       "contractNumber": leasingContractDto.contractNumber,
       "monthlyRate": leasingContractDto.monthlyRate,
       "customerName": leasingContractDto.customerName,
       "vehicleDetails": leasingContractDto.vehicleDetails
      };
     console.log("price: "+data.monthlyRate)
     axios
       .post(this.url, data, {
         headers: {
           Accept: "application/json",
           "Content-Type": "application/json;charset=UTF-8",
           'Access-Control-Allow-Credentials': 'false'
         },
       })
       .then(({ data }) => {
         console.log("Request to save leasing contract details has been completed.")
         this.view().subscribe((contracts) => {})
       }).catch(({ err }) => {
         console.log("Error occured while saving leasing contract details.")
         console.log(`Error is: ${err}`)
       });
       return leasingContractDto
   }
   
   
}



interface LeasingContractResponse extends Response {
  items: LeasingContractDTO[]
}
