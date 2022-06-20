import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {StudentDetails} from "src/Models/StudentDetails";

@Component({
  selector: 'app-view-registered-students',
  templateUrl: './view-registered-students.component.html',
  styleUrls: ['./view-registered-students.component.css']
})
export class ViewRegisteredStudentsComponent implements OnInit {
  listOfEnrolledStudents: StudentDetails[] = [];
  constructor(private http:HttpClient) { }


  ngOnInit(): void {

    this.http.get<any>("http://localhost:1901/professor/student").subscribe(
        (res:StudentDetails[])=>{
          this.listOfEnrolledStudents=res;
          console.log(this.listOfEnrolledStudents);
        },
        (err:HttpErrorResponse)=>{
        }
    );
  }

  updateMsg(obj){
  
    let index = this.listOfEnrolledStudents.indexOf(obj);
      obj.studentGrade = prompt("enter Grade for update");
      
      this.listOfEnrolledStudents[index] = obj;
    

  
  }

}
