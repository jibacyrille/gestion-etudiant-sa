import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { StudentsService } from '../services/students.service';

@Component({
  selector: 'app-payments',
  templateUrl: './payments.component.html',
  styleUrl: './payments.component.css'
})
export class PaymentsComponent implements OnInit{
  public payments : any;
  public dataSource : any;
  public displayedColumns=['id','date','amount','type',
    'status','firstName','details', 'update','delete'];

   /* color = 'green'
[style.background-color]="color" ligne a mettre dans le fichier html
    changeColor() {
      this.color = 'red';
    }*/

  @ViewChild(MatPaginator) paginator! : MatPaginator;
  @ViewChild(MatSort) sort! : MatSort;
  constructor(private studentsService : StudentsService){
  }
  ngOnInit(): void {
    this.studentsService.getAllPayments()
      .subscribe({
        next : data=>{
          this.payments=data
          this.dataSource=new MatTableDataSource(this.payments);
          this.dataSource.paginator=this.paginator
          this.dataSource.sort=this.sort;
        },
        error: err =>{
          console.log(err)
        }
      })
    
  }

  applyFilter(event: Event): void {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
  

}
