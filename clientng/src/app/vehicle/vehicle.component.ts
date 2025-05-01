import { Component, Input } from '@angular/core';
import { VehicleDTO } from './dto/VehicleDTO';
import { VehicleService } from '../vehicle.service';
import { VehicleFormComponent } from '../vehicle-form/vehicle-form.component';

@Component({
  selector: 'app-vehicle',
  standalone: true,
  imports: [VehicleFormComponent],
  templateUrl: './vehicle.component.html',
  styleUrl: './vehicle.component.css',
  providers:[VehicleService]
})
export class VehicleComponent {
  @Input()
  private vehicleDto?: VehicleDTO

  constructor(private _vehicleService: VehicleService) { }

  save($eventDTO: VehicleDTO) {
    console.log("customerpage:: customerDtoEvent: ")
    console.log($eventDTO)
    if ($eventDTO)
      this.vehicleDto = this._vehicleService.save($eventDTO)
}
}
