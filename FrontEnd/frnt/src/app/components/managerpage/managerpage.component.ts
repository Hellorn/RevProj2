import { Component, OnInit } from '@angular/core';
import{meal} from 'app/Models/meal';
import{MealService} from 'app/Services/meal.service';
import { restaurant } from 'app/Models/restaurant';
import { RestaurantService } from 'app/Services/restaurant.service';

@Component({
  selector: 'app-managerpage',
  templateUrl: './managerpage.component.html',
  styleUrls: ['./managerpage.component.css']
})

export class ManagerpageComponent implements OnInit {

  constructor(private ms:MealService,private rs:RestaurantService) { }
  meals:Array<meal> = [];
  
  async addMeal(){

    let item=((document.getElementById("item")as HTMLInputElement).value);
    let cost=((document.getElementById("cost")as HTMLInputElement).valueAsNumber);
    let cal=((document.getElementById("cal")as HTMLInputElement).valueAsNumber);
    let cuisine=((document.getElementById("cuisine")as HTMLInputElement).value);

    let restaurant:restaurant = JSON.parse(sessionStorage.getItem('Restaurant'));
    let  me:meal = new meal(0,item,cal,cost,restaurant,cuisine);
    let m:meal =await this.ms.addMeal(me);

    let menu:meal[] = await this.ms.getMealsByRestaurant(restaurant.rid);


    for(let i = 0; i < Object.keys(menu).length; i++){
      this.meals.push(menu[i]);
    }
    
    console.log(menu);
      
  }

  async addRestaurant(){

    let name=((document.getElementById("name")as HTMLInputElement).value);
    let address=((document.getElementById("address")as HTMLInputElement).value);
    let cuisine=((document.getElementById("cuisine")as HTMLInputElement).value);

    let restauran:restaurant = JSON.parse(sessionStorage.getItem('Restaurant'));
    
    let re:restaurant = await this.rs.getRestaurantById(restauran.rid);
    re.name=name;
    re.cuisine=cuisine;
   re.address=address;
   
     let r:restaurant =await this.rs.updateRestaurant(re);

  }

  ngOnInit() {
    let restauran:restaurant = JSON.parse(sessionStorage.getItem('Restaurant'));
    console.log(restauran)
  }

}
