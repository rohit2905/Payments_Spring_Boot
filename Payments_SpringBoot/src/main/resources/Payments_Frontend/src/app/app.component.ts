import { TransactionService } from './transaction.service';
import { Component, ViewChild } from '@angular/core';
import { Transaction } from './transaction';
import { map } from 'rxjs/operators';

import { Message } from './message';
import { MatDialog } from '@angular/material/dialog';
import { DialogBoxComponent } from './dialog-box/dialog-box.component';





@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'payments';
  num:number;
  status:any;
  model: Transaction = new Transaction();
  @ViewChild('f')
  form:any
  store:any;
  acc_holder_name:any;
  acc_credit_bal:any;
  bic:any;
  ins:any;
  tid:any;
  bal:any;
  b:any;

 show:boolean=false;
  message_codes:Message[];
  constructor(private ts:TransactionService, private dialog:MatDialog){
    this.getMssgs();
  }


  getMssgs(){
    this.ts.getAllCodes().subscribe(
      res=>{
        this.message_codes=res;
        console.log(res);
      }
    )
  }

  onadd(){
    
    console.log(this.form.value);
    this.status = this.ts.addTransaction(this.form.value).pipe(map(res =>{
      
      this.status=JSON.parse(JSON.stringify(res))["message"];
      this.tid=JSON.parse(JSON.stringify(res))["tid"];
      if(this.status == "Transaction Accepted"){
        this.show=true;
      }else{
        this.show=false;
      }
      
       let dialogRef= this.dialog.open(DialogBoxComponent,{data:{status:this.status,tid:this.tid, show:this.show,b:this.b},disableClose:true, panelClass:'my-class'});
      dialogRef.afterClosed().subscribe(result =>{
          if(result){
            window.location.reload();
          }
        })
    })).subscribe();
   
  }

  onCheck($event: any){
    this.store = $event.target.value;
    this.b=this.store;
    this.ts.getValues(this.store).subscribe(
      customer=>{
        console.log(customer)
        this.acc_holder_name=customer.acc_holder;
        this.acc_credit_bal=customer.credit_balance;
      }
    );
    
   
  }
  getBIC($event: any){
    this.store = $event.target.value;
    this.ts.getInsti(this.store).subscribe(
      ebank=>{
        this.bic=ebank.BIC
        this.ins=ebank.institution_name
      }
    )
  }
  


}
