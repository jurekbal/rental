import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {CompanyData} from "./company-data";
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CompanyDataService {

 private companyDataUrl = 'https://jsonplaceholder.typicode.com/users';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };


  constructor(private http: HttpClient) { }



  getCompanyData(id: number): Observable<CompanyData> {
    const url = `${this.companyDataUrl}/${id}`;
    return this.http.get<CompanyData>(url);
  }

  // updateCompanyData(companyData: CompanyData): Observable<CompanyData> {
  //   const url = `${this.companyDataUrl}/${companyData.id}`;
  //   return this.http.put<CompanyData>(url, this.companyDataUrl, this.httpOptions);
  // }
}
