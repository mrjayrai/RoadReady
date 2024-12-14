import { Component } from '@angular/core';
import { Payment } from 'src/app/Model/Payment';
import { PaymentService } from 'src/app/Services/Payment/payment.service';

@Component({
  selector: 'app-display-all-payments',
  templateUrl: './display-all-payments.component.html',
  styleUrls: ['./display-all-payments.component.css']
})
export class DisplayAllPaymentsComponent {
  payments: Payment[] = []; // Store the list of payments
  loading: boolean = false; // Track loading state
  error: string = ''; // Track error state

  constructor(private paymentService: PaymentService) {}

  ngOnInit(): void {}

  // Method to call getAll from PaymentService
  showAllPayments(): void {
    this.loading = true;
    this.paymentService.getAll().subscribe(
      (response) => {
        this.payments = response; // Store the list of payments in the component
        console.log(this.payments);
        this.loading = false; // Stop loading
      },
      (error) => {
        this.error = 'Error fetching payments'; // Handle error
        this.loading = false; // Stop loading
      }
    );
  }
  // }
  // showAllPayments(): void {
  //   this.loading = true;
  //   this.paymentService.getAll().subscribe(
  //     (response) => {
  //       console.log('Payments data:', response); // Log the response to inspect the structure
  //       // Wrap payments in an array if it's not already an array
  //       this.payments = Array.isArray(response.payments) ? response.payments : [response.payments];
  //       this.loading = false;
  //     },
  //     (error) => {
  //       this.error = 'Error fetching payments';
  //       this.loading = false;
  //     }
  //   );
  // }
  // showAllPayments(): void {
  //   this.loading = true;
  //   this.paymentService.getAll().subscribe(
  //     (response) => {
  //       console.log('Payments data:', response); // Check the response structure
  //       // Ensure payments is an array
  //       this.payments = Array.isArray(response.payments) ? response.payments : [response.payments];
  //       this.loading = false;
  //     },
  //     (error) => {
  //       this.error = 'Error fetching payments';
  //       this.loading = false;
  //     }
  //   );
  // }
  
  
}
