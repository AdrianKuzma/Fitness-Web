import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.httpClient.post<any>(`http://localhost:8080/login`, { username: username, password: password });
  }
  register(username: string, password: string): Observable<any> {
    return this.httpClient.post<any>(`http://localhost:8080/register`, { username: username, password: password });
  }
}
