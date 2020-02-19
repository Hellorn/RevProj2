import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import{meal} from 'app/Models/meal';
import{restaurant} from 'app/Models/restaurant'

@Injectable({
  providedIn: 'root'
})
export class MealService {

  constructor(private http:HttpClient) { }

  addMeal(meal:meal):Promise<meal>{
    return this.http.post<meal>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/addmeal`,meal).toPromise();
  }

	updateMeal(meal:meal):Promise<meal>{
    return this.http.put<meal>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/updatemeal`,meal).toPromise();

  }
  getMealById(mid:number):Promise<meal>{

    return this.http.get<meal>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/getrestaurantbyid/${mid}`).toPromise();
  }
  
  
  getMealsLessThanCalories(cal:number):Promise<meal>{
    
    return this.http.get<meal>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/getmealslessthancalories/${cal}`).toPromise();
  }
  
  getMealsByRestaurant(id:number):Promise<Array<meal>>{
    let headers: HttpHeaders = new HttpHeaders();
    headers.append('Vary', "Origin");
    headers.append('Vary',"Access-Control-Allow-Origin");
    headers.append('Vary', "Access-Control-Request-Method");
    headers.append('Vary', "Access-Control-Request-Headers");
    headers.append('Content-Type', 'application/json');
    return this.http.get<Array<meal>>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/getmealbyrestaurantid?id=${id}`,{headers}).toPromise();
  }
  
  getMealByCuisine(cuisine:string):Promise<meal>{

    return this.http.get<meal>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/getmealbycuisine/${cuisine}`).toPromise();
  }
  
  getMealByCuisineAndCost(cuisine:string,cost:number):Promise<meal>{

    return this.http.get<meal>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/getmealmycuisineandcost/${cuisine}&${cost}`).toPromise();
  }
  
  getmealByCriteria(cuisine:string,calories:number, cost:number){

    return this.http.get<meal>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/getmealbycriteria?cuisine=${cuisine}&calories=${calories}&cost=${cost}`).toPromise();

  }
  
  getAllMeals():Promise<meal>{

    return this.http.get<meal>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/getallmeals`).toPromise();
  }
  
 deleteMeal(meal:meal):Promise<boolean>{
  return this.http.delete<boolean>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/deletemeal/${meal}`).toPromise();
  }
}
