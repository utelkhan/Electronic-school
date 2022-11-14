import { Component, OnInit} from '@angular/core';
import {HttpClientService} from "../../service/httpClient.service";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../service/authentication.service";
import {Student} from "../../model/Student";

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {
  student: Student=new Student(0,0,"","",0,0);
  private username!:string;
  private password!:string;
  constructor(private authService:AuthenticationService,private router: Router,private httpClientService: HttpClientService) { }

  ngOnInit(){
    this.username=this.authService.getUserName();
    this.password=this.authService.getPassword();
  }
  createStudent(){
    this.httpClientService.createStudent(this.student,this.username,this.password)
      .subscribe( data => {
        alert("Employee created successfully.");
      });
  };

}
