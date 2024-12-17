import { Component, OnInit } from '@angular/core';
import { CarService } from 'src/app/Services/Car/car.service';

import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {
  environment = environment;
  cars: any[] = [];
  paginatedCars: any[] = [];
  currentPage: number = 1;
  itemsPerPage: number = 3;
  totalPages: number = 0;

  constructor(private carService: CarService) {}

  ngOnInit(): void {
    this.carService.getCars().subscribe(
      (data) => {
        this.cars = data;
        this.totalPages = Math.ceil(this.cars.length / this.itemsPerPage);
        this.updatePaginatedCars();
      },
      (error) => {
        console.error('Error fetching car data', error);
      }
    );
  }

  updatePaginatedCars(): void {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    this.paginatedCars = this.cars.slice(startIndex, endIndex);
  }

  previousPage(): void {
    if (this.currentPage > 1) {
      this.currentPage--;
      this.updatePaginatedCars();
    }
  }

  nextPage(): void {
    if (this.currentPage < this.totalPages) {
      this.currentPage++;
      this.updatePaginatedCars();
    }
  }

  goToPage(page: number): void {
    this.currentPage = page;
    this.updatePaginatedCars();
  }

  get totalPagesArray(): number[] {
    return Array.from({ length: this.totalPages }, (_, i) => i + 1);
  }
}
