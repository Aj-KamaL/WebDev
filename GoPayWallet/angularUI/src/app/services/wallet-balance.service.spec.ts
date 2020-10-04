import { TestBed } from '@angular/core/testing';

import { WalletBalanceService } from './wallet-balance.service';

describe('WalletBalanceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: WalletBalanceService = TestBed.get(WalletBalanceService);
    expect(service).toBeTruthy();
  });
});
