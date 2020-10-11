import { Component, OnInit } from '@angular/core';

import {ActivatedRoute} from "@angular/router";
import {RestService} from "../../service/rest.service";
import {Employee} from "../../service/employee";



@Component({
  selector: 'app-employees-list',
  templateUrl: './employees-list.component.html',
  styleUrls: ['./employees-list.component.css']
})
export class EmployeesListComponent implements OnInit {
employee : Employee;
employees: Employee[];




  constructor(
    private route: ActivatedRoute,
    private restService: RestService
  ) { }

  ngOnInit(): void {
    this.getEmployee();
  }
public getEmployee(): void {
  this.restService.getEmployee().subscribe(value => {
    this.employee = value;
  });
}
}
