// import { Component, OnInit, Output, EventEmitter } from '@angular/core';
// import { FormBuilder, FormGroup, Validators } from '@angular/forms';
// import { BookingService } from 'src/app/Services/Bookings/booking.service';
// import { environment } from 'src/environments/environment';
// import { CarService } from 'src/app/Services/Car/car.service';

// @Component({
//   selector: 'app-user-booking-tab',
//   templateUrl: './user-booking-tab.component.html',
//   styleUrls: ['./user-booking-tab.component.css']
// })
// export class UserBookingTabComponent implements OnInit {
//   @Output() tabChanged: EventEmitter<string> = new EventEmitter<string>();

//   environment = environment;
//   bookings: any[] = [];
//   cars: any[] = [];

//   bookingForm: FormGroup;
//   showBookingForm: boolean = false;
//   totalPrice: number = 0;

//   constructor(private fb: FormBuilder, private bookingService: BookingService, private carBooking: CarService) {
//     this.bookingForm = this.fb.group({
//       startDate: ['', Validators.required],
//       endDate: ['', Validators.required],
//       car: ['', Validators.required],
//       totalPrice: [0, Validators.required]
//     });
//   }

//   ngOnInit(): void {
//     this.bookingService.getUserBookings().subscribe(
//       (data) => {
//         this.bookings = data;
//       },
//       (error) => {
//         console.error('Error fetching car data', error);
//       }
//     );
//     this.carBooking.getCars().subscribe(
//       (data) => {
//         this.cars = data;
//       },
//       (error) => {
//         console.error('Error fetching car data', error);
//       }
//     );
//   }

//   onViewBookingsClick() {
//     this.tabChanged.emit('viewBooking');
//   }

//   calculateTotalPrice(selectedCar: any) {
//     const startDate = this.bookingForm.get('startDate')?.value;
//     const endDate = this.bookingForm.get('endDate')?.value;
//     if (startDate && endDate) {
//       const diffDays = Math.floor((new Date(endDate).getTime() - new Date(startDate).getTime()) / (1000 * 3600 * 24));
//       this.totalPrice = diffDays * selectedCar.pricePerDay;
//     }
//   }

//   onCarSelect(event: any) {
//     const selectedCar = this.cars.find(car => car.carId === event.target.value);
//     if (selectedCar) {
//       this.calculateTotalPrice(selectedCar);
//     }
//   }

//   toggleBookingForm() {
//     this.showBookingForm = !this.showBookingForm;
//   }

//   hideBookingForm() {
//     this.showBookingForm = false;
//   }

//   submitBooking() {
//     if (this.bookingForm.valid) {
//       this.bookingService.createBooking(this.bookingForm.value).subscribe(response => {
//         console.log('Booking created:', response);
//         this.showBookingForm = false;
//       });
//     }
//   }
// }


import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { jwtDecode } from 'jwt-decode';
import { BookingService } from 'src/app/Services/Bookings/booking.service';
import { CarService } from 'src/app/Services/Car/car.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-user-booking-tab',
  templateUrl: './user-booking-tab.component.html',
  styleUrls: ['./user-booking-tab.component.css']
})
export class UserBookingTabComponent implements OnInit {
  @Output() tabChanged: EventEmitter<string> = new EventEmitter<string>();

  environment = environment;
  bookings: any[] = [];
  cars: any[] = [];

  bookingForm: FormGroup;
  showBookingForm: boolean = false;
  totalPrice: number = 0;

  

  loggedInUserId: number = 1; // Replace with actual logged-in user's ID

  constructor(
    private fb: FormBuilder,
    private bookingService: BookingService,
    private carService: CarService
  ) {
    this.bookingForm = this.fb.group({
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      car: ['', Validators.required],
      totalPrice: [0, Validators.required]
    });
  }

  ngOnInit(): void {
    this.fetchLoggedInUserId();
    this.fetchBookings();
    this.fetchCars();
  }

  fetchBookings() {
    this.bookingService.getUserBookings().subscribe(
      (data) => {
        this.bookings = data;
      },
      (error) => {
        console.error('Error fetching bookings data', error);
      }
    );
  }

  fetchCars() {
    this.carService.getCars().subscribe(
      (data) => {
        this.cars = data;
      },
      (error) => {
        console.error('Error fetching car data', error);
      }
    );
  }

  onViewBookingsClick() {
    this.tabChanged.emit('viewBooking');
  }

  calculateTotalPrice(selectedCar: any) {
    const startDate = this.bookingForm.get('startDate')?.value;
    const endDate = this.bookingForm.get('endDate')?.value;
    if (startDate && endDate) {
      const diffDays = Math.floor(
        (new Date(endDate).getTime() - new Date(startDate).getTime()) / (1000 * 3600 * 24)
      );
      this.totalPrice = diffDays * selectedCar.pricePerDay;
      this.bookingForm.patchValue({ totalPrice: this.totalPrice });
    }
  }

  onCarSelect(event: any) {
    const selectedCarId = Number(event.target.value);
    const selectedCar = this.cars.find(car => car.carId === selectedCarId);
    if (selectedCar) {
      this.calculateTotalPrice(selectedCar);
    }
  }

  toggleBookingForm() {
    this.showBookingForm = !this.showBookingForm;
  }

  hideBookingForm() {
    this.showBookingForm = false;
    this.bookingForm.reset();
    this.totalPrice = 0;
  }

  fetchLoggedInUserId() {
    const token = localStorage.getItem('token');
    if (token) {
      try {
        const decodedToken: any = jwtDecode(token);
        const parse = JSON.parse(token);
        this.loggedInUserId = parse.userId;
        console.log('Logged-in User ID:', parse.userId);
      } catch (error) {
        console.error('Error decoding token:', error);
      }
    } else {
      console.error('No token found in localStorage');
    }
  }
  
  submitBooking() {
    if (this.bookingForm.valid) {
      const formData = this.bookingForm.value;

      // Create the booking payload matching the API structure
      const bookingPayload = {
        userId: { userId: this.loggedInUserId },
        carId: { carId: formData.car },
        startDate: formData.startDate,
        endDate: formData.endDate,
        totalPrice: this.totalPrice,
        status: 'Booked'
      };

      this.bookingService.createBooking(bookingPayload).subscribe(
        (response) => {
          console.log('Booking created:', response);
          this.showBookingForm = false;
          this.bookingForm.reset();
          this.totalPrice = 0;
        },
        (error) => {
          console.error('Error creating booking:', error);
        }
      );
    }
  }
}
