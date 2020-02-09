import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { ReactiveFormsModule } from '@angular/forms';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/register/register.component';
import { CustomerviewComponent } from './components/customerview/customerview.component';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { ManagerloginComponent } from './components/managerlogin/managerlogin.component';
import { ManagerpageComponent } from './components/managerpage/managerpage.component';
import { MealpageComponent } from './components/mealpage/mealpage.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegisterComponent,
    CustomerviewComponent,
    ManagerloginComponent,
    ManagerpageComponent,
    MealpageComponent
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    MatCheckboxModule,
    FormsModule,
    ReactiveFormsModule,
    NgMultiSelectDropDownModule.forRoot() 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
