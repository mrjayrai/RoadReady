import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map, Observable, switchMap, throwError } from 'rxjs';
import { PaymentDTO } from 'src/app/DTO/PaymentDto';
import { Payment } from 'src/app/Model/Payment';
import { environment } from '../../../environments/environment';
// Author:Rajeshwari
// Date:07-12-2024

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  baseURL:string = environment.apiUrl+"payments/";

  constructor(private  http:HttpClient) {
    
    
    
  }
  addPayment(payment:PaymentDTO):Observable<Payment>{


    return  this.http.post<Payment>(this.baseURL+"addnewpayment",payment);

}

getAll():Observable<Payment[]>{

  return this.http.get<Payment[]>(this.baseURL+"getallpayments");


}

//  searchByPaymentId(paymentId: number): Observable<any> {
//   return this.http.get<any[]>(`${this.baseURL}paymentbyid/${paymentId}`).pipe(
//     switchMap((payments) => {
//       if (payments.length === 0) {
//         return throwError(() => new Error('Payment not found.'));
//       }
//       return [payments[0]]; // Return the first matching payment
//     }),
//     catchError((error) => throwError(() => error))
//   );
// }
searchByPaymentId(paymentId: number): Observable<any> {
  return this.http.get<any[]>(`${this.baseURL}paymentbyid/${paymentId}`).pipe(
    map((payments) => {
      if (!payments || payments.length === 0) {
        throw new Error('Payment not found.');
      }
      return payments; // Return the first matching payment directly
    }),
    catchError((error) => throwError(() => new Error(error.message || 'Error fetching payment data')))
  );
}

updatePaymentStatus(paymentId: number, paymentStatus:string): Observable<any> {
  return this.searchByPaymentId(paymentId).pipe(
    switchMap((payment) => {
      // const uniqueId = paymentId; // Extract the unique ID
      const uniqueId="752c";
      return this.http.put(`${this.baseURL}updatepayment/${paymentId}/${paymentStatus}`, null);
    }),
    catchError((error) => throwError(() => error))
  );
}
findByUserId(userId:number):Observable<Payment[]>{


  console.log(userId)
//  return this.http.get<Payment[]>(this.baseURL+"?userId="+userId);
 return this.http.get<any[]>(this.baseURL+`getbyuserid/${userId}`).pipe(
  switchMap((payments) => {
    if (payments.length === 0) {
      return throwError(() => new Error('Payment not found.'));
    }
    return [payments]; // Return the first matching payment
  }),
  catchError((error) => throwError(() => error))
);

}
// findByUserId(userId: number): Observable<Payment[]> {
//   console.log(userId);

//   return this.http.get<Payment[]>(`${this.baseURL}getbyuserid/${userId}`).pipe(
//     map((payments) => {
//       if (!payments || payments.length === 0) {
//         throw new Error('Payments not found.');
//       }
//       return payments; // Return the list of payments
//     }),
//     catchError((error) => throwError(() => new Error(error.message || 'Error fetching payments')))
//   );
// }





}
