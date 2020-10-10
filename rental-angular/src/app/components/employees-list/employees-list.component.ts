import { Component, OnInit } from '@angular/core';
import {Branch, Employee} from "../../service/branch";
import {ActivatedRoute} from "@angular/router";
import {RestService} from "../../service/rest.service";

@Component({
  selector: 'app-employees-list',
  templateUrl: './employees-list.component.html',
  styleUrls: ['./employees-list.component.css']
})
export class EmployeesListComponent implements OnInit {
  employee: Employee;
  branches: Branch[];
  branch: Branch;

  constructor(
    private route: ActivatedRoute,
    private restService: RestService
  ) { }

  ngOnInit(): void {
    this.getBranches();
  }
  getBranches():void{
    this.restService.getBranches()
      .subscribe(branches => this.branches = branches);
  }
}
