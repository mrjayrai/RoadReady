import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayReviewByUserIdComponent } from './display-review-by-user-id.component';

describe('DisplayReviewByUserIdComponent', () => {
  let component: DisplayReviewByUserIdComponent;
  let fixture: ComponentFixture<DisplayReviewByUserIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayReviewByUserIdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DisplayReviewByUserIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
