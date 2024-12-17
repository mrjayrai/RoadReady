import { Component } from '@angular/core';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent {
  activeTab: string = 'dashboard';
  payments = [1, 2, 3];
  bookings = [1, 2];
  cars = [1, 2, 3, 4];
  customers = [1, 2, 3, 4, 5];
  setActiveTab(tab: string) {
    this.activeTab = tab;
  }
}
