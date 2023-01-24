import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeasingContractFormComponent } from './leasing-contract-form.component';

describe('LeasingContractFormComponent', () => {
  let component: LeasingContractFormComponent;
  let fixture: ComponentFixture<LeasingContractFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LeasingContractFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LeasingContractFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
