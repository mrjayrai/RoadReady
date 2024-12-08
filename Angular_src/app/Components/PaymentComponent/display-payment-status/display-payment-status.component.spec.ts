import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayPaymentStatusComponent } from './display-payment-status.component';

describe('DisplayPaymentStatusComponent', () => {
  let component: DisplayPaymentStatusComponent;
  let fixture: ComponentFixture<DisplayPaymentStatusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayPaymentStatusComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DisplayPaymentStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
