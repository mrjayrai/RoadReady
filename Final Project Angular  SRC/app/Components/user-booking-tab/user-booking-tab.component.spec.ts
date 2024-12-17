import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserBookingTabComponent } from './user-booking-tab.component';

describe('UserBookingTabComponent', () => {
  let component: UserBookingTabComponent;
  let fixture: ComponentFixture<UserBookingTabComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserBookingTabComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserBookingTabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
