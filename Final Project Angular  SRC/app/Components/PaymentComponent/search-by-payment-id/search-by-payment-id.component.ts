import { Component } from '@angular/core';
import { Payment } from 'src/app/Model/Payment';
import { PaymentService } from 'src/app/Services/Payment/payment.service';

@Component({
  selector: 'app-search-by-payment-id',
  templateUrl: './search-by-payment-id.component.html',
  styleUrls: ['./search-by-payment-id.component.css']
})
export class SearchByPaymentIdComponent {
  paymentList: Payment[] | null = null;
  searchError: string | null = null;
  constructor(private paymentService: PaymentService) {}

  searchByPaymentId(formValue: any): void {
    const paymentId = formValue.paymentId;
    this.paymentService.searchByPaymentId(paymentId).subscribe(
      (paymentData) => {
        this.paymentList = [paymentData]; // Assign the fetched payment data to paymentList
        this.searchError = null; // Reset any error message
      },
      (error) => {
        this.searchError = "Payment Not Found for the given Payment ID.";
        this.paymentList = null; // Reset paymentList on error
      }
    );
  }
}
