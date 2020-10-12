import {NgModule} from "@angular/core";

import { RouterModule, Routes } from '@angular/router';
import {EditComponent} from './components/edit-company-data/edit-company-data';
import {NotFoundComponent} from './components/not-found/not-found.component';
import {HomeComponent} from './components/home/home.component';
import {CarsComponent} from './components/cars/cars.component';
import {ClientsComponent} from './components/clients/clients.component';
import {BookingComponent} from './components/booking/booking.component';
import {CompanyBranchComponent} from './components/branches/company-branch.component';




const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'edit', component: EditComponent },
  { path: 'home', component: HomeComponent },
  { path: 'cars', component: CarsComponent },
  { path: 'clients', component: ClientsComponent },
  { path: 'booking', component: BookingComponent },
  { path: 'branches', component: CompanyBranchComponent },


  { path: '**', redirectTo: '/404', pathMatch: 'full' },
  { path: '404', component: NotFoundComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
