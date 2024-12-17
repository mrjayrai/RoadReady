import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayReviewByIdComponent } from './display-review-by-id.component';

describe('DisplayReviewByIdComponent', () => {
  let component: DisplayReviewByIdComponent;
  let fixture: ComponentFixture<DisplayReviewByIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayReviewByIdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DisplayReviewByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
