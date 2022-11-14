import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthenticationService} from "../../service/authentication.service";

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css']
})
export class AuthenticationComponent implements OnInit {
  username = '';
  password = '';
  invalidLogin = false

  constructor(private router: Router, private authenticationService: AuthenticationService) { }

  ngOnInit() {
  }

  checkLogin() {
    if (this.authenticationService.authenticate(this.username, this.password)) {
      this.router.navigate(['/home'])
      this.invalidLogin = false
    } else{
      this.invalidLogin = true
    }
  }

}
