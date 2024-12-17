// Author:Rajeshwari
// Date:07-12-2024
export interface ReviewDTO {
    reviewId: number;          // Review ID, using number for integer type
    rating: number;            // Rating, number type, generally between 1-5
    reviewText: string;        // Review text, string type
    reviewDate: Date;          // LocalDateTime in Java represented as Date in TypeScript
    userId: number;            // User ID as a number
    bookingId: number;         // Booking ID as a number
  }
  