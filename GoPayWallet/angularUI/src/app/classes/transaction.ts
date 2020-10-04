export class Transaction {
    constructor(public transactionId: number,
                public transactionType: String,
                public mssg: String,
                public amount: number,
                public currency: String,
                public dateOfTransaction: String){}
}
