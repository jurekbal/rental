import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private httpClient: HttpClient) {
  }

  public getCompanyData(): Observable<CompanyData> {
    return this.httpClient.get<CompanyData>('http://localhost:8080/home');
  }
}



  export interface Address {
    streetWithNumber: string;
    city: string;
    postalCode: string;
  }

  export interface CompanyBranch {
    id: number;
    address: Address;
  }

  export interface CompanyData {
    id: number;
    name: string;
    webDomain: string;
    owner: string;
    logoURL: string;
    companyBranches: CompanyBranch[];
  }



