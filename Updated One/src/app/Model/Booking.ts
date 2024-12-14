import { Car } from "./Car";
import { user } from "./User";

export interface booking {
    bookingId: number;
    userId: user;
    carId: Car;
    startDate: Date; // ISO 8601 date format
    endDate: Date;   // ISO 8601 date format
    totalPrice: string; // Represented as a string to match BigDecimal behavior
    status: string;
  }