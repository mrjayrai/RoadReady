package com.hexaware.roadready.entities;
import java.time.LocalDateTime;

/*
 * Author:Rajeshwari
 * Description: Entity class for reviews with hibernate mapping
 * Date:16-11-2024
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "rating_review")
public class Reviews{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int reviewId;

    @NotNull(message = "Rating cannot be null")
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    @Column(name = "rating", nullable = false)
    private int rating;

    @Size(max = 500, message = "Review text must not exceed 500 characters")
    @Column(name = "review_text", length = 500)
    private String reviewText;

    @Column(name = "review_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime reviewDate;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "User ID is required.")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    @NotNull(message = "Booking ID is required.")
    private Bookings booking;

    // Getters and Setters
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Bookings getBooking() {
        return booking;
    }

    public void setBooking(Bookings booking) {
        this.booking = booking;
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

	public Reviews(int reviewId,
			@NotNull(message = "Rating cannot be null") @Min(value = 1, message = "Rating must be at least 1") @Max(value = 5, message = "Rating must be at most 5") int rating,
			@Size(max = 500, message = "Review text must not exceed 500 characters") String reviewText,
			LocalDateTime reviewDate, Users user, Bookings booking) {
		super();
		this.reviewId = reviewId;
		this.rating = rating;
		this.reviewText = reviewText;
		this.reviewDate = reviewDate;
		this.user = user;
		this.booking = booking;
	}

	public Reviews() {
		super();
	}
	

	public Reviews(int reviewId) {
		super();
		this.reviewId = reviewId;
	}

	@Override
	public String toString() {
		return "Reviews [reviewId=" + reviewId + ", rating=" + rating + ", reviewText=" + reviewText + ", reviewDate="
				+ reviewDate + ", user=" + user + ", booking=" + booking + "]";
	}
    
}



