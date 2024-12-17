import { Component } from '@angular/core';
import { Review } from 'src/app/Model/Review';
import { ReviewService } from 'src/app/Services/Review/review.service';

@Component({
  selector: 'app-display-all-review',
  templateUrl: './display-all-review.component.html',
  styleUrls: ['./display-all-review.component.css']
})
export class DisplayAllReviewComponent {
  reviews: Review[] = [];  // Array to store all reviews
  isLoading: boolean = true;  // Flag to indicate loading state
  errorMessage: string = '';  // Variable to store error message
  showButton: boolean = true;

  constructor(private reviewService: ReviewService) {}

  showAllReviews(){
    this.showButton = false;
    // Call getAll() method to fetch reviews when the component initializes
    this.reviewService.getAll().subscribe({
      next: (reviews) => {
        console.log(reviews);
        this.reviews = reviews;  // Set reviews data
        this.isLoading = false;  // Hide the loading spinner
      },
      error: (error) => {
        this.errorMessage = 'Error loading reviews!';  // Handle error
        this.isLoading = false;  // Hide the loading spinner
      }
    });
  }
  deleteById(reviewId:number){
    console.log(reviewId);
  
    this.reviewService.deleteById(reviewId).subscribe(
  
        ()=>{console.log(reviewId+ "record deleted");
          alert("Record Deleted Successfully");
  
        } , (err)=>{console.log(err)}
       
    );
  
  
      this.showAllReviews();
  
  }
  
}
