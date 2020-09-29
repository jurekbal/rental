import { TestBed } from '@angular/core/testing';

import { EditCompanyDataService } from './edit-company-data.service';

describe('EditCompanyDataService', () => {
  let service: EditCompanyDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EditCompanyDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
