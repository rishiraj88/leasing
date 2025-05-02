import { Component, EventEmitter, Output } from '@angular/core';
import { VehicleDTO } from '../vehicle/dto/VehicleDTO';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-vehicle-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './vehicle-form.component.html',
  styleUrl: './vehicle-form.component.css'
})
export class VehicleFormComponent {
  public vehicleDTO: VehicleDTO = new VehicleDTO("null","null","null","null",1.11)

  public saveEditLabel: string = 'Save'
  
  //default values added
  // for quick review
  // post app installation
  brand: string = 'brand'
  model: string = "model"
  makeYear: string = '1880'
  vin: string = "VIN"
  price: number = 1.11

  
    @Output()
    vehicleDtoEvent: EventEmitter<VehicleDTO> = new EventEmitter<VehicleDTO>();
  
    public save() {
      console.log("form:: brand: "+this.vehicleDTO.brand)
      console.log("form:: model: "+this.vehicleDTO.model)
      console.log("form:: myear: "+this.vehicleDTO.makeYear)
      console.log("form:: vin: "+this.vehicleDTO.vin)
      console.log("form:: price: "+this.vehicleDTO.price)
      this.vehicleDTO = new VehicleDTO(this.brand, this.model,this.makeYear, this.vin,this.price)
      console.log("form:: dto: "+this.vehicleDTO)
      this.saveEditLabel= 'Edit'
      this.vehicleDtoEvent.emit(this.vehicleDTO)
    }
  public clear() {
    this.brand = ''
    this.model = ''
    this.makeYear = ''
    this.vin = ''
    this.price = 0;
    this.saveEditLabel = 'Save'
  }
}
