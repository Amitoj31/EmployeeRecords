import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { EmployeeComponent } from '../employee/employee.component';
import { EmployeeserviceService } from './employeeservice.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  constructor(public dialog: MatDialog,private employService:EmployeeserviceService) {
    
   }

  ngOnInit(): void {
    this.fetchRecords();
  }
  openDialog(): void {
    
    this.dialog.open(EmployeeComponent, {
      panelClass : 'custom-dialog-container'
    });
  }
allRecords:any=[];
fetchRecords() {
  this.employService.getAll().subscribe(response=>{
    this.allRecords=response;
    console.log(response)
  })
}
displayedColumns=["id","name","email","salary","dob","age","status","Update","Delete"]

deleteRecord(id:any) {
  this.employService.delete(id).subscribe(response=>{
    this.fetchRecords();
    alert("Record Deleted")
  });
}
updateRecord(data:any) {
  this.employService.updateData=data;
  this.employService.updateStatus=true;
  this.openDialog();
//   this.employService.update(data).subscribe(res=>{
//     console.log(res)
//   })
}

}
