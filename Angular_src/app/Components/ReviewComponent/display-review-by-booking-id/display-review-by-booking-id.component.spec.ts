import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayReviewByBookingIdComponent } from './display-review-by-booking-id.component';

describe('DisplayReviewByBookingIdComponent', () => {
  let component: DisplayReviewByBookingIdComponent;
  let fixture: ComponentFixture<DisplayReviewByBookingIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayReviewByBookingIdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DisplayReviewByBookingIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
