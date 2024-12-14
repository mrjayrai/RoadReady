import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayPaymentByUserIdComponent } from './display-payment-by-user-id.component';

describe('DisplayPaymentByUserIdComponent', () => {
  let component: DisplayPaymentByUserIdComponent;
  let fixture: ComponentFixture<DisplayPaymentByUserIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayPaymentByUserIdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DisplayPaymentByUserIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
