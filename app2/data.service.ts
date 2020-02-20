import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Address} from './address.model';
import { Restaurant } from './restaurant';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http:HttpClient) { }
  

  getLocationByAddress(address:string):Promise<any>{
  
    return this.http.get<any>(`https://maps.googleapis.com/maps/api/geocode/json?address=${address}&key=AIzaSyDpcB8Oy8uGSnh4TWE2Z-ifM02gfInRIAs`).toPromise();
  
  }

  getRestaurantById(rid:number):Promise<Restaurant>{

    return this.http.get<Restaurant>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/getrestaurantbyid?id=${rid}`).toPromise();

  }
}
