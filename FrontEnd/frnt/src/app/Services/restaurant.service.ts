import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import{restaurant} from 'app/Models/restaurant';


@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  constructor(private http:HttpClient) { }

  
  

getRestaurantById (rid:number):Promise<restaurant>{
  let headers: HttpHeaders = new HttpHeaders();
  headers.append('Vary', "Origin");
  headers.append('Vary',"Access-Control-Allow-Origin");
  headers.append('Vary', "Access-Control-Request-Method");
  headers.append('Vary', "Access-Control-Request-Headers");
  headers.append('Content-Type', 'application/json');
    return this.http.get<restaurant>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/getrestaurantbyid?id=${rid}`,{headers}).toPromise();
  }

	getRestaurantByName(name:string):Promise<restaurant>{

    return this.http.get<restaurant>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/getrestaurantbyname/${name}`).toPromise();
  }

	getRestaurantByUsername(username:string):Promise<restaurant>{
    
    return this.http.get<restaurant>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/getrestaurantbyusername/${username}`).toPromise();
  }
  
 getAllRestaurants():Promise<restaurant>{

  return this.http.get<restaurant>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/getallrestaurants`).toPromise();
 }
 getRestaurantByCuisine(cuisine:string):Promise<restaurant>{

  return this.http.get<restaurant>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:999/getrestaurantsbycuisine?cuisine=${cuisine}`).toPromise();
 }
  
  login(manager:restaurant):Promise<restaurant>{

    return this.http.post<restaurant>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/loginrestaurant`,manager).toPromise();
  }
  
 addRestaurant(restaurant:restaurant):Promise<restaurant>{

  return this.http.post<restaurant>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/addrestaurant`,restaurant).toPromise();
 }

  deleteRestaurant(restaurant:restaurant):Promise<boolean>{

    return this.http.delete<boolean>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/deleterestaurant/${restaurant}`).toPromise();
  }
  
  updateRestaurant(restaurant:restaurant):Promise<restaurant>{

    return this.http.put<restaurant>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/updaterestaurant`,restaurant).toPromise();
  }
}