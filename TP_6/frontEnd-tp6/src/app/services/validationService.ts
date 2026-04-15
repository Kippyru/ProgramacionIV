import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class ValidationService {

  private API = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  checkIfExists(field: string, value: string) {

    return this.http.get<boolean>(
      `${this.API}/exists?username=${value}`
    );
  }
}

