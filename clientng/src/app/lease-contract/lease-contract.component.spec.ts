import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaseContractComponent } from './lease-contract.component';

describe('LeaseContractComponent', () => {
  let component: LeaseContractComponent;
  let fixture: ComponentFixture<LeaseContractComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LeaseContractComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LeaseContractComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
