import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, switchMap, throwError } from 'rxjs';
import { PaymentDTO } from 'src/app/DTO/PaymentDto';
import { Payment } from 'src/app/Model/Payment';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  baseURL:string = "http://localhost:3000/payments";

  constructor(private  http:HttpClient) {
    
    
    
  }
  addPayment(payment:PaymentDTO):Observable<Payment>{


    return  this.http.post<Payment>(this.baseURL,payment);

}

getAll():Observable<Payment[]>{

  return this.http.get<Payment[]>(this.baseURL);


}

 searchByPaymentId(paymentId: number): Observable<any> {
  return this.http.get<any[]>(`${this.baseURL}?paymentId=${paymentId}`).pipe(
    switchMap((payments) => {
      if (payments.length === 0) {
        return throwError(() => new Error('Payment not found.'));
      }
      return [payments[0]]; // Return the first matching payment
    }),
    catchError((error) => throwError(() => error))
  );
}
updatePaymentStatus(paymentId: number, status: 'PENDING' | 'PAID' | 'FAILED'): Observable<any> {
  return this.searchByPaymentId(paymentId).pipe(
    switchMap((payment) => {
      // const uniqueId = paymentId; // Extract the unique ID
      const uniqueId="752c";
      return this.http.put(`${this.baseURL}/${uniqueId}`, { status });
    }),
    catchError((error) => throwError(() => error))
  );
}
findByUserId(userId:number):Observable<Payment[]>{


  console.log(userId)
//  return this.http.get<Payment[]>(this.baseURL+"?userId="+userId);
 return this.http.get<any[]>(`${this.baseURL}?user=${userId}`).pipe(
  switchMap((payments) => {
    if (payments.length === 0) {
      return throwError(() => new Error('Payment not found.'));
    }
    return [payments]; // Return the first matching payment
  }),
  catchError((error) => throwError(() => error))
);

}




}
