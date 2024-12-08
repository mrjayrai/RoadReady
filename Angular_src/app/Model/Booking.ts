import { Car } from "./Car";
import { User } from "./User";

export interface Booking {
    bookingId: number;
    userId: User;
    carId: Car;
    startDate: string; // ISO 8601 date format
    endDate: string;   // ISO 8601 date format
    totalPrice: string; // Represented as a string to match BigDecimal behavior
    status: string;
  }