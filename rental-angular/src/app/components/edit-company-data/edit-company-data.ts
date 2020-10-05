import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import {CompanyData} from "../../service/company-data";
import {RestService} from "../../service/rest.service";

@Component({
  selector: 'app-edit',
  templateUrl: './edit-company-data.html',
  styleUrls: ['./edit-company-data.css']
})
export class EditComponent implements OnInit {
companyData: CompanyData;


  constructor(
    private route: ActivatedRoute,
    private restService : RestService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.restService.getCompanyData().subscribe(value => {
      this.companyData = value;
    });
  }
  goBack(): void {
    this.location.back();
  }

  save(): void {

    this.restService.updateCompanyData(this.companyData)
      .subscribe(() => this.goBack());
  }


}
