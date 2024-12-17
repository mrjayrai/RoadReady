import { Component } from '@angular/core';

@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.css']
})
export class CustomerHomeComponent {
  activeTab: string = 'dashboard';

  setActiveTab(tab: string) {
    this.activeTab = tab;
  }
}