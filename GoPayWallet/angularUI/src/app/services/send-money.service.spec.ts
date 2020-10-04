import { TestBed } from '@angular/core/testing';

import { SendMoneyService } from './send-money.service';

describe('SendMoneyService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SendMoneyService = TestBed.get(SendMoneyService);
    expect(service).toBeTruthy();
  });
});
