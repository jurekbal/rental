import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-edit',
  templateUrl: './edit-company-data.html',
  styleUrls: ['./edit-company-data.css']
})
export class EditComponent implements OnInit {



  constructor(
    private route: ActivatedRoute,

    private location: Location
  ) {}

  ngOnInit(): void {
    // this.getCompanyData();
  }
  // getCompanyData(): void {

  //   const id = +this.route.snapshot.paramMap.get('id');
  //   this.companyDataService.getCompanyData(id)
  //     .subscribe(companyData => this.companyData = companyData);
  // }
  //
  // goBack(): void {
  //   this.location.back();
  // }
  // save(): void {

    // this.companyDataService.updateCompanyData(this.companyData)
    //   .subscribe(() => this.goBack());
  // }
}
