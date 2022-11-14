import { Component, OnInit } from '@angular/core';
import {HttpClientService} from "../../service/httpClient.service";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../service/authentication.service";
import {Student} from "../../model/Student";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  students!:Student[];
  username!:string;
  password!:string;
  constructor(private authService:AuthenticationService,private httpClientService:HttpClientService, private router:Router) { }

  async ngOnInit() {
    this.username=this.authService.getUserName();
    this.password=this.authService.getPassword();
    this.httpClientService.getStudents(this.username,this.password).subscribe(response=>this.students=response);
  }
  addStudent(){
    this.router.navigate(['/addstudent']);
  }
  logout(){
    this.authService.logOut(this.username,this.password);
    this.router.navigate(['login']);
  }
  deleteStudent(student: Student): void {
    this.httpClientService.deleteStudent(student,this.username,this.password).subscribe(data => {
        this.students = this.students.filter(s => s !== student);
      });
  };
}
