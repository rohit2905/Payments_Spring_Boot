export class Transaction{
  constructor(public acc_no:number=0,
              public receiver_acc_no:number=0,
              public receiver_name:string="",
              public bic:string="",
              public amount:number=0,
              public message_code:string="",
              public transaction_type:string=""
              ){

  }
}
