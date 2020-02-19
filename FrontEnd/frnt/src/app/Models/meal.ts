import { restaurant } from './restaurant';

export class meal{
    
    mid:number;
    name:string;
    calories:number;
    cost:number;
    cuisine:string;
    restaurant:restaurant;
  

    constructor(mid:number,name:string,calories:number,cost:number,restaurant:restaurant,cuisine:string){
        this.mid = mid;
        this.name = name;
        this.calories = calories;
        this.cost = cost;
        this.cuisine = cuisine;
        this.restaurant = restaurant;
}
}