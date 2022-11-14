import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {AddStudentComponent} from "./components/add-student/add-student.component";
import {AuthenticationComponent} from "./components/authentication/authentication.component";
import {AuthGuardService} from "./service/authGuard.service";

const routes: Routes = [
  { path: "", redirectTo:"login", pathMatch:"full"},
  { path: 'login', component: AuthenticationComponent },
  { path:'home',component: HomeComponent,canActivate:[AuthGuardService]},
  { path:'addstudent', component: AddStudentComponent,canActivate:[AuthGuardService]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
