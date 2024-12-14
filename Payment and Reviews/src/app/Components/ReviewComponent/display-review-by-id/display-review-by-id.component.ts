import { Component } from '@angular/core';
import { Review } from 'src/app/Model/Review';
import { ReviewService } from 'src/app/Services/Review/review.service';

@Component({
  selector: 'app-display-review-by-id',
  templateUrl: './display-review-by-id.component.html',
  styleUrls: ['./display-review-by-id.component.css']
})
export class DisplayReviewByIdComponent {
  reviewList: Review[] | null = null;
  searchError: string | null = null;
  isLoading: boolean = true;  // Flag to indicate loading state
  errorMessage: string = ''; 
  constructor(private reviewService: ReviewService) {}

  searchByReviewId(formValue: any): void {
    const reviewId = formValue.reviewId;
    this.reviewService.searchByReviewId(reviewId).subscribe(
      (reviewData) => {
        this.reviewList = [reviewData]; // Assign the fetched payment data to paymentList
        this.searchError = null; // Reset any error message
      },
      (error) => {
        this.searchError = "Review Not Found for the given Payment ID.";
        this.reviewList = null; // Reset paymentList on error
      }
    );
  }
}
