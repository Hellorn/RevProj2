import { Component, OnInit } from '@angular/core';

import { DataService } from './data.service';
import { Restaurant } from './restaurant';
import { google } from '@agm/core/services/google-maps-types';
import { PlusPipe } from './plus.pipe';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  [x: string]: any;
  lat: any;
  lng:any;
  
constructor (private dataService:DataService){}

async getLocation(){

  let pipe:PlusPipe=new PlusPipe();
  let p =pipe;
  let restaurant:Restaurant= await this.dataService.getRestaurantById(3);
  let add=restaurant.address ;
  let newaddress = p.transform(add);
  console.log(newaddress);
  let locationO:any = await this.dataService.getLocationByAddress(newaddress);
  console.log(locationO);
this.lat= locationO.results[0].geometry.location.lat;
 this.lng= locationO.results[0].geometry.location.lng;

}
  ngOnInit(){}

}


