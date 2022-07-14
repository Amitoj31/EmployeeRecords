import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeserviceService {

  constructor(private httpClient:HttpClient) { }

  url:string="http://localhost:9101/employee/v1/emp";
  updateData:any;
  updateStatus=false;

  add(data:any) {
    return this.httpClient.post<any>(this.url,data);
  }
  getAll() {
    return this.httpClient.get<any>(this.url);
  }
  delete(id:any) {
    return this.httpClient.delete<any>(this.url+"/"+id);
  }
  update(data:any) {
    return this.httpClient.put<any>(this.url,data);
  }
}
