import { Component } from '@angular/core';
import { Review } from 'src/app/Model/Review';
import { ReviewService } from 'src/app/Services/Review/review.service';

@Component({
  selector: 'app-display-review-by-user-id',
  templateUrl: './display-review-by-user-id.component.html',
  styleUrls: ['./display-review-by-user-id.component.css']
})
export class DisplayReviewByUserIdComponent {
  reviewList: Review[] | null = null;
  searchError: string | null = null;
  isLoading: boolean = true;  // Flag to indicate loading state
  errorMessage: string = ''; 
  constructor(private reviewService: ReviewService) {}

  searchByUserId(formValue: any): void {
    const userId = formValue.userId;
    console.log(userId);
    if(!userId){
      this.searchError="Please Enter User Id";
      this.reviewList=null;
      console.log("Hello");
      return ;
    }
    this.reviewService.findByUserId(userId).subscribe(
      (paymentData) => {
        this.reviewList = paymentData; // Assign the fetched payment data to paymentList
        this.searchError = null; // Reset any error message
      },
      (error) => {
        this.searchError = "Payment Not Found for the given User ID.";
        this.reviewList = null; // Reset paymentList on error
      }
    );
  }
}
