export class CustomerDTO {
  
  constructor(private _firstName: string, private _lastName: string, private _birthDate: Date) {}

  public get firstName(): string {
    return this._firstName
  }

  public get lastName(): string {
    return this._lastName
  }
  
  public get birthDate(): Date {
    return this._birthDate
  }
}