import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-user-tab',
  templateUrl: './user-tab.component.html',
  styleUrls: ['./user-tab.component.css']
})
export class UserTabComponent {
  @Output() tabChanged: EventEmitter<string> = new EventEmitter<string>();
  onViewBookingsClick() {
    this.tabChanged.emit('viewBooking');
    // console.log("Hi");
  }
}
