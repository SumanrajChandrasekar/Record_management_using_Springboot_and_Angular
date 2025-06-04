import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASIC_URL = 'http://localhost:9000/';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http: HttpClient) {}

  postStudent(student: any): Observable<string> {
  return this.http.post(BASIC_URL + 'v0/students', student, { responseType: 'text' });
}
getAllStudents(): Observable<any[]> {
  return this.http.get<any[]>(BASIC_URL + 'v0/getstudents');
}
getStudentById(id: number): Observable<any> {
  return this.http.get<any>(`${BASIC_URL}v0/student/${id}`); 
}
updateStudent(id: number, student: any): Observable<string> {
  return this.http.put(BASIC_URL + `v0/student/${id}`, student, { responseType: 'text' });  
}
 deleteStudent(id: number): Observable<any> {
  return this.http.delete(`${BASIC_URL}v0/students/${id}`, { responseType: 'text' });
}
}