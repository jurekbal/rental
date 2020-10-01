import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KlientsComponent } from './klients.component';

describe('KlientsComponent', () => {
  let component: KlientsComponent;
  let fixture: ComponentFixture<KlientsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KlientsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KlientsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
