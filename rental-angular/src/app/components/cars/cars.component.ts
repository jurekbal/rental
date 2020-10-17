import { Component, OnInit } from '@angular/core';
import {Car} from "../../service/car";
import {RestService} from "../../service/rest.service";

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {
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
