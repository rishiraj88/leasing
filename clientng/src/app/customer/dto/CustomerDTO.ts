export class CustomerDTO {
  
  constructor(private _name: string, private _birthDate: Date) {}

  public get name(): string {
    return this._name
  }
  
  public get birthDate(): Date {
    return this._birthDate
  }
}