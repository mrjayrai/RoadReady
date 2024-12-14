export interface PaymentDTO {
    amount: number;            // BigDecimal in Java is typically represented as number in TypeScript
    paymentDate: Date;         // LocalDateTime in Java can be represented as Date in TypeScript
    paymentMethod: string;     // Using string for the payment method
    status: string;            // Using string for the status
    userId: number;            // Referencing the user ID as a number
    bookingId: number;         // Referencing the booking ID as a number
  }
  