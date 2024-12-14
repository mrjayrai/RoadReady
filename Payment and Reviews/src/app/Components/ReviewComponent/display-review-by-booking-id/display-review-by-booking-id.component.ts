import { Component } from '@angular/core';
import { Review } from 'src/app/Model/Review';
import { ReviewService } from 'src/app/Services/Review/review.service';

@Component({
  selector: 'app-display-review-by-booking-id',
  templateUrl: './display-review-by-booking-id.component.html',
  styleUrls: ['./display-review-by-booking-id.component.css']
})
export class DisplayReviewByBookingIdComponent {
  reviewList: Review[] | null = null;
  searchError: string | null = null;
  isLoading: boolean = true;  // Flag to indicate loading state
  errorMessage: string = ''; 
  constructor(private reviewService: ReviewService) {}

  searchByBookingId(formValue: any): void {
    const bookingId = formValue.bookingId;
    console.log(bookingId);
    if(!bookingId){
      this.searchError="Please Enter Booking Id";
      this.reviewList=null;
      console.log("Hello");
      return ;
    }
    this.reviewService.findByBookingId(bookingId).subscribe(
      (reviewData) => {
        this.reviewList = reviewData; // Assign the fetched payment data to paymentList
        this.searchError = null; // Reset any error message
      },
      (error) => {
        this.searchError = "Reviews Not Found for the given User ID.";
        this.reviewList = null; // Reset paymentList on error
      }
    );
  }
}
