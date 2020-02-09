import { NgModule } from '@angular/core';
import { HomeComponent } from './components/home/home.component';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './components/register/register.component';
import { CustomerviewComponent } from './components/customerview/customerview.component';
import { ManagerloginComponent } from './components/managerlogin/managerlogin.component';
import { ManagerpageComponent } from './components/managerpage/managerpage.component';
import { MealpageComponent } from './components/mealpage/mealpage.component';



const routes: Routes = [

  {path : "home" , component : HomeComponent},
  {path: "register", component : RegisterComponent},
  {path: "customerview", component : CustomerviewComponent},
  {path: "managerlogin", component : ManagerloginComponent},
  {path: "customerview/mealpage", component : MealpageComponent},
  {path: "managerlogin/managerpage", component : ManagerpageComponent},
  {path : "**" , component :HomeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
