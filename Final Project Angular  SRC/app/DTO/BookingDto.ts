

export interface BookingDTO {
  bookingId: number;
  userId: number;
  carId: number;
  startDate: string; // LocalDate is represented as a string in ISO format in TypeScript
  endDate: string;
  totalPrice: number; // BigDecimal can be represented as number in TypeScript
  status: string;
}
