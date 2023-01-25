export class VehicleDTO {
  
  constructor(private _brand: string,private _model: string,private _year: string,private _vin: string,private _price: number) {}

  public get brand(): string {
    return this._brand
  }

  public get model(): string {
    return this._model
  }
  
  public get year(): string {
    return this._year
  }
  
  public get vin(): string {
    return this._vin
  }
  
  public get price(): number {
    return this._price
  }
}