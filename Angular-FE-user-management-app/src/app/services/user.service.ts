import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable, of } from 'rxjs';
import { User } from '../models/user.model';
import { Department } from '../models/department.model';

const BASE_URL = 'http://localhost:8080/api';

@Injectable({
    providedIn: 'root'
})
export class UserService {

    constructor(private http: HttpClient) { }

    getUsers(): Observable<User[]> {
        return this.http.get<User[]>(BASE_URL + '/user');
    }

    saveNewUser(user: User): Observable<unknown> {
        return this.http.post<unknown>(BASE_URL + '/user', user);
    }
    
    deleteUser(id: number): Observable<unknown> {
        return this.http.delete<unknown>( `${BASE_URL}/user/delete/?id=${id}` );
    }

    getDepartments(): Observable<Department[]> {
        return this.http.get<Department[]>(
            BASE_URL + '/user/departments'
        );
    }
}
