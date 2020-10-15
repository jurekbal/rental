import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { EditComponent } from './components/edit-company-data/edit-company-data';
import { AppRoutingModule } from './app-routing.module';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { CarsComponent } from './components/cars/cars.component';
import { CustomerComponent } from './components/customer/customer.component';
import { BookingComponent } from './components/booking/booking.component';
import {HttpClientModule} from "@angular/common/http";
import {HomeComponent} from "./components/home/home.component";
import {FormsModule} from "@angular/forms";
import {CompanyBranchComponent} from "./components/branches/company-branch.component";
import { CarAvailableComponent } from './components/cars/car-available/car-available.component';
import { EmployeesListComponent } from './components/employees-list/employees-list.component';
import { BranchListComponent } from './components/branches/branch-list/branch-list.component';




@NgModule({
  declarations: [
    AppComponent,
    EditComponent,
    NotFoundComponent,
CompanyBranchComponent,
    CarsComponent,
    CustomerComponent,
    BookingComponent,
   HomeComponent,
   CarAvailableComponent,
   EmployeesListComponent,
   BranchListComponent,


  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
