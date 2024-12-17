import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from 'src/app/Services/Users/user.service';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {
  registrationForm!: FormGroup;
  roleId = [
    { roleId: 1, name: 'Admin' },
    { roleId: 2, name: 'User' }
  ];

  constructor(private fb: FormBuilder, private userService: UserService) {}

  ngOnInit(): void {
    this.registrationForm = this.fb.group({
      email: [
        '',
        [
          Validators.required,
          Validators.email,
          Validators.maxLength(255)
        ]
      ],
      name: ['', [Validators.required, Validators.minLength(2)]],
      password: [
        '',
        [
          Validators.required,
          Validators.minLength(8)
        ]
      ],
      phoneNumber: [
        '',
        [
          Validators.required,
          Validators.pattern('\\d{10}')
        ]
      ],
      roleId: ['', Validators.required]  // roleId as a simple form control
    });
  }

  onSubmit(): void {
    if (this.registrationForm.valid) {
      const formData = this.registrationForm.value;
      
      // Modify the formData to structure the roleId as an object
      const requestData = {
        userId: 0,  // Default userId as 0
        email: formData.email,
        name: formData.name,
        password: formData.password,
        phoneNumber: formData.phoneNumber,
        roleId: {
          roleId: formData.roleId,
          // roleName: this.roleId.find(role => role.roleId === formData.roleId)?.roleName || ''  // Find roleName based on selected roleId
        },
        createdAt: new Date().toISOString() // Add createdAt timestamp
      };

      console.log('Form Data:', formData);

      // Call the UserService to send the data to the backend
      this.userService.registerUser(requestData).subscribe({
        next: (response: any) => {
          console.log('Registration successful:', response);
          alert('User registered successfully!');
          this.registrationForm.reset();
        },
        error: (error: any) => {
          console.error('Error during registration:', error);
          alert('Registration failed. Please try again.');
        }
      });
    } else {
      console.log('Form is invalid');
    }
  }
}
