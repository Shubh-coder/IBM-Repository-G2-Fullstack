export class StudentDetails{
    public Id: number;
    public name:string;
    public qualification:string;
    public branch:string;
    public address:string;
    public contact:string;
    public grade:string;  
    constructor(Id:number,name:string, qualification:string, branch:string, address:string, contact:string, grade:string ){
      this.Id=Id;
      this.name=name;
      this.qualification=qualification;
      this.branch=branch;
      this.address=address;
      this.contact=contact;
      this.grade=grade;
    }
  }