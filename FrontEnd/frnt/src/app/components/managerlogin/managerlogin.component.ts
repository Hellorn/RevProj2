import { Component, OnInit } from '@angular/core';
import {restaurant} from 'app/Models/restaurant';
import{RestaurantService} from 'app/Services/restaurant.service';
import {Router} from '@angular/router';


@Component({
  selector: 'app-managerlogin',
  templateUrl: './managerlogin.component.html',
  styleUrls: ['./managerlogin.component.css']
})
export class ManagerloginComponent implements OnInit {

  constructor(private rs:RestaurantService, private router:Router) { }

  async manalogin(){

    let username=((document.getElementById("username")as HTMLInputElement).value);
    let password=((document.getElementById("password")as HTMLInputElement).value);
    let  rest:restaurant = new restaurant(0,"",username,password,"","");
    
    let r:restaurant =await this.rs.login(rest);
      //console.log(r);

      if(r != null){
        
        let key = 'Restaurant';
      sessionStorage.setItem(key,JSON.stringify(r));
       let restaurant = JSON.parse(sessionStorage.getItem(key));
        this.router.navigate(['/','managerpage']);
        //console.log(restaurant);
      }
      else {
  alert("User or password doesnt exist!");
      }
  
    }
  

  ngOnInit() {
  }

}
