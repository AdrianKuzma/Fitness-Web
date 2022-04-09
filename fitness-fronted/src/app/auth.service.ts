import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, ReplaySubject } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private _login$ = new BehaviorSubject<boolean>(this.isLoggedIn());

  constructor(private httpClient: HttpClient) { }

  get login$(): Observable<boolean> {
    return this._login$.asObservable();
  }

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
    return this.httpClient.get<any>(`http://localhost:8080/login`, options).pipe(
      tap(() => localStorage.setItem('token', token)),
      tap(() => this._login$.next(true))
    );
  }

  register(username: string, password: string, email: string): Observable<any> {
    return this.httpClient.post<any>(`http://localhost:8080/register`, { username, password, email });
  }

  logout(): void {
    localStorage.removeItem('token');
    this._login$.next(false);
  }

  isLoggedIn(): boolean {
    return this.getToken() !== null;
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

}
