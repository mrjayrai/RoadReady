import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/Services/Users/user.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  environment = environment;
  users: any[] = [];

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.userService.getUsers().subscribe(
      (data) => {
        this.users = data;
        
      },
      (error) => {
        console.error('Error fetching car data', error);
      }
    );
  }
}
