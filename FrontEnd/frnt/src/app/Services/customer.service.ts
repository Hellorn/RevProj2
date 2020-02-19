import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http';

import{customer} from 'app/Models/customer';
import { RequestOptions } from '@angular/common/http';
import{customer} from 'app/Models/customer';

@Injectable({
  providedIn: 'root'
})

// let headers = new Headers({ 'Content-Type': 'application/json' });

export class CustomerService {



  constructor(private http:HttpClient) { }


  // getLocationByAddress(location:string):Promise<Coordinates>{

  //   return this.http.get<Coordinates>(`googleapi.com/${location}`).toPromise();
  // }

  getCustomerById(cid:number):Promise<customer>{

    return this.http.get<customer>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/getcustomer/${cid}`).toPromise();

  }

  getCustomerByUsername(username:string):Promise<customer>{
  

    return this.http.get<customer>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/getcustomerbyusername/${username}`).toPromise();
  }
  login(user:customer):Promise<customer>{
   
    return this.http.post<customer>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/logincustomer`,user).toPromise();

   
  }

  addCustomer(user:customer):Promise<customer>{


    return this.http.post<customer>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/addcustomer`,user).toPromise();


  }
    
  deleteCustomer(user:customer):Promise<boolean>{


    return this.http.delete<boolean>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/deletecustomer/${user}`).toPromise();


  }
  
  
  updateCustomer(user:customer):Promise<customer>{


    return this.http.put<customer>(`http://ec2-3-133-58-111.us-east-2.compute.amazonaws.com:9999/updatecustomer`,user).toPromise();


  }


}
