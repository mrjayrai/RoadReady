import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ReviewDTO } from 'src/app/DTO/ReviewDto';
import { ReviewService } from 'src/app/Services/Review/review.service';

@Component({
  selector: 'app-update-review',
  templateUrl: './update-review.component.html',
  styleUrls: ['./update-review.component.css']
})
export class UpdateReviewComponent {
  reviewForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private reviewService: ReviewService
  ) {}

  ngOnInit(): void {
    this.reviewForm = this.fb.group({
      reviewId:[null],
      rating: [null, [Validators.required, Validators.min(1), Validators.max(5)]],
      reviewText: ['', [Validators.maxLength(500)]],
      reviewDate: [null, Validators.required],
      userId: ['', Validators.required],  // Assume this is set from logged-in user
      bookingId: ['', Validators.required]
    });
  }

  // This function provides easier access to the form controls
  f(controlName: string) {
    return this.reviewForm.get(controlName);
  }

  onSubmit(): void {
    if (this.reviewForm.valid) {
      const reviewDto: ReviewDTO = this.reviewForm.value;
      this.reviewService.updateReviewDetails(reviewDto).subscribe((response: any) => {
        console.log('Review Updated successfully:', response);
        alert('Review Updated Sucessfully')
      }, (error: any) => {
        console.error('Error updating review:', error);
      });
    }
  }
}