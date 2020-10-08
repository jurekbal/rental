import {Component, OnInit} from '@angular/core';
import {RestService} from "../../service/rest.service";
import {ActivatedRoute} from "@angular/router";
import {Branch, Employee} from "../../service/branch";
import {Location} from "@angular/common";

@Component({
  selector: 'app-company-branch',
  templateUrl: './company-branch.component.html',
  styleUrls: ['./company-branch.component.css']
})
export class CompanyBranchComponent implements OnInit {
  branches: Branch[];
  branch: Branch;
  employee: Employee;
employees: Employee[]


  constructor(
    private route: ActivatedRoute,
    private restService: RestService,
    private location: Location
  ) {
  }

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
