import { Injectable } from '@angular/core';
import { HttpClient, HttpClientJsonpModule } from '@angular/common/http'
import {map} from 'rxjs/operators'
@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor( private http : HttpClient) {}

     UpdateStudent(data : any,id:number,grade:string ){
       return this.http.put<any>("http://localhost:1901/professor/student/"+id+"/"+grade,data)
        .pipe(map((res:any)=>{
          return res;
        }))
              
      }

       getStudent(){
        return this.http.get<any>("http://localhost:1901/professor/student/")
         .pipe(map((res:any)=>{
           return res;
         }))
               
       }
   
    }

