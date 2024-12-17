import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JwtClientService {
  constructor(private http:HttpClient) { }


  baseURL:string = 'http://localhost:8080/api/';

  getGeneratedToken(requestBody: any){

      return this.http.post(this.baseURL+"users/login",requestBody,{responseType: 'text' as 'json'});

  }

  authorizationTest(token: any) {
    try {
        let tokenString = `Bearer ${token}`;
        console.log("This is my token: " + tokenString);

        const headersToken = new HttpHeaders({
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': 'http://localhost:4200'
        }).set("Authorization", tokenString);

        console.log("HEY " + JSON.stringify(headersToken));

        return this.http.get(this.baseURL + "reviews/getall", {headers:headersToken, responseType: 'text' as 'json' });
    } catch (error) {
        console.error("An error occurred during the authorization test:", error);
        throw error; // Optionally rethrow or handle error as per your application's logic
    }
}
// authorizationTest(token: any) {
//   const tokenString = `Bearer ${token}`;
//   console.log("Using token: " + tokenString);

//   const headers = new HttpHeaders({
//     'Content-Type': 'application/json',
//     'Authorization': tokenString,
//   });

//   console.log("Request headers: ", headers);

//   return this.http.get<string>(`${this.baseURL}all/reviews`, {
//     headers: headers,
//     responseType: 'text' as 'json',
//   });
// }
}



