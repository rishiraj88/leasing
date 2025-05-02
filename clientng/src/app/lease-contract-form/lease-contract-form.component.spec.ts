import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaseContractFormComponent } from './lease-contract-form.component';

describe('LeaseContractFormComponent', () => {
  let component: LeaseContractFormComponent;
  let fixture: ComponentFixture<LeaseContractFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LeaseContractFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LeaseContractFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
