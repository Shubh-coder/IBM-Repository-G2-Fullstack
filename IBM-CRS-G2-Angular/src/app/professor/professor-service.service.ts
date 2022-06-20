 import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ProfessorServiceService {
  // this is setting the header to accept the data in the form of json.
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');
  
  constructor(private httpClient:HttpClient) { }
 
  // this is a get method implementation
  getStudent(): Observable<any>{
    let getStudentUrl:string = "http://localhost:1901/professor/student";
    return this.httpClient.get(getStudentUrl,{headers: this.headers});
  }
}