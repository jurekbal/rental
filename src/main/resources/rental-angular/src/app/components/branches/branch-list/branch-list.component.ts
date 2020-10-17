import { Component, OnInit } from '@angular/core';
import {Branch, EmployeeB} from "../../../service/branch";
import {ActivatedRoute} from "@angular/router";
import {RestService} from "../../../service/rest.service";
import {Location} from "@angular/common";
import {Address} from "../../../service/branch";

@Component({
  selector: 'app-branch-list',
  templateUrl: './branch-list.component.html',
  styleUrls: ['./branch-list.component.css']
})
export class BranchListComponent implements OnInit {
  branches: Branch[];
  branch: Branch;
  employee: EmployeeB;
  showAdd = false;
  address: Address

  constructor(
    private route: ActivatedRoute,
    private restService: RestService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.getBranches();
  }
  goBack(): void {
    this.location.back();
  }

  getBranches():void{
    this.restService.getBranches()
      .subscribe(branches => this.branches = branches);
  }


  deleteBranch(branch: Branch): void {
    this.branches = this.branches.filter(s => s !== branch);
    this.restService.deleteBranch(branch).subscribe();
  }

  public addBranch(streetWithNumber: string, city: string, postalCode: string): void {
    if (!streetWithNumber || !city || !postalCode ) {
      return;
    }
    this.address = {streetWithNumber, city, postalCode }
    this.restService.addBranch({ address: this.address } as Branch)
      .subscribe(branch => {
        this.branches.push(branch);
      });
  }

}
