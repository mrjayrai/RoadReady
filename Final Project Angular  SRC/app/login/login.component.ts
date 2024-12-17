import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { jwtDecode } from 'jwt-decode';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  token: string = '';
  role: string = '';
  userId:number = 0;

  constructor(private router: Router, private http: HttpClient) {}

  onSubmit(): void {
    if (this.email && this.password) {
      const authRequest = {
        userName: this.email,
        userPassword: this.password
      };

      this.http.post('http://localhost:8080/api/users/login', authRequest, { responseType: 'text' })
        .subscribe(
          (genToken) => {
            this.token = genToken;
            localStorage.setItem('token', this.token);

            // Decode the token to get the role
            const decodedToken: any = jwtDecode(this.token);
            this.role = decodedToken.role;
            localStorage.setItem('role', this.role);
            console.log(this.userId);
            console.log('Token:', this.token);
            console.log('Role:', this.role);
            localStorage.setItem("token",this.token);
            // Redirect based on role
            console.log(decodedToken.sub);
            localStorage.setItem("email",decodedToken.sub);
            this.redirectBasedOnRole();
          },
          (error) => {
            console.error('Error during login:', error);
            alert('Incorrect email or password. Please try again.');
          }
        );
    } else {
      alert('Please enter both email and password');
    }
  }

  
  redirectBasedOnRole(): void {
    // Clean or map the role string
    const cleanedRole = this.role.replace(/[\[\]]/g, '').replace('ROLE_', '').toUpperCase();
  
    switch (cleanedRole) {
      case 'CUSTOMER':
        this.router.navigate(['/customer/home']);
        break;
      case 'DEALER':
        this.router.navigate(['/dealer/home']);
        break;
      case 'ADMIN':
        this.router.navigate(['/admin/home']);
        break;
      default:
        console.log('Unknown role:', cleanedRole);
        // Optionally, navigate to a generic home or error page
        this.router.navigate(['/']);
        break;
    }
  }
  
}
