import { Component } from '@angular/core';
import { Payment } from 'src/app/Model/Payment';
import { PaymentService } from 'src/app/Services/Payment/payment.service';

@Component({
  selector: 'app-display-payment-by-user-id',
  templateUrl: './display-payment-by-user-id.component.html',
  styleUrls: ['./display-payment-by-user-id.component.css']
})
export class DisplayPaymentByUserIdComponent {
  paymentList: Payment[] | null = null;
  searchError: string | null = null;
  constructor(private paymentService: PaymentService) {}

  searchByUserId(formValue: any): void {
    const userId = formValue.userId;
    this.paymentService.findByUserId(userId).subscribe(
      (paymentData) => {
        console.log(paymentData);
        this.paymentList = paymentData; // Assign the fetched payment data to paymentList
        this.searchError = null; // Reset any error message
      },
      (error) => {
        this.searchError = "Payment Not Found for the given User ID.";
        this.paymentList = null; // Reset paymentList on error
      }
    );
  }
}
