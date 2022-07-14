import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { EmployeeserviceService } from '../home/employeeservice.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  constructor(public employeeService:EmployeeserviceService,public dialog: MatDialog) { 
    
    this.updateCheck();
  
  }

  ngOnInit(): void {
  }
  emailPattern=/^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/
EmployeeForm = new FormGroup({
  name: new FormControl('',[Validators.required]),
  email: new FormControl('',[Validators.required,Validators.pattern(this.emailPattern)]),
  dob: new FormControl('',Validators.required),
  age:new FormControl(''),
  salary: new FormControl('',Validators.required),
  status: new FormControl('',Validators.required)
})

get email() {
  return this.EmployeeForm.get('email');
}
get name() {
  return this.EmployeeForm.get('name');
}
get dob() {
  return this.EmployeeForm.get('dob');
}
get salary() {
  return this.EmployeeForm.get('salary');
}
get status() {
  return this.EmployeeForm.get('status');
}

addRecord() {
  this.gettingAge();
  this.employeeService.add(this.EmployeeForm.value).subscribe(response=> {
    console.log(response);
    this.dialog.closeAll();
    alert("Record added Successfully");
  })
}

gettingAge() {
  let year=this.EmployeeForm.get('dob').value.split('-')[0];
  let dt:any=Date.call('year').toString().split(" ")[3];
  let a=dt-year;
  console.log("age="+a);
  this.EmployeeForm.get('age').patchValue(a);
}
updateCheck() {
  if(this.employeeService.updateStatus==true){
    this.EmployeeForm.patchValue({
      name:this.employeeService.updateData.name,
    email:this.employeeService.updateData.email,
  salary: this.employeeService.updateData.salary,
dob: this.employeeService.updateData.dob,
status: this.employeeService.updateData.status});
  }
}
updateRecord() {
 this.employeeService.updateData.email=this.EmployeeForm.get('email').value;
 this.employeeService.updateData.name=this.EmployeeForm.get('name').value;
 this.employeeService.updateData.salary=this.EmployeeForm.get('salary').value;
 this.employeeService.updateData.dob=this.EmployeeForm.get('dob').value;

 this.employeeService.updateData.status=this.EmployeeForm.get('status').value;
this.gettingAge();

  this.employeeService.update(this.employeeService.updateData).subscribe(response=>{
    this.employeeService.updateStatus=false;
    this.dialog.closeAll();
    console.log(response);
  })
}
}
