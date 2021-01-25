import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './model/employee'


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = 'http://localhost:8080/api/employee';


  constructor(private http: HttpClient) { }

  getEmployee(id: number): Observable<Employee> {
    return this.http.get<Employee>(`${this.baseUrl}/${id}`);
  }

  createEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(`${this.baseUrl}`, employee);
  }

  updateEmployee(value: Employee): Observable<Employee> {
    return this.http.put<Employee>(`${this.baseUrl}`, value);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getEmployeesList(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.baseUrl}`);
  }
}
