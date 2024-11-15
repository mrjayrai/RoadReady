package com.hexaware.roadready.entities;
import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Table(name = "reviews")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false)
    private int bookingId;

    @Column(length = 1000, nullable = false)
    private String reviewText;

    @Column(nullable = false)
    private LocalDate reviewDate;

    @Column(nullable = false)
    private int rating;
    @PrePersist
    public void prePersist() {
        if (reviewDate == null) {
            reviewDate = LocalDate.now(); // Set the default value to current date
        }
    }
    public Reviews() {
        super();
    }

    public Reviews(int reviewId, int userId, int bookingId, String reviewText, LocalDate reviewDate, int rating) {
        super();
        this.reviewId = reviewId;
        this.userId = userId;
        this.bookingId = bookingId;
        this.reviewText = reviewText;
        this.reviewDate = reviewDate;
        this.rating = rating;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
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

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Reviews [reviewId=" + reviewId + ", userId=" + userId + ", bookingId=" + bookingId + ", reviewText="
                + reviewText + ", reviewDate=" + reviewDate + ", rating=" + rating + "]";
    }
}




