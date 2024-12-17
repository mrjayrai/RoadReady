import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-admin-tab',
  templateUrl: './admin-tab.component.html',
  styleUrls: ['./admin-tab.component.css']
})
export class AdminTabComponent {
  @Output() tabChanged: EventEmitter<string> = new EventEmitter<string>();

  // Emit the active tab when "View Bookings" is clicked
  onViewBookingsClick() {
    this.tabChanged.emit('viewBookings');
  }

  onViewCarsClick(){
    this.tabChanged.emit('viewCars');
  }

  onViewUsersClick(){
    this.tabChanged.emit('viewUsers');
  }

  onViewPaymentClick(){
    this.tabChanged.emit('viewPayments');
  }
  onViewReviewClick(){
    this.tabChanged.emit('viewReviews');
  }
}
