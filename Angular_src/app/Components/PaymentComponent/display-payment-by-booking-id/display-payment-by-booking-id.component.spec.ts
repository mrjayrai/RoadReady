import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayPaymentByBookingIdComponent } from './display-payment-by-booking-id.component';

describe('DisplayPaymentByBookingIdComponent', () => {
  let component: DisplayPaymentByBookingIdComponent;
  let fixture: ComponentFixture<DisplayPaymentByBookingIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayPaymentByBookingIdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DisplayPaymentByBookingIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
