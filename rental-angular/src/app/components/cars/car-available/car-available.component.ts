import { Component, OnInit } from '@angular/core';
import {Car} from "../../../service/car";
import {RestService} from "../../../service/rest.service";

@Component({
  selector: 'app-car-available',
  templateUrl: './car-available.component.html',
  styleUrls: ['./car-available.component.css']
})
export class CarAvailableComponent implements OnInit {

  car : Car;
  cars: Car[];

  constructor(private restService : RestService) { }

  ngOnInit(): void {
    this.getCars();

  }
  getCars():void{
    this.restService.getCars()
      .subscribe(cars => this.cars = cars);
  }

}
