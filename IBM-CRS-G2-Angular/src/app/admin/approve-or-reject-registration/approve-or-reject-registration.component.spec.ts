import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApproveOrRejectRegistrationComponent } from './approve-or-reject-registration.component';

describe('ApproveOrRejectRegistrationComponent', () => {
  let component: ApproveOrRejectRegistrationComponent;
  let fixture: ComponentFixture<ApproveOrRejectRegistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApproveOrRejectRegistrationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ApproveOrRejectRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
