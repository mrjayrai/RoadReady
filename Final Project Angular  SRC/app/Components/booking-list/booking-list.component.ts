import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { BookingService } from 'src/app/Services/Bookings/booking.service';
import { CarService } from 'src/app/Services/Car/car.service';

@Component({
  selector: 'app-booking-list',
  templateUrl: './booking-list.component.html',
  styleUrls: ['./booking-list.component.css']
})
export class BookingListComponent implements OnInit {

  environment = environment;
  bookings: any[] = [];
  cars:any[] = [];


  constructor(private bookService:BookingService ,private carService:CarService) {}

  ngOnInit(): void {
    this.bookService.getBookings().subscribe(
      (data) => {
        this.bookings = data;
      },
      (error) => {
        console.error('Error fetching car data', error);
      }
    );

   
}
}
