import { CustomerDTO } from "src/app/customer/dto/CustomerDTO"
import { VehicleDTO } from "src/app/vehicle/dto/VehicleDTO"

export class LeasingContractDTO {
  
  constructor(private _contractNumber: number,private _monthlyRate: number
    ,private _customerName: string, private _vehicleDetails: string
    ,private _customerDto?: CustomerDTO,private _vehicleDto?: VehicleDTO) {
    }

  public get contractNumber(): number {
    return this._contractNumber
  }

  public get monthlyRate(): number {
    return this._monthlyRate
  }
  
  public get customerName(): string {
    return this._customerName
  }
  
  public get vehicleDetails(): string {
    return this._vehicleDetails
  }
  
  public get customerDto(): CustomerDTO | undefined {
    return this._customerDto
  }
  
  public get vehicleDto(): VehicleDTO | undefined{
    return this._vehicleDto
  }
  
}