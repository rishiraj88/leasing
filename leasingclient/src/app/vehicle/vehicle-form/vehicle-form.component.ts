import { Component, EventEmitter, Output } from '@angular/core';
import { VehicleDTO } from 'src/app/vehicle/dto/VehicleDTO';

@Component({
  selector: 'app-vehicle-form',
  templateUrl: './vehicle-form.component.html',
  styleUrls: ['./vehicle-form.component.css']
})
export class VehicleFormComponent {
  //default values only for evaluation of the app
  //these will be removed
  brand: string = 'BMW'
  model: string = 'X3'
  year: string = '2022'
  vin: string = ''
  price: number = 45.350//-1.00

  @Output()
  vehicleDtoEvent: EventEmitter<VehicleDTO> = new EventEmitter<VehicleDTO>();

  save() {
    console.log(this.brand)
    console.log(this.model)
    console.log(this.year)
    console.log(this.vin)
    console.log(this.price)
    let vehicleDTO = new VehicleDTO(this.brand, this.model, this.year, this.vin, this.price)
    this.vehicleDtoEvent.emit(vehicleDTO)
    console.log(vehicleDTO)
  }

  clear() {
    this.brand = ''
    this.model = ''
    this.year = ''
    this.vin = ''
    this.price = -1
    let vehicleDTO = new VehicleDTO(this.brand, this.model, this.year, this.vin, this.price)
    this.vehicleDtoEvent.emit(vehicleDTO)
    console.log(vehicleDTO)
  }
}

