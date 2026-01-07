import { Injectable } from '@angular/core';
import {
  CanActivate,
  Router,
  UrlTree
} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private router: Router) {}

  canActivate(): boolean | UrlTree {

    const token = localStorage.getItem('token');

    // Si pas de token → redirection vers login
    if (!token) {
      return this.router.parseUrl('/login');
    }

    // Sinon accès autorisé
    return true;
  }
}
