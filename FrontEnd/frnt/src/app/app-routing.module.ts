import { NgModule, Component } from '@angular/core';
import { HomeComponent } from './components/home/home.component';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './components/register/register.component';
import { CustomerviewComponent } from './components/customerview/customerview.component';
import { ManagerloginComponent } from './components/managerlogin/managerlogin.component';
import { ManagerpageComponent } from './components/managerpage/managerpage.component';
import { MealpageComponent } from './components/mealpage/mealpage.component';
import { AgmComponent } from './components/agm/agm.component'

const routes: Routes = [

  {path : "home" , component : HomeComponent},
  {path: "register", component : RegisterComponent},
  {path: "customerview", component : CustomerviewComponent},
  {path: "managerlogin", component : ManagerloginComponent},
  {path: "mealpage", component : MealpageComponent},
  {path:"agm" , component : AgmComponent}, 
  {path: "managerpage", component : ManagerpageComponent},
  {path : "**" , component :HomeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
