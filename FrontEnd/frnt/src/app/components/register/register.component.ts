import { Component, OnInit } from '@angular/core';
import {MatToolbarModule, MatButtonModule, MatSlideToggle} from '@angular/material';

import {restaurant} from 'app/Models/restaurant';
import{RestaurantService} from 'app/Services/restaurant.service';
import {Router} from '@angular/router';
import {customer} from 'app/Models/customer';
import{CustomerService} from 'app/Services/customer.service';




@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {


  constructor(private rs:RestaurantService, private cs:CustomerService,private router:Router) { }

  checked: boolean = true;
  changeValue(value) {
      this.checked = !value;
  }

  async register(){
  
if(!this.checked){
    let username=((document.getElementById("username")as HTMLInputElement).value);
    let password=((document.getElementById("password")as HTMLInputElement).value);
    let  rest:restaurant = new restaurant(0,"",username,password,"","");
    
    let r:restaurant =await this.rs.addRestaurant(rest);
   this.router.navigate(['/','']);
     //  add like a fade in and out message for feedback to user to make him know he created an account

    }

  else {

    
    let username=((document.getElementById("username")as HTMLInputElement).value);
    let password=((document.getElementById("password")as HTMLInputElement).value);
    let  cust:customer = new customer(0,username,password);
    
    let c:customer =await this.cs.addCustomer(cust);

    this.router.navigate(['/','']);
  //  add like a fade in and out message for feedback to user to make him know he created an account
  }
  
    }


  ngOnInit() {
  }

}
