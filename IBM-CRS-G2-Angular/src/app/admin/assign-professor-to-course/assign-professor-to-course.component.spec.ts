import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignProfessorToCourseComponent } from './assign-professor-to-course.component';

describe('AssignProfessorToCourseComponent', () => {
  let component: AssignProfessorToCourseComponent;
  let fixture: ComponentFixture<AssignProfessorToCourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssignProfessorToCourseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AssignProfessorToCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
