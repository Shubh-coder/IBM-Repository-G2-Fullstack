import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ProfessorRoutingModule} from "./professor-routing";
import {ProfessorComponent} from "./professor.component";
import { ViewRegisteredStudentsComponent } from "./view-registered-students/view-registered-students.component"; 
import { AddGradeComponent } from "./add-grade/add-grade.component";
import {HttpClientModule} from "@angular/common/http";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
@NgModule({
  declarations: [
    ProfessorComponent,
    ViewRegisteredStudentsComponent,
    AddGradeComponent,
  ],
  imports: [
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    CommonModule,
    ProfessorRoutingModule,
    ReactiveFormsModule
  ],
})
export class ProfessorModule { }









