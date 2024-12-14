import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddPaymentComponent } from './Components/PaymentComponent/add-payment/add-payment.component';
import { DisplayAllPaymentsComponent } from './Components/PaymentComponent/display-all-payments/display-all-payments.component';
import { DisplayPaymentByBookingIdComponent } from './Components/PaymentComponent/display-payment-by-booking-id/display-payment-by-booking-id.component';
import { DisplayPaymentByUserIdComponent } from './Components/PaymentComponent/display-payment-by-user-id/display-payment-by-user-id.component';
import { DisplayPaymentStatusComponent } from './Components/PaymentComponent/display-payment-status/display-payment-status.component';
import { SearchByPaymentIdComponent } from './Components/PaymentComponent/search-by-payment-id/search-by-payment-id.component';
import { UpdatePaymentStatusComponent } from './Components/PaymentComponent/update-payment-status/update-payment-status.component';
import { PaymentService } from './Services/Payment/payment.service';
import { ReviewService } from './Services/Review/review.service';
import { DisplayAllReviewComponent } from './Components/ReviewComponent/display-all-review/display-all-review.component';
import { DisplayReviewByIdComponent } from './Components/ReviewComponent/display-review-by-id/display-review-by-id.component';
import { DisplayReviewByUserIdComponent } from './Components/ReviewComponent/display-review-by-user-id/display-review-by-user-id.component';
import { DisplayReviewByBookingIdComponent } from './Components/ReviewComponent/display-review-by-booking-id/display-review-by-booking-id.component';
import { AddReviewComponent } from './Components/ReviewComponent/add-review/add-review.component';
import { UpdateReviewComponent } from './Components/ReviewComponent/update-review/update-review.component';




@NgModule({
  declarations: [
    AppComponent,
    AddPaymentComponent,
    UpdatePaymentStatusComponent,
    DisplayAllPaymentsComponent,
    SearchByPaymentIdComponent,
    DisplayPaymentStatusComponent,
    DisplayPaymentByBookingIdComponent,
    DisplayPaymentByUserIdComponent,
    DisplayAllReviewComponent,
    DisplayReviewByIdComponent,
    DisplayReviewByUserIdComponent,
    DisplayReviewByBookingIdComponent,
    AddReviewComponent,
    UpdateReviewComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [PaymentService,
    ReviewService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
