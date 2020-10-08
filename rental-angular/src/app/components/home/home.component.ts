import { Component, OnInit } from '@angular/core';
import {Address, CompanyBranch, CompanyData} from "../../service/company-data";
import {RestService} from "../../service/rest.service";




@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

companyData : CompanyData;
companyBranch: CompanyBranch[];

  constructor(private restService : RestService) { }

  ngOnInit(): void {
    this.restService.getCompanyData().subscribe(value => {
      this.companyData = value;
    });
  }

}

