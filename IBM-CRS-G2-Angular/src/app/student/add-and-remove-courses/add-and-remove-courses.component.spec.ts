import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAndRemoveCoursesComponent } from './add-and-remove-courses.component';

describe('AddAndRemoveCoursesComponent', () => {
  let component: AddAndRemoveCoursesComponent;
  let fixture: ComponentFixture<AddAndRemoveCoursesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddAndRemoveCoursesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddAndRemoveCoursesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
