import { TestBed, async, inject } from '@angular/core/testing';

import { AuthenticationGaurdGuard } from './authentication-gaurd.guard';

describe('AuthenticationGaurdGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AuthenticationGaurdGuard]
    });
  });

  it('should ...', inject([AuthenticationGaurdGuard], (guard: AuthenticationGaurdGuard) => {
    expect(guard).toBeTruthy();
  }));
});
