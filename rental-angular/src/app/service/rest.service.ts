import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient, HttpHandler, HttpHeaders} from '@angular/common/http';
import { CompanyData} from "./company-data";
import { catchError } from 'rxjs/operators';
import {  throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  readonly BASE_URL = 'http://localhost:8080';
  httpOptnions = {headers: new HttpHeaders({ 'Content-Type': 'application/json' })}

  constructor(private httpClient: HttpClient) {
  }


  public getCompanyData(): Observable<CompanyData> {

    return this.httpClient.get<CompanyData>(this.BASE_URL +'/home');
  }
  public updateCompanyData(companyData : CompanyData): Observable<CompanyData>{
    return this.httpClient.put<CompanyData>(this.BASE_URL +'/home', companyData, this.httpOptnions);

  }
 // public update(companyData): Observable<CompanyData> {
 //    return this.httpClient.put<CompanyData>(this.BASE_URL + '/home/', JSON.stringify(companyData), this.httpOptnions)
 //      .pipe(
 //        catchError(this.errorHandler)
 //      )
 //  }
 //
 //
 //
 //  errorHandler(error) {
 //    let errorMessage = '';
 //    if(error.error instanceof ErrorEvent) {
 //      // Get client-side error
 //      errorMessage = error.error.message;
 //    } else {
 //      // Get server-side error
 //      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
 //    }
 //    console.log(errorMessage);
 //    return throwError(errorMessage);
 //  }
}






