import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetCustomerListComponent } from './get-customer-list.component';

describe('GetCustomerListComponent', () => {
  let component: GetCustomerListComponent;
  let fixture: ComponentFixture<GetCustomerListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetCustomerListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetCustomerListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
