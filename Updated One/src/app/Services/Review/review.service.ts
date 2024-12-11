import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, switchMap, throwError } from 'rxjs';
import { ReviewDTO } from 'src/app/DTO/ReviewDto';
import { Review } from 'src/app/Model/Review';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  baseURL:string = "http://localhost:3000/reviews/";

  constructor(private  http:HttpClient) {
    
    
    
  }
  addReview(review:ReviewDTO):Observable<Review>{


    return  this.http.post<Review>(this.baseURL,review);

}
getAll():Observable<Review[]>{

  return this.http.get<Review[]>(this.baseURL);


}
searchByReviewId(reviewId: number): Observable<any> {
  // return this.http.get<Review[]>(this.baseURL+"?reviewId="+reviewId);
  return this.http.get<any[]>(`${this.baseURL}?reviewId=${reviewId}`).pipe(
    switchMap((reviews) => {
      if (reviews.length === 0) {
        return throwError(() => new Error('Review not found.'));
      }
      return [reviews]; // Return the first matching review
    }),
    catchError((error) => throwError(() => error))
  );
  
  
}
updateReviewDetails(review:ReviewDTO):Observable<Review>{


  return   this.http.put<Review>(this.baseURL+review.reviewId, review);


}
findByUserId(userId:number):Observable<Review[]>{


  console.log(userId)
//  return this.http.get<Review[]>(this.baseURL+"?userId="+userId);
return this.http.get<any[]>(`${this.baseURL}?userId=${userId}`).pipe(
  switchMap((reviews) => {
    if (reviews.length === 0) {
      return throwError(() => new Error('Reviews not found.'));
    }
    return [reviews]; // Return the list of reviews
  }),
  catchError((error) => throwError(() => error))
);


}
findByBookingId(bookingId:number):Observable<Review[]>{


  console.log(bookingId)
//  return this.http.get<Review[]>(this.baseURL+"?bookingId="+bookingId);
return this.http.get<any[]>(`${this.baseURL}?bookingId=${bookingId}`).pipe(
  switchMap((reviews) => {
    if (reviews.length === 0) {
      return throwError(() => new Error('Reviews not found.'));
    }
    return [reviews]; // Return the list of reviews
  }),
  catchError((error) => throwError(() => error))
);


}

deleteById(reviewId:number):Observable<string>{
  console.log(reviewId);

  return  this.http.delete<string>(`http://localhost:3000/reviews/${reviewId}`);

}
}
