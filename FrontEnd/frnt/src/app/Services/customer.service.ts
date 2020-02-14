import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http';
import { RequestOptions } from '@angular/common/http';
import{customer} from 'app/Models/customer';
@Injectable({
  providedIn: 'root'
})

// let headers = new Headers({ 'Content-Type': 'application/json' });

export class CustomerService {



  constructor(private http:HttpClient) { }

  getCustomerById(cid:number):Promise<customer>{

    return this.http.get<customer>(`http://ec2-18-216-238-187.us-east-2.compute.amazonaws.com:9999/getcustomer/${cid}`).toPromise();
  }

  getCustomerByUsername(username:string):Promise<customer>{
  
    return this.http.get<customer>(`http://ec2-18-216-238-187.us-east-2.compute.amazonaws.com:9999/getcustomerbyusername/${username}`).toPromise();
  }
  login(user:customer):Promise<customer>{
   
    return this.http.post<customer>(`http://ec2-18-216-238-187.us-east-2.compute.amazonaws.com:9999/logincustomer`,user).toPromise();
  }

  addCustomer(user:customer):Promise<customer>{

    return this.http.post<customer>(`http://ec2-18-216-238-187.us-east-2.compute.amazonaws.com:9999/addcustomer`,user).toPromise();

  }
    
  deleteCustomer(user:customer):Promise<boolean>{

    return this.http.delete<boolean>(`http://ec2-18-216-238-187.us-east-2.compute.amazonaws.com:9999/addcustomer`).toPromise();

  }
  
  
  updateCustomer(user:customer):Promise<customer>{

    return this.http.put<customer>(`http://ec2-18-216-238-187.us-east-2.compute.amazonaws.com:9999/deletecustomer`,user).toPromise();

  }


}
