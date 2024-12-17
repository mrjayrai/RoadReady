import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AuthGuard } from './Components/auth.guard';
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
import { UserRegistrationComponent } from './Components/user-registration/user-registration.component';
import { CustomerHomeComponent } from './customer-home/customer-home.component';
import { DealerHomeComponent } from './dealer-home/dealer-home.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {path:'',component:LandingPageComponent},
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
  {path:'login',component:LoginComponent},
  {path:'userregister',component:UserRegistrationComponent},
  {path:'customer/home',component:CustomerHomeComponent,
    canActivate: [AuthGuard],
    data: { role: 'CUSTOMER' },
  },
  {path:'dealer/home',component:DealerHomeComponent,
    canActivate: [AuthGuard],
    data: { role: 'DEALER' },
  },
  {path:'admin/home',component:AdminHomeComponent,
    canActivate: [AuthGuard],
    data: { role: 'ADMIN' },
  },

  
  
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
