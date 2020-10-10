import { Component, OnInit } from '@angular/core';
import {Branch, EmployeeB} from "../../../service/branch";
import {ActivatedRoute} from "@angular/router";
import {RestService} from "../../../service/rest.service";
import {Location} from "@angular/common";

@Component({
  selector: 'app-branch-list',
  templateUrl: './branch-list.component.html',
  styleUrls: ['./branch-list.component.css']
})
export class BranchListComponent implements OnInit {
  branches: Branch[];
  branch: Branch;
  employee: EmployeeB;

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
    this.restService.delateBranch(branch).subscribe();
  }

  saveBranch(): void{
    this.restService.updateBranch(this.branch)
      .subscribe(()=> this.goBack());
  }

}
