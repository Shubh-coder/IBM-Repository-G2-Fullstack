import { Component, OnInit } from '@angular/core';
import { ProfessorServiceService  } from './professor-service.service';

@Component({
  selector: 'app-professor',
  templateUrl: './professor.component.html',
  styleUrls: ['./professor.component.css']
})
export class ProfessorComponent implements OnInit {
  getData: any[] = [];
  constructor(private _httpService: ProfessorServiceService) { }

  ngOnInit(): void {
  }


  getStudentList(){
    this._httpService.getStudent().subscribe((res : any[])=>{
             console.log(res);
             this.getData = res;
  });
  }

}
