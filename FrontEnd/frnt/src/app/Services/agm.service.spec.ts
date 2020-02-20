import { TestBed } from '@angular/core/testing';

import { AgmService } from './agm.service';

describe('AgmService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AgmService = TestBed.get(AgmService);
    expect(service).toBeTruthy();
  });
});
