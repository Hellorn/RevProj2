import { Component, OnInit } from '@angular/core';
import {IDropdownSettings} from 'ng-multiselect-dropdown';

@Component({
  selector: 'app-customerview',
  templateUrl: './customerview.component.html',
  styleUrls: ['./customerview.component.css']
})
export class CustomerviewComponent implements OnInit {

  dropdownSettings:IDropdownSettings;
  dropdownList = [];
  selectedItems = [];
  

  // constructor() { }
 

  ngOnInit() {

    this.dropdownList = [
      { item_id: 1, item_text: 'Mexican' },
      { item_id: 2, item_text: 'Japanese' },
      { item_id: 3, item_text: 'Chinese' },
      { item_id: 4, item_text: 'American' },
      { item_id: 5, item_text: 'Italian' },
      { item_id: 6, item_text: 'Indian' },
     { item_id: 7, item_text: 'Mediterranean' }
    ];

    this.selectedItems = [
    
    ];

    this.dropdownSettings = {
      singleSelection: false,
      idField: 'item_id',
      textField: 'item_text',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };
  }
  onItemSelect(item: any) {
    console.log(item);
  }
  onSelectAll(items: any) {
    console.log(items);
  }


}


