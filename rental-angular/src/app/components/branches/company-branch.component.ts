import {Component, OnInit} from '@angular/core';
import {RestService} from "../../service/rest.service";
import {ActivatedRoute} from "@angular/router";
import {Branch, EmployeeB} from "../../service/branch";
import {Location} from "@angular/common";
import {Car} from "../../service/car";

@Component({
  selector: 'app-company-branch',
  templateUrl: './company-branch.component.html',
  styleUrls: ['./company-branch.component.css']
})
export class CompanyBranchComponent implements OnInit {
  branches: Branch[];
  branch: Branch;
  employeeB: EmployeeB;
cars: Car[];
  car: Car;
branchCar: boolean;
showCars: boolean;

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
      .subscribe(branches => {this.branches = branches;
      this.getCarsId();} //todo jesli bedzie przycisk to to nie potrzebne
      );
  }


  deleteBranch(branch: Branch): void {
    this.branches = this.branches.filter(s => s !== branch);
this.restService.deleteBranch(branch).subscribe();
  }

saveBranch(): void{
    this.restService.updateBranch(this.branch)
      .subscribe(()=> this.goBack());
}



  // getCar(id: number):void {
  //   this.restService.getBranchCars(id)
  //     .subscribe(cars => {
  //       this.cars = cars;
  //     });
  // }
  getCarsId():void{
    this.restService.getBranchCars(1)  //todo przycisk do wczytywania danych
      .subscribe(cars => this.cars = cars);
  }


  // getCar(id: number):void {
  //   this.restService.getBranchCars(id)
  //     .subscribe(cars => {
  //       this.cars = cars;
  //     });
  // }
  // getCarsId():void{
  //   this.restService.getBranchCars(1)  //todo przycisk do wczytywania danych
  //     .subscribe(cars => this.cars = cars);
  // }

  // getCarsId(id):void{
  //   this.restService.getBranchCars(id)  //todo przycisk do wczytywania danych
  //     .subscribe(cars => this.cars = cars);
  // }

}
