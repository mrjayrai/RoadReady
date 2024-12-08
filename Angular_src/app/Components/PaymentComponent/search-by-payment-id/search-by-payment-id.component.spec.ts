import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchByPaymentIdComponent } from './search-by-payment-id.component';

describe('SearchByPaymentIdComponent', () => {
  let component: SearchByPaymentIdComponent;
  let fixture: ComponentFixture<SearchByPaymentIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchByPaymentIdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchByPaymentIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
