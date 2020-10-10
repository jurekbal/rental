import {Component, Input, OnInit} from '@angular/core';
import {Address, CompanyBranch, CompanyData} from "../../service/company-data";
import {RestService} from "../../service/rest.service";
import {Branch} from "../../service/branch";




@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
@Input() branches:Branch[];

companyData : CompanyData;


  showBranchList = false;


  constructor(private restService : RestService) { }

  ngOnInit(): void {
    this.restService.getCompanyData().subscribe(value => {
      this.companyData = value;
    });
  }




}

