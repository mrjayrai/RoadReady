import { Component } from '@angular/core';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent {
  featuredCars = [
    {
      name: 'Toyota Corolla',
      description: 'Comfortable and fuel-efficient.',
      image: 'assets/1.jfif'
    },
    {
      name: 'Ford Mustang',
      description: 'Sporty and powerful.',
      image: 'assets/1.jfif'
    },
    {
      name: 'Chevrolet Tahoe',
      description: 'Spacious and perfect for family trips.',
      image: 'assets/1.jfif'
    }
  ];
}
