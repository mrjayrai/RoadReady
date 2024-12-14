import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayAllPaymentsComponent } from './display-all-payments.component';

describe('DisplayAllPaymentsComponent', () => {
  let component: DisplayAllPaymentsComponent;
  let fixture: ComponentFixture<DisplayAllPaymentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayAllPaymentsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DisplayAllPaymentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
