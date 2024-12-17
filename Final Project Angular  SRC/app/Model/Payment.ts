
// Author:Rajeshwari
// Date:08-12-2024
import { booking } from './Booking';
import { user } from './User';

export interface Payment {
  paymentId: number;
  amount: number;
  paymentDate: Date;  // You can use ISO string format for LocalDateTime
  paymentMethod: 'CASH' | 'CREDIT_CARD' | 'DEBIT_CARD' | 'ONLINE';
  status: 'PENDING' | 'PAID' | 'FAILED';
  user: user;
  booking: booking;
}