package com.hexaware.roadready.dto;
/*
 * Author : Rajeshwari
 * Description : DTO Class for reviews
 * Date: 23-11-2024
 */

import java.time.LocalDateTime;

public class ReviewDTO {
    private int reviewId;
    private int rating; // Rating between 1 and 5
    private String reviewText; // Textual feedback, max 500 characters
    private LocalDateTime reviewDate; // Date and time of the review
    private int userId; // ID of the user who provided the review
    private int bookingId; // ID of the associated booking

    // Constructors
    public ReviewDTO() {
    }

    public ReviewDTO( int rating, String reviewText, LocalDateTime reviewDate, int userId, int bookingId) {
//        this.reviewId = reviewId;
        this.rating = rating;
        this.reviewText = reviewText;
        this.reviewDate = reviewDate;
        this.userId = userId;
        this.bookingId = bookingId;
    }
    

    public ReviewDTO(int reviewId, int rating, String reviewText, LocalDateTime reviewDate, int userId, int bookingId) {
		super();
		this.reviewId = reviewId;
		this.rating = rating;
		this.reviewText = reviewText;
		this.reviewDate = reviewDate;
		this.userId = userId;
		this.bookingId = bookingId;
	}

	// Getters and Setters
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "ReviewsDTO{" +
                "reviewId=" + 
                ", rating=" + rating +
                ", reviewText='" + reviewText + '\'' +
                ", reviewDate=" + reviewDate +
                ", userId=" + userId +
                ", bookingId=" + bookingId +
                '}';
    }
}

