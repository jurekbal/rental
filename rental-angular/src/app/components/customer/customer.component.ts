import { Component, OnInit } from '@angular/core';
import {RestService} from "../../service/rest.service";
import {Customer} from "../../service/customer";

@Component({
  selector: 'app-klients',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
customers: Customer[];

  constructor( private restService: RestService,) { }

  ngOnInit(): void {
    this.getCustomers()
  }

  getCustomers():void{
    this.restService.getCustomers()
      .subscribe(customers => this.customers = customers);
  }
}
