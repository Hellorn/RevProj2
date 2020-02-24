import { Component, OnInit } from '@angular/core';
import {IDropdownSettings} from 'ng-multiselect-dropdown';
import{meal} from 'app/Models/meal';
import{MealService} from 'app/Services/meal.service';
import { Router } from '@angular/router';
import { analyzeAndValidateNgModules } from '@angular/compiler';

@Component({
  selector: 'app-customerview',
  templateUrl: './customerview.component.html',
  styleUrls: ['./customerview.component.css']
})

export class CustomerviewComponent implements OnInit {

  dropdownSettings:IDropdownSettings;
  dropdownList = [];
  selectedItem = [null];

  constructor(private ms:MealService, private router:Router) { }

async getMeals(){

  let calories=((document.getElementById("calories")as HTMLInputElement).valueAsNumber);
  let cost=((document.getElementById("cost")as HTMLInputElement).valueAsNumber);
  let cuisine = this.selectedItem[0].item_text;

  if( Number.isNaN(cost)    || Number.isNaN(calories)){
   
    console.log(calories);
    console.log(cost);
  
   console.log(cuisine);
    let me:meal = await this.ms.getMealByCuisine(cuisine);
    console.log(me);
  
    let key = 'Meals';
    sessionStorage.setItem(key,JSON.stringify(me));
     let mel = JSON.parse(sessionStorage.getItem(key));
      this.router.navigate(['/','mealpage']);
  }

  else{

    
  console.log(calories);
  console.log(cost);

 console.log(cuisine);
  let me:meal = await this.ms.getmealByCriteria(cuisine,calories,cost);
  console.log(me);

  let key = 'Meals';
  sessionStorage.setItem(key,JSON.stringify(me));
   let mel = JSON.parse(sessionStorage.getItem(key));
    this.router.navigate(['/','mealpage']);

}
}
  ngOnInit() {

    this.dropdownList = [
      { item_id: 1, item_text: 'Mexican' },
      { item_id: 2, item_text: 'Japanese' },
      { item_id: 3, item_text: 'Chinese' },
      { item_id: 4, item_text: 'American' },
      { item_id: 5, item_text: 'Italian' },
      { item_id: 6, item_text: 'Indian' },
      {item_id: 7, item_text: 'Mediterranean'}
    ];

    this.selectedItem = [
      { item_id: 4, item_text: 'American' }
    ];

    this.dropdownSettings = {
      singleSelection: true,
      idField: 'item_id',
      textField: 'item_text',
      // selectAllText: 'Select All',
      // unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };

  }

  onItemSelect(item: any) {
    console.log(item);
  }

  user = JSON.parse(sessionStorage.getItem('User'));

}


