import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivateFn, GuardResult, MaybeAsync, Router, RouterStateSnapshot } from '@angular/router';
import { AuthService } from '../services/auth.service';
@Injectable()
export class AuthGuard {
  constructor(private autheService : AuthService,
              private router: Router
             ){

  }
  canActivate(route: ActivatedRouteSnapshot, 
    state: RouterStateSnapshot):MaybeAsync<GuardResult>{
      if(this.autheService.isAuthenticated){
        return true;
      } else {
        this.router.navigateByUrl("/login");
        return false;
      }
    }
  
};
