import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class AgmService {
  

  constructor(private http:HttpClient) { }

  getLocationByAddress(address:string):Promise<any>{
  
    return this.http.get<any>(`https://maps.googleapis.com/maps/api/geocode/json?address=${address}&key=AIzaSyDpcB8Oy8uGSnh4TWE2Z-ifM02gfInRIAs`).toPromise();
  
  }

}
