import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfessorComponent } from './professor/professor.component';
import { ViewRegisteredStudentsComponent } from './professor/view-registered-students/view-registered-students.component';
import { UserLoginComponent } from './user/user-login/user-login.component';
import { AddGradeComponent } from './professor/add-grade/add-grade.component';
 
const routes: Routes = [
  
  {path: "registered-student1", component: ViewRegisteredStudentsComponent},
  {path: "professor-Dashboard", component: ProfessorComponent},
  { path: "grade", component: AddGradeComponent},
  

  {path: "", component: UserLoginComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponent = [ViewRegisteredStudentsComponent, UserLoginComponent]
