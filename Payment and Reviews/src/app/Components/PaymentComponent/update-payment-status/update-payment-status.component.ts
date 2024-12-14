import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PaymentService } from 'src/app/Services/Payment/payment.service';

@Component({
  selector: 'app-update-payment-status',
  templateUrl: './update-payment-status.component.html',
  styleUrls: ['./update-payment-status.component.css']
})
export class UpdatePaymentStatusComponent {
  updateForm: FormGroup;
  isSubmitting = false;
  successMessage: string | null = null;
  errorMessage: string | null = null;

  constructor(private fb: FormBuilder, private paymentService: PaymentService) {
    // Initialize the form
    this.updateForm = this.fb.group({
      paymentId: ['', [Validators.required, Validators.pattern(/^\d+$/)]],
      status: ['', [Validators.required]]
    });
  }

  onSubmit() {
    if (this.updateForm.invalid) {
      return;
    }
 console.log(this.updateForm.value);
    this.isSubmitting = true;
    this.successMessage = null;
    this.errorMessage = null;

    const { paymentId, status } = this.updateForm.value;

    this.paymentService.updatePaymentStatus(paymentId, status).subscribe({
      next: (response) => {
        this.successMessage = `Payment status updated successfully `;
        this.updateForm.reset();
      },
      error: (error) => {
        this.errorMessage = 'Failed to update payment status. Please try again.';
      },
      complete: () => {
        this.isSubmitting = false;
      }
    });
  }

}
