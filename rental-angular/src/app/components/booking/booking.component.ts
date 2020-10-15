import {Component, Input, OnInit} from '@angular/core';
import {RestService} from "../../service/rest.service";
import {Booking} from "../../service/booking";
import {Customer} from "../../service/customer";
import {Branch} from "../../service/branch";
import {Car} from "../../service/car";
import {Employee} from "../../service/employee";



@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css'],

})
export class BookingComponent implements OnInit {
 booking: Booking[];
  branches: Branch[];
  cars: Car[];
  employees: Employee[];

  @Input() bookingAdd: Booking[];
  customers: Customer[];
  constructor(private restService : RestService  ) { }

  ngOnInit(): void {
    this.getBooking();
    this.getCustomers();
    this.getBranches();
    this.getEmployees();
this.getCars()
  }

  getBooking(): void{
    this.restService.getBooking()
      .subscribe(booking => this.booking = booking);
  }
  public addBooking(customerID: number, employeeId: number, carId: number,
                    rentalDay: string, returnDay: string, rentBranchId: number, returnBranchId: number): void {
    if (!customerID || !employeeId|| carId ) {
     return;
  }

// @ts-ignore //Todo nie wiem co się tu wydarzyło ????

    this.restService.addBooking({customerID, employeeId, carId,
  rentalDay, returnDay, rentBranchId, returnBranchId} as Booking)
  .subscribe(booking => {
    this.bookingAdd.push(booking);
  });
}
  getCustomers():void{
    this.restService.getCustomers()
      .subscribe(customers => this.customers = customers);
  }
  getBranches():void{
    this.restService.getBranches()
      .subscribe(branches => this.branches = branches
      );
  }
    getCars():void{
      this.restService.getCars()
        .subscribe(cars => this.cars = cars);
  }

  public getEmployees(): void {
    this.restService.getEmployees().subscribe(employees => this.employees = employees);
  }
}
