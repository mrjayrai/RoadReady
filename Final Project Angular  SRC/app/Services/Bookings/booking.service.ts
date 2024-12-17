import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BookingDTO } from 'src/app/DTO/BookingDto';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  baseURL: string = environment.apiUrl + "booking/";
  constructor(private http: HttpClient) {}
  getBookings(): Observable<any[]> {
    const token = localStorage.getItem("token");

    if (token) {
      // Create the headers with the Bearer token
    //   const headers = new HttpHeaders({
    //     'Authorization': `Bearer ${token}`
    //   });
    //   const headersToken = new HttpHeaders({
    //     'Content-Type': 'application/json',
    //     'Access-Control-Allow-Origin': 'http://localhost:4200'
    // }).set("Authorization", "Bearer "+ token);

      // Send the GET request with headers
      return this.http.get<any[]>(this.baseURL + 'allbookings');
    } else {
      // If no token, return an empty array or handle as required
      console.error('No token found');
      return new Observable<any[]>();
    }
  }

  getUserBookings():Observable<any[]>{
    const token = localStorage.getItem("token");
    const email = localStorage.getItem("email");
    if (token) {
      // Create the headers with the Bearer token
    //   const headers = new HttpHeaders({
    //     'Authorization': `Bearer ${token}`
    //   });
    //   const headersToken = new HttpHeaders({
    //     'Content-Type': 'application/json',
    //     'Access-Control-Allow-Origin': 'http://localhost:4200'
    // }).set("Authorization", "Bearer "+ token);

      // Send the GET request with headers
      console.log(email);
      return this.http.get<any[]>(this.baseURL + 'bookingId/user/'+email);
    } else {
      // If no token, return an empty array or handle as required
      console.error('No token found');
      return new Observable<any[]>();
    }
  }

  createBooking(booking:any):Observable<any[]>{
    return  this.http.post<any[]>(this.baseURL+"add",booking);
  }
}


