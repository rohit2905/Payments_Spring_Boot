import { Component, OnInit,Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { TransactionService } from '../transaction.service';

@Component({
  selector: 'app-dialog-box',
  templateUrl: './dialog-box.component.html',
  styleUrls: ['./dialog-box.component.css']
})
export class DialogBoxComponent implements OnInit {
  
  clic:boolean=false;
  constructor(@Inject(MAT_DIALOG_DATA) public data:any, public dref:MatDialogRef<DialogBoxComponent>, public ts: TransactionService) { }
  
 bal:any;
 btext:string="Show Balance";
  ngOnInit(): void {}
  onc(){
    this.clic=!this.clic;
    if(this.clic){
      this.btext="Hide Balance"
    }
    else{
      this.btext="Show Balance";
    }
    this.ts.getValues(this.data.b).subscribe(
      customer=>{
        console.log(customer)
        this.bal=customer.credit_balance;
      }
    );
   
  }
 

}
