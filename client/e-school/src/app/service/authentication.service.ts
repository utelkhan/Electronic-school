import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private username!:string;
  private password!:string;
  constructor(private httpClient:HttpClient) { }
  getUserName(){
    return this.username;
  }
  getPassword(){
    return this.password;
  }
  authenticate(username:string, password:string) {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    let resp = this.httpClient.get<string>('http://localhost:8080/authentication/',{headers,responseType: 'text' as 'json'});
    resp.subscribe(data=>{
      if(data.toString()==="You have successfully logged in!"){
        this.username=username;
        this.password=password;
        sessionStorage.setItem('username', username);
        sessionStorage.setItem('password', password);
        console.log(data.toString());
      }
    });
    let user = sessionStorage.getItem('username');
    return((user !== null));
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username');
    console.log(!(user === null));
    return !(user === null);
  }

  logOut(username:string, password:string) {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password)});
    this.httpClient.get<string>('http://localhost:8080/logout',{headers});
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('password');
  }
}
