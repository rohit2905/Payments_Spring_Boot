import { HttpClient } from '@angular/common/http';

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Customer } from './customer';
import { Institution } from './Instituion';
import { Message } from './message';

@Injectable({
  providedIn: 'root'
})
export class TransactionService  {

  url="http://localhost:8282/new_t";
 
  constructor(private http:HttpClient) { }
  public addTransaction(val:any){
    const headers={'Content-type':'application/json'}
    const body=JSON.stringify(val);
    return this.http.post(this.url, body, {headers:headers})
    
    
    }
    
    getValues(store:any):Observable<Customer>{
      let url="http://localhost:8282/customer/"+store;
      return this.http.get<Customer>(url).pipe(
        tap(customer=>{ 
          console.log(customer.acc_holder)
        })
      )
    }

    getInsti(store: any):Observable<Institution>{
        let url="http://localhost:8282/ebank/"+store;
        return this.http.get<Institution>(url).pipe(
          tap(ebank=>{ 
            console.log(ebank.institution_name)
          })
        )
    }

    getAllCodes():Observable<Message[]>{
      let url="http://localhost:8282/instruction";
      return this.http.get<Message[]>(url).pipe(
        tap(res=>{
          console.log(res);
        })
      )
      
    }
   
    
  }

