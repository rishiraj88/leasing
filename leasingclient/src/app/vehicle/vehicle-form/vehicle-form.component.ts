import { Component, EventEmitter, Output } from '@angular/core';
import { VehicleDTO } from 'src/app/vehicle/dto/VehicleDTO';

@Component({
  selector: 'app-vehicle-form',
  templateUrl: './vehicle-form.component.html',
  styleUrls: ['./vehicle-form.component.css']
})
export class VehicleFormComponent {
  brand: string = ''
  model: string = ''
  year: string = ''
  vin: string = ''
  price: number = -1.00

  saveEditLabel: string = 'Save'

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
    this.saveEditLabel='Edit'
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
    this.saveEditLabel='Save'
  }
}

