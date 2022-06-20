import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewRegisterCoursesComponent } from './view-register-courses.component';

describe('ViewRegisterCoursesComponent', () => {
  let component: ViewRegisterCoursesComponent;
  let fixture: ComponentFixture<ViewRegisterCoursesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewRegisterCoursesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewRegisterCoursesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
