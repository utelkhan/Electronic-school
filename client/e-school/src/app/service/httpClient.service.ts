import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Student} from "../model/Student";

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(private httpClient:HttpClient) {}

  public getStudents(username:string,password:string) {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    console.log("Getting all students");
    return this.httpClient.get<Student[]>('http://localhost:8080/student/getAll',{headers});
  }

  public deleteStudent(student:Student,username:string,password:string) {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    console.log("Deleting student where id is "+student.id);
    return this.httpClient.delete<string>("http://localhost:8080/student/delete" + "/"+ student.id,{headers});
  }

  public createStudent(student:Student,username:string,password:string) {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    console.log("Creating student");
    return this.httpClient.post<Student>("http://localhost:8080/student/add", student,{headers});
  }

}
