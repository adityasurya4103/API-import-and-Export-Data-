import { HttpClient, HttpEvent, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Users } from './users';
import { Observable, catchError, filter } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private baseURL = "http://localhost:8080/user";

  private apiUrl = 'http://localhost:8080/excel';

  constructor(private httpClient: HttpClient,private http: HttpClient) { }


  getUserList(): Observable<Users[]> {
    return this.httpClient.get<Users[]>(`${this.baseURL}`)
      .pipe(
        catchError((error: any) => {
          console.error('Error fetching user data:', error);
          throw error; // Rethrow the error for further handling in the component
        })
      );
  }

  getDownload(): Observable<Blob>{
    return this.httpClient.get<Blob>(`${this.apiUrl}`);
  }

  // downloadFile(): Observable<HttpEvent<Blob>> {
  //   const url = `http://localhost:8080/excel`; // Replace with your actual API endpoint
  //   const options = {
  //     observe: 'events' as 'events', // Change 'body' to 'events'
  //     responseType: 'blob' as 'json', // Set the response type to 'blob'
  //   };

  //   return this.http.get<Blob>(url, options);
  // }

}

