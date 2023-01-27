import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeasingContractListComponent } from './leasing-contract-list.component';

describe('LeasingContractListComponent', () => {
  let component: LeasingContractListComponent;
  let fixture: ComponentFixture<LeasingContractListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LeasingContractListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LeasingContractListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
