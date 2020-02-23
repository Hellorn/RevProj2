import { Component, OnInit } from '@angular/core';
import{meal} from 'app/Models/meal';
import{MealService} from 'app/Services/meal.service';
import { restaurant } from 'app/Models/restaurant';
import { RestaurantService } from 'app/Services/restaurant.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-managerpage',
  templateUrl: './managerpage.component.html',
  styleUrls: ['./managerpage.component.css']
})

export class ManagerpageComponent implements OnInit {

  constructor(private ms:MealService,private rs:RestaurantService, private router:Router) { }
  meals:Array<meal> = [];
  
  async addMeal(){
    this.meals = [];
    let item=((document.getElementById("item")as HTMLInputElement).value);
    let cost=((document.getElementById("cost")as HTMLInputElement).valueAsNumber);
    let cal=((document.getElementById("cal")as HTMLInputElement).valueAsNumber);

    console.log(cost);

    if(item === "" || Number.isNaN(cost)    || Number.isNaN(cal)){
      
      alert("Please fill out all the fields!")
      this.viewMeal();
    }
    else{

    let restaurant:restaurant = JSON.parse(sessionStorage.getItem('Restaurant'));
    let cuisine=(restaurant.cuisine);
    let me:meal = new meal(0,item,cal,cost,restaurant,cuisine);
    let m:meal =await this.ms.addMeal(me);

    let menu:meal[] = await this.ms.getMealsByRestaurant(restaurant.rid);


    for(let i = 0; i < Object.keys(menu).length; i++){
      this.meals.push(menu[i]);
    }
    
    console.log(menu);
      
  }
  }
  async viewMeal(){
    this.meals = [];
    let restaurant:restaurant = JSON.parse(sessionStorage.getItem('Restaurant'));
    let menu:meal[] = await this.ms.getMealsByRestaurant(restaurant.rid);
    for(let i = 0; i < Object.keys(menu).length; i++){
      this.meals.push(menu[i]);
    }
    
    console.log(menu);
      
  }

  ngOnInit() {
    let restauran:restaurant = JSON.parse(sessionStorage.getItem('Restaurant'));
    console.log(restauran)
    if (restauran.name == "") {
      this.router.navigate(['/','managercreate']);
    }
    this.viewMeal();
  }

}
