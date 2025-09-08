import { Component } from '@angular/core';
import { VehicleDTO } from '../vehicle/dto/VehicleDTO';
import { VehicleService } from '../vehicle.service';

@Component({
  selector: 'app-vehicle-list',
  standalone: true,
  imports: [],
  templateUrl: './vehicle-list.component.html',
  styleUrl: './vehicle-list.component.css'
})
export class VehicleListComponent {

  vehicles: VehicleDTO[]=[]

  constructor(private vehicleService: VehicleService) {}

  onOnInit(): void{
    this.vehicleService.getVehicles().subscribe({
      next: (data: VehicleDTO[]) => {
        this.vehicles = data
      },
      error: (err) => {
        console.error("Error fetching vehicle list: ",err)
      }
    })
  }
}
