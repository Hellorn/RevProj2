import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-agm',
  templateUrl: './agm.component.html',
  styleUrls: ['./agm.component.css']
})
export class AgmComponent implements OnInit {

  lat:any;
  lng:any;

  constructor() { }

  

  
  

  ngOnInit() {

    let locationO = JSON.parse(sessionStorage.getItem('Location'));
    console.log(locationO);
   this.lat= locationO.results[0].geometry.location.lat;
   this.lng= locationO.results[0].geometry.location.lng;
   console.log(this.lat);
  
  }

}
