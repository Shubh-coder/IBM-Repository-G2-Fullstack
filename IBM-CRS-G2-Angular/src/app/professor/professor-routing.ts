import { NgModule } from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import { AddGradeComponent } from "./add-grade/add-grade.component";
 
import { ViewRegisteredStudentsComponent } from "./view-registered-students/view-registered-students.component";

const routes: Routes = [
    {path: "registered-student1", component: ViewRegisteredStudentsComponent},
    { path: "grade", component: AddGradeComponent}
];
@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
  })
  export class ProfessorRoutingModule { }

   