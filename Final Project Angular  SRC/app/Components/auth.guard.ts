import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const requiredRole = route.data['role']; // Get the role from the route data
    const userRole = localStorage.getItem('role'); // Get the role from local storage
  
    // Clean the userRole to remove any formatting like brackets and the 'ROLE_' prefix
    const cleanedUserRole = userRole?.replace(/[\[\]]/g, '').replace('ROLE_', '').toUpperCase();
  
    if (cleanedUserRole && cleanedUserRole === requiredRole.toUpperCase()) {
      return true;
    } else {
      // Log the roles for debugging purposes
      console.log('User Role:', cleanedUserRole);
      console.log('Required Role:', requiredRole);
  
      // Redirect to a generic page if the role doesn't match
      this.router.navigate(['/']);
      return false;
    }
  }
  
}
