import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EditComponent} from './componets/edit-company-data/edit-company-data';
import {NotFoundComponent} from './componets/not-found/not-found.component';
import {HomeComponent} from './componets/home/home.component';
import {CarsComponent} from './componets/cars/cars.component';
import {ClientsComponent} from './componets/clients/clients.component';
import {BookingComponent} from './componets/booking/booking.component';
import {CompanyBranchComponent} from './componets/company-branch/company-branch.component';




const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'edit', component: EditComponent },
  { path: 'home', component: HomeComponent },
  { path: 'cars', component: CarsComponent },
  { path: 'clients', component: ClientsComponent },
  { path: 'booking', component: BookingComponent },
  { path: 'branch', component: CompanyBranchComponent },


  { path: '**', redirectTo: '/404', pathMatch: 'full' },
  { path: '404', component: NotFoundComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
