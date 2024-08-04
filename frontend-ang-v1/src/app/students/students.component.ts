import { Component, OnInit, ViewChild } from '@angular/core';
import { StudentsService } from '../services/students.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Student } from '../model/students.model';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrl: './students.component.css'
})
export class StudentsComponent implements OnInit{

  public students! : Array<Student>;
  public studentsDataSource! : MatTableDataSource<Student>;
  public displayedColumns=['id','firstName','lastName','code',
    'programId', 'paymentsList'];


  @ViewChild(MatPaginator) paginator! : MatPaginator;
  @ViewChild(MatSort) sort! : MatSort;
  constructor(private studentsService : StudentsService){
  }
  ngOnInit(): void {
    this.studentsService.getStudents()
      .subscribe({
        next : data=>{
          this.students=data
          this.studentsDataSource=new MatTableDataSource<Student>(this.students);
          this.studentsDataSource.paginator=this.paginator
          this.studentsDataSource.sort=this.sort;
        },
        error: err =>{
          console.log(err)
        }
      })
    
  }

  studentPayments(_t23: Student) {
    throw new Error('Method not implemented.');
    }
}