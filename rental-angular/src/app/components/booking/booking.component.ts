import { Component, OnInit } from '@angular/core';
import {RestService} from "../../service/rest.service";
import {Branch} from "../../service/branch";

class Booking {
}


@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css'],

})
export class BookingComponent implements OnInit {
booking: Booking;



  constructor(private restService : RestService  ) { }

  ngOnInit(): void {
    this.getBooking();
  }

  getBooking(): void{
    this.restService.getBooking()
      .subscribe(booking => this.booking = booking);
  }
  public addBooking(customerID: number, employeeId: number, carId: number,rentalDay: ,returnDay: ,rentBranchId: number,returnBranchId: number): void{
  // if (!customerID || !employeeId|| !postalCode ) {
  // return;
}
this.booking = {}
}
this.restService.addBooking({customerID, employeeId, carId,rentalDay, returnDay,rentBranchId,returnBranchId } as Booking)
  .subscribe(booking => {
    this.booking.push(booking);
  });
}
