import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Address, CompanyData} from "./company-data";


@Injectable({
  providedIn: 'root'
})
export class RestService {

  readonly BASE_URL = 'http://localhost:8080';

  constructor(private httpClient: HttpClient) {
  }


  public getCompanyData(): Observable<CompanyData> {

    return this.httpClient.get<CompanyData>(this.BASE_URL +'/home');
  }
  public getCompanyAddress(): Observable<Address> {

    return this.httpClient.get<Address>(this.BASE_URL +'/home');
  }
}






