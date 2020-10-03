import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { EditComponent } from './components/edit-company-data/edit-company-data';
import { AppRoutingModule } from './app-routing.module';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { CompanyBranchComponent } from './components/company-branch/company-branch.component';
import { CarsComponent } from './components/cars/cars.component';
import { ClientsComponent } from './components/clients/clients.component';
import { BookingComponent } from './components/booking/booking.component';
import {HttpClientModule} from "@angular/common/http";
import {HomeComponent} from "./components/home/home.component";



@NgModule({
  declarations: [
    AppComponent,
    EditComponent,
    NotFoundComponent,
    CompanyBranchComponent,
    CarsComponent,
    ClientsComponent,
    BookingComponent,
   HomeComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
