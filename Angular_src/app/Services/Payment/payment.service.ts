import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Payment } from 'src/app/Model/Payment';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  baseURL:string = "http://localhost:8080/api/payments/";

  constructor(private  http:HttpClient) {
    
    
    
  }
  addPlayer(payment:Payment):Observable<Payment>{


    return  this.http.post<Payment>(this.baseURL+"addnewpayment",payment);

}

getAll():Observable<Payment[]>{

  return this.http.get<Payment[]>(this.baseURL+"getallpayments");


}
findByPaymentId(paymentId:number):Observable<Payment>{


  console.log(paymentId)
 return this.http.get<Payment>(this.baseURL+`paymentbyid/${paymentId}`);
}
findByUserId(userId:number):Observable<Payment[]>{


  console.log(userId)
 return this.http.get<Payment[]>(this.baseURL+`user/${userId}`);

}
// findByBookingId(bookingId:number):Observable<Payment[]>{


//   console.log(bookingId)
//  return this.http.get<Payment[]>(this.baseURL+`user/${bookingId}`);

// }
// updatePaymentStatus(payment:Payment):Observable<Payment>{
//   return this.http.put<Payment>(this.baseURL+`updatepayment/${payment.paymentId}/${payment.paymentStatus}`);
// }



}
