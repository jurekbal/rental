import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { CompanyData } from '../../services/company-data';
import { CompanyDataService } from '../../services/company-data.service';
@Component({
  selector: 'app-edit',
  templateUrl: './edit-company-data.html',
  styleUrls: ['./edit-company-data.css']
})
export class EditComponent implements OnInit {
companyData: CompanyData;


  constructor(
    private route: ActivatedRoute,
    private companyDataService: CompanyDataService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.getCompanyData();
  }
  getCompanyData(): void {

    const id = +this.route.snapshot.paramMap.get('id');
    this.companyDataService.getCompanyData(id)
      .subscribe(companyData => this.companyData = companyData);
  }

  goBack(): void {
    this.location.back();
  }
  save(): void {

    // this.companyDataService.updateCompanyData(this.companyData)
    //   .subscribe(() => this.goBack());
  }
}
