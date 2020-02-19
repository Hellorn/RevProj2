import { Component, OnInit } from '@angular/core';

import{meal} from 'app/Models/meal';


@Component({
  selector: 'app-mealpage',
  templateUrl: './mealpage.component.html',
  styleUrls: ['./mealpage.component.css']
})
export class MealpageComponent implements OnInit {

  constructor() { }

  meals:Array<meal> = [];
  ngOnInit() {
    let m:meal[] = JSON.parse(sessionStorage.getItem('Meals'));
    console.log(m)

    for(let i = 0; i < Object.keys(m).length; i++){
      this.meals.push(m[i]);
    }

  }

}
