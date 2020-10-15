import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {CompanyData} from "./company-data";
import {catchError} from 'rxjs/operators';
import {throwError} from 'rxjs';
import {Branch, EmployeeB} from "./branch";
import {Employee} from "./employee";

import {Car} from "./car";


import {Customer} from "./customer";


@Injectable({
  providedIn: 'root'
})
export class RestService {


  readonly BASE_URL = 'http://localhost:8080';
  httpOptnions = {headers: new HttpHeaders({'Content-Type': 'application/json'})}

  constructor(private httpClient: HttpClient) {
  }


  public getCompanyData(): Observable<CompanyData> {

    return this.httpClient.get<CompanyData>(this.BASE_URL + '/home');
  }

  public updateCompanyData(companyData: CompanyData): Observable<CompanyData> {
    return this.httpClient.put<CompanyData>(this.BASE_URL + '/home', companyData, this.httpOptnions);

  }
public getBranch(id: number): Observable<Branch>{
  const url = `${this.BASE_URL + '/branches'}/${id}`;
  return this.httpClient.get<Branch>(url);

}
  public getBranches(): Observable<Branch[]> {

    return this.httpClient.get<Branch[]>(this.BASE_URL + '/branches');
  }

  public addBranch(branch: Branch): Observable<Branch> {
    return this.httpClient.put<Branch>(this.BASE_URL + '/branches', branch, this.httpOptnions);

  }

  public deleteBranch(branch: Branch): Observable<Branch> {
    const url = `${this.BASE_URL + '/branches'}/${branch.id}`;
    return this.httpClient.delete<Branch>(url, this.httpOptnions);
  }

  public updateBranch(branch: Branch): Observable<Branch> {
    const url = `${this.BASE_URL + '/branches'}/${branch.id}`;
    return this.httpClient.put<Branch>(url, branch, this.httpOptnions)
  }
public getBranchCars(id: number): Observable<Car[]>{
  const url = `${this.BASE_URL + '/branches'}/${id}` + '/cars';
  return this.httpClient.get<Car[]>(url);
}

  public getEmployee(): Observable<Employee>{
    return  this.httpClient.get<Employee>(this.BASE_URL + '/employees');
  }
  public getEmployees(): Observable<Employee[]> {

    return this.httpClient.get<Employee[]>(this.BASE_URL + '/employees');
  }

  public getCars (): Observable <Car[]> {
    return this.httpClient.get<Car[]>(this.BASE_URL + '/cars');
  }

  // public getBranchCars(id: number): Observable<Car[]>{
  //   const url = `${this.BASE_URL + '/branches'}/${id}` + '/cars';
  //   return this.httpClient.get<Car[]>(url);
  // }
=======

  public getCustomers(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.BASE_URL + '/customers');
  }



  // public getEmployee(id: number): Observable<Employee>{
  //   const url = `${this.BASE_URL + '/branches'}/${id}`;
  //   return this.httpClient.get<Employee>(url);
  //
  // }
  // public getEmployees(): Observable<Employee[]> {
  //   return this.httpClient.get<Employee[]>(this.BASE_URL + '/branches');
  // }
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






