import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarService {
  baseURL: string = environment.apiUrl + "cars/";

  constructor(private http: HttpClient) {}

  getCars(): Observable<any[]> {
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
      return this.http.get<any[]>(this.baseURL + 'getcars');
    } else {
      // If no token, return an empty array or handle as required
      console.error('No token found');
      return new Observable<any[]>();
    }
  }
}
