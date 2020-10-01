import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { EditComponent } from './componets/edit-company-data/edit-company-data';
import { AppRoutingModule } from './app-routing.module';
import { NotFoundComponent } from './componets/not-found/not-found.component';
import { CompanyBranchComponent } from './componets/company-branch/company-branch.component';
import { CarsComponent } from './componets/cars/cars.component';
import { KlientsComponent } from './componets/clients/klients.component';
import { BookingComponent } from './componets/booking/booking.component';
import { DataComponent } from './componets/data/data.component';
import { HomeComponent } from './componets/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    EditComponent,
    NotFoundComponent,
    CompanyBranchComponent,
    CarsComponent,
    KlientsComponent,
    BookingComponent,
    DataComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
