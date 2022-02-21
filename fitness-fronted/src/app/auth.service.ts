import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    const info = btoa(`${username}:${password}`);
    const token = `Basic ${info}`;
    const options = {
      headers: new HttpHeaders({
        Authorization: token,
        'X-Requested-With' : 'XMLHttpRequest'
      }),
      withCredentials: true
    };
    return this.httpClient.post<any>(`http://localhost:8080/login`, { username: username, password: password }).pipe(tap(() => localStorage.setItem('token', token)));
  }

  register(username: string, password: string): Observable<any> {
    return this.httpClient.post<any>(`http://localhost:8080/register`, { username: username, password: password });
  }
}
function tap(arg0: () => void): import("rxjs").OperatorFunction<any, any> {
  throw new Error('Function not implemented.');
}

