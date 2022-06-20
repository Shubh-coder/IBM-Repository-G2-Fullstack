import { NgModule } from '@angular/core';
 
import { ReactiveFormsModule} from '@angular/forms' 
import { FormsModule } from '@angular/forms'  
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProfessorComponent } from './professor/professor.component';
import { StudentComponent } from './student/student.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { ViewRegisteredStudentsComponent } from './professor/view-registered-students/view-registered-students.component';
import { AddGradeComponent } from './professor/add-grade/add-grade.component';
import { ListCoursesComponent } from './student/list-courses/list-courses.component';
import { AddAndRemoveCoursesComponent } from './student/add-and-remove-courses/add-and-remove-courses.component';
import { ViewRegisterCoursesComponent } from './student/view-register-courses/view-register-courses.component';
import { PaymentComponent } from './student/payment/payment.component';
import { AssignProfessorToCourseComponent } from './admin/assign-professor-to-course/assign-professor-to-course.component';
import { ApproveOrRejectRegistrationComponent } from './admin/approve-or-reject-registration/approve-or-reject-registration.component';
import { UserRegistrationComponent } from './user/user-registration/user-registration.component';
import { UserLoginComponent } from './user/user-login/user-login.component';
import { ResetPasswordComponent } from './user/reset-password/reset-password.component';
import { HttpClientModule } from '@angular/common/http';
import { ProfessorServiceService } from './professor/professor-service.service';
@NgModule({
  declarations: [
    AppComponent,
    ProfessorComponent,
    StudentComponent,
    AdminComponent,
    UserComponent,
    ViewRegisteredStudentsComponent,
    AddGradeComponent,
    ListCoursesComponent,
    AddAndRemoveCoursesComponent,
    ViewRegisterCoursesComponent,
    PaymentComponent,
    AssignProfessorToCourseComponent,
    ApproveOrRejectRegistrationComponent,
    UserRegistrationComponent,
    UserLoginComponent,
    ResetPasswordComponent
  ],
  imports: [
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
    
  ],
  providers: [ProfessorServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
