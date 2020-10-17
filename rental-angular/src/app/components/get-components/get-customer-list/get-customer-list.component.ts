import { Component, OnInit } from '@angular/core';
import {RestService} from "../../../service/rest.service";
import {Customer} from "../../../service/customer";

@Component({
  selector: 'app-get-customer-list',
  templateUrl: './get-customer-list.component.html',
  styleUrls: ['./get-customer-list.component.css']
})
export class GetCustomerListComponent implements OnInit {
  customers: Customer[];

  constructor(private restService: RestService) { }

  ngOnInit(): void {
    this.getCustomers()
  }
  getCustomers():void{
    this.restService.getCustomers()
      .subscribe(customers => this.customers = customers);
  }
}
