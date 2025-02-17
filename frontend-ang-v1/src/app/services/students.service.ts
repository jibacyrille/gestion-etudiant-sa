import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { Observable } from 'rxjs';
import { Payment, Student } from '../model/students.model';

@Injectable({
  providedIn: 'root'
})
export class StudentsService {

  constructor(private http: HttpClient) { }

  public getAllPayments():Observable<Array<Payment>>{
    return this.http.get<Array<Payment>>(environment.backendHost+"/payments");
    //return this.http.get(`${environment.backendHost}/payments`);
  }

  public getStudents():Observable<Array<Student>>{
    return this.http.get<Array<Student>>(environment.backendHost+"/students");
    //return this.http.get(`${environment.backendHost}/payments`);
  }

  public getStudentPayments(code:string):Observable<Array<Payment>>{
    return this.http.get<Array<Payment>>(`${environment.backendHost}/students/${code}/payments`);
    //return this.http.get<Array<Payment>>(environment.backendHost+"/students/"+code+"/payments");
    //return this.http.get(`${environment.backendHost}/payments`);
  }
  public savePayment(formData:any):Observable<Payment>{
    return this.http.post<Payment> (`${environment.backendHost}/payments`, formData)
  }

}
