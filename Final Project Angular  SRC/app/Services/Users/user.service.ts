import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  baseURL: string = environment.apiUrl + "users/";
  constructor(private http: HttpClient) {}
  getUsers(): Observable<any[]> {
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
      return this.http.get<any[]>(this.baseURL + 'allusers');
    } else {
      // If no token, return an empty array or handle as required
      console.error('No token found');
      return new Observable<any[]>();
    }
  }
  registerUser(user: any): Observable<any> {
    return this.http.post<any>(this.baseURL+'add', user);
  }
}


