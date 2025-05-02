export class ContractDTO {
  
  constructor(private _contractNumber: string,private _monthlyRate: number,private _vehicleIN: string
    ,private _customerName: string,private _leaseStartsAt: Date,private _leaseExpiresAt: Date) {}

  public get contractNumber(): string {
    return this._contractNumber
  }

  public get monthlyRate(): number {
    return this._monthlyRate
  }
  
  public get vehicleIN(): string {
    return this._vehicleIN
  }
  
  public get customerName(): string {
    return this._customerName
  }
  
  public get leaseStartsAt(): Date {
    return this._leaseStartsAt
  }

  public get leaseExpiresAt(): Date {
    return this._leaseExpiresAt
  }
}