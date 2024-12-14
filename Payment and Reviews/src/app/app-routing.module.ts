import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePaymentComponent } from './Components/home-payment/home-payment.component';
import { HomeReviewComponent } from './Components/home-review/home-review.component';
import { AddPaymentComponent } from './Components/PaymentComponent/add-payment/add-payment.component';
import { DisplayAllPaymentsComponent } from './Components/PaymentComponent/display-all-payments/display-all-payments.component';
import { DisplayPaymentByUserIdComponent } from './Components/PaymentComponent/display-payment-by-user-id/display-payment-by-user-id.component';
import { DisplayPaymentStatusComponent } from './Components/PaymentComponent/display-payment-status/display-payment-status.component';
import { SearchByPaymentIdComponent } from './Components/PaymentComponent/search-by-payment-id/search-by-payment-id.component';
import { UpdatePaymentStatusComponent } from './Components/PaymentComponent/update-payment-status/update-payment-status.component';
import { AddReviewComponent } from './Components/ReviewComponent/add-review/add-review.component';
import { DisplayAllReviewComponent } from './Components/ReviewComponent/display-all-review/display-all-review.component';
import { DisplayReviewByBookingIdComponent } from './Components/ReviewComponent/display-review-by-booking-id/display-review-by-booking-id.component';
import { DisplayReviewByIdComponent } from './Components/ReviewComponent/display-review-by-id/display-review-by-id.component';
import { DisplayReviewByUserIdComponent } from './Components/ReviewComponent/display-review-by-user-id/display-review-by-user-id.component';
import { UpdateReviewComponent } from './Components/ReviewComponent/update-review/update-review.component';

const routes: Routes = [
  {path:'home-payment',component:HomePaymentComponent},
  {path:'home-review',component:HomeReviewComponent},
  {path:'addpayment',component:AddPaymentComponent},
  {path:'displayallpayments',component:DisplayAllPaymentsComponent},
  {path:'searchbypaymentid',component:SearchByPaymentIdComponent},
  {path:'searchbyuserid',component:DisplayPaymentByUserIdComponent},
  {path:'displaybypaymentstatus',component:DisplayPaymentStatusComponent},
  {path:'updatepaymentstatus',component:UpdatePaymentStatusComponent},
  {path:'addreview',component:AddReviewComponent},
  {path:'displayallreviews',component:DisplayAllReviewComponent},
  {path:'displaybyreviewid',component:DisplayReviewByIdComponent},
  {path:'updatereview',component:UpdateReviewComponent},
  {path:'displaybyuserid',component:DisplayReviewByUserIdComponent},
  {path:'displaybybookingid',component:DisplayReviewByBookingIdComponent},

  
  
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
