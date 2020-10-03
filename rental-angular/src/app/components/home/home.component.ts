import { Component, OnInit } from '@angular/core';
import {CompanyData, HomeService} from "../../services/home.service";




@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

companyData : CompanyData;

  constructor(private homeService : HomeService) { }

  ngOnInit(): void {
    this.homeService.getCompanyData().subscribe(value => {
      this.companyData = value;
    });
  }
}

