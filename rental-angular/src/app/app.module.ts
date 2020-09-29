import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { EditComponent } from './edit-company-data/edit.component';
import { AppRoutingModule } from './app-routing.module';
import { NotFoundComponent } from './not-found/not-found.component';
import { CompanyBranchComponent } from './company-branch/company-branch.component';
import { CarsComponent } from './cars/cars.component';
import { KlientsComponent } from './clients/klients.component';
import { BookingComponent } from './booking/booking.component';
import { DataComponent } from './data/data.component';

@NgModule({
  declarations: [
    AppComponent,
    EditComponent,
    NotFoundComponent,
    CompanyBranchComponent,
    CarsComponent,
    KlientsComponent,
    BookingComponent,
    DataComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
