import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ApiService } from 'src/app/shared/api.service';
import { StudentDetails } from 'src/Models/StudentDetails';
import { students } from 'src/Models/students';
@Component({
  selector: 'app-add-grade',
  templateUrl: './add-grade.component.html',
  styleUrls: ['./add-grade.component.css']
})
export class AddGradeComponent implements OnInit {

  
  studentmodelobj: students= new students();
  studentdata !: any;
  formvalue !: FormGroup;
  constructor( private formbuilder: FormBuilder, private api : ApiService ) { }
  ngOnInit(): void {
    this.formvalue= this.formbuilder.group({
      id: [''],
      name: [''],
      qualification:[''],
      branch:[''],
      address:[''],
      contactno:[''],
      grade:['']
    
      });
      this.getAllStudent();

   }

   getAllStudent(){
        this.api.getStudent()
        .subscribe(res=>{
          this.studentdata=res;
        })
   }

   onEdit(row:any){
    this.studentmodelobj.Id=row.studentId;
    this.formvalue.controls['grade'].setValue(row.studentGrade);
   }

   UpdateStudentGrade(data: any){
    this.studentdata.grade=this.formvalue.value.grade;
    this.api.UpdateStudent(this.studentmodelobj,this.studentmodelobj.Id,data.grade)
    .subscribe(res=>{
     alert("submited");
    })
   }

}