import { Component } from '@angular/core';
import { VehicleDTO } from './dto/VehicleDTO';
import { VehicleService } from './vehicle.service';

@Component({
  selector: 'app-vehicle',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.css'],
  providers:[VehicleService]
})
export class VehicleComponent {
  private vehicleDto?: VehicleDTO
  private url = 'http://localhost:8080/vehicle/'

  constructor(private vehicleService: VehicleService) { }

  save(vehicle: VehicleDTO) {
      this.vehicleDto = this.vehicleService.save(vehicle)
  }


}
