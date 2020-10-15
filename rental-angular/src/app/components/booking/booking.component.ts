import {Component, Input, OnInit} from '@angular/core';
import {RestService} from "../../service/rest.service";
import {Booking} from "../../service/booking";



@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css'],

})
export class BookingComponent implements OnInit {
  booking: Booking[];

  @Input() bookingAdd: Booking[];

  constructor(private restService: RestService) {
  }

  ngOnInit(): void {
    this.getBooking();
  }

  getBooking(): void {
    this.restService.getBooking()
      .subscribe(booking => this.booking = booking);
  }

  public addBooking(customerID: number, employeeId: number, carId: number,
                    rentalDay: string, returnDay: string, rentBranchId: number, returnBranchId: number): void {
    if (!customerID || !employeeId || carId) {
      return;
    }

// @ts-ignore //Todo nie wiem co się tu wydarzyło ????

    this.restService.addBooking({
      customerID, employeeId, carId,
      rentalDay, returnDay, rentBranchId, returnBranchId
    } as Booking)
      .subscribe(booking => {
        this.bookingAdd.push(booking);
      });
  }
}
