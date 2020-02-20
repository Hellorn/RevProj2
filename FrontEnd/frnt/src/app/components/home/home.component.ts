import { Component, OnInit } from '@angular/core';
// import {MatToolbarModule, MatButtonModule} from '@angular/material';
import {customer} from 'app/Models/customer'
import {CustomerService} from 'app/Services/customer.service'
import {Router} from '@angular/router'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {
 
  
  constructor(private cs:CustomerService,private router: Router) { }


  // username=((document.getElementById("username")as HTMLInputElement).value);
  // password=((document.getElementById("password")as HTMLInputElement).value);
  
 
  async custlogin(){

  let username=((document.getElementById("username")as HTMLInputElement).value);
  let password=((document.getElementById("password")as HTMLInputElement).value);
  let  cust:customer = new customer(0,username,password);
  
  let c:customer =await this.cs.login(cust);
    
    if(c != null){
      let key = 'User'
    sessionStorage.setItem(key,JSON.stringify(c));
     let user = JSON.parse(sessionStorage.getItem(key))
      this.router.navigate(['/', 'customerview']);
      console.log(user);
    }
    else {
alert("User or password doesnt exist!");
    }

  }

  ngOnInit() {



}
}
