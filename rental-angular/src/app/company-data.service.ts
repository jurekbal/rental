import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {CompanyData} from "./company-data";

@Injectable({
  providedIn: 'root'
})
export class CompanyDataService {

  private companyDataUrl = 'http://localhost:8080/home';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };



  constructor(private http: HttpClient) { }



  getCompanyData(id: number): Observable<CompanyData> {
    const url = `${this.companyDataUrl}/${id}`;
    return this.http.get<CompanyData>(url);
  }

  updateCompanyData(companyData: CompanyData): Observable<CompanyData> {
    const url = `${this.companyDataUrl}/${companyData.id}`;
    return this.http.put<CompanyData>(url, this.companyDataUrl, this.httpOptions);
  }
}
