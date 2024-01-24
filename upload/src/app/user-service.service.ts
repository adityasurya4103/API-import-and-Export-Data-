import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Users } from './users';
import { Observable, catchError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private baseURL = "http://localhost:8080/user";

  constructor(private httpClient: HttpClient) { }


  getUserList(): Observable<Users[]> {
    return this.httpClient.get<Users[]>(`${this.baseURL}`)
      .pipe(
        catchError((error: any) => {
          console.error('Error fetching user data:', error);
          throw error; // Rethrow the error for further handling in the component
        })
      );
  }

}
