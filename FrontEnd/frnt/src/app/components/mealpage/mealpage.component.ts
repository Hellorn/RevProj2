import { Component, OnInit } from '@angular/core';
import{meal} from 'app/Models/meal';
import{restaurant} from 'app/Models/restaurant';
import { RestaurantService } from 'app/Services/restaurant.service';
import { AgmService } from 'app/Services/agm.service';
import { PlusPipe } from 'app/Pipes/plus.pipe';
import { Router } from '@angular/router';


@Component({
  selector: 'app-mealpage',
  templateUrl: './mealpage.component.html',
  styleUrls: ['./mealpage.component.css']
})
export class MealpageComponent implements OnInit {

  constructor(private as:AgmService , private rs:RestaurantService , private router:Router) { }

  meals:Array<meal> = [];
  ngOnInit() {
    let m:meal[] = JSON.parse(sessionStorage.getItem('Meals'));
    console.log(m)

    for(let i = 0; i < Object.keys(m).length; i++){
      this.meals.push(m[i]);
    }
  }

  async selectItem(x:meal){
    console.log(x);
    let pipe:PlusPipe=new PlusPipe();
    let p =pipe;
    let rid =x.restaurant.rid;
    console.log(rid);

    let restaurant:restaurant= await this.rs.getRestaurantById(rid);
    let add=restaurant.address ;
    let newaddress = p.transform(add);
    console.log(newaddress);
    let locationO:any = await this.as.getLocationByAddress(newaddress);
    console.log(locationO);
 
    let key = 'Location'
    sessionStorage.setItem(key,JSON.stringify(locationO));
     //let l = JSON.parse(sessionStorage.getItem(key))

      this.router.navigate(['/', 'agm']);
  }

}
