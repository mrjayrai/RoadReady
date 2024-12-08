export interface Car{
    carId: number;
    carCompany: string;
    carModel: string;
    carYear: number;
    licensePlate: string;
    carType: string;
    pricePerDay: string; // Represented as a string to mimic BigDecimal
  }