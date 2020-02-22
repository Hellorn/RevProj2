import { Component, OnInit } from '@angular/core';
import { restaurant } from 'app/Models/restaurant';
import { RestaurantService } from 'app/Services/restaurant.service';
import {Router} from '@angular/router';
import {IDropdownSettings} from 'ng-multiselect-dropdown';

@Component({
  selector: 'app-managercreate',
  templateUrl: './managercreate.component.html',
  styleUrls: ['./managercreate.component.css']
})
export class ManagercreateComponent implements OnInit {
  dropdownSettings:IDropdownSettings;
  dropdownList = [];
  selectedItem = [];

  constructor(private rs:RestaurantService, private router:Router) { }

  async addRestaurant(){

    let name=((document.getElementById("name")as HTMLInputElement).value);
    let address=((document.getElementById("address")as HTMLInputElement).value);
    let cuisine = this.selectedItem[0].item_text;

    let restauran:restaurant = JSON.parse(sessionStorage.getItem('Restaurant'));
    
    let re:restaurant = await this.rs.getRestaurantById(restauran.rid);
    re.name=name;
    re.cuisine=cuisine;
    re.address=address;
   
     let r:restaurant =await this.rs.updateRestaurant(re);
     if(r != null){
        
      let key = 'Restaurant';
      sessionStorage.setItem(key,JSON.stringify(r));
     }
     console.log(restauran);
     this.router.navigate(['/','managerpage']);
  }


  ngOnInit() {
    let restauran:restaurant = JSON.parse(sessionStorage.getItem('Restaurant'));
    console.log(restauran)
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

}
