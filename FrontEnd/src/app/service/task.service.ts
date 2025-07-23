import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

   constructor(private http: HttpClient) { }
     private apiUrl = 'http://localhost:8080/api/task';

  saveTask(payload: any): Observable<any> {
      return this.http.post<any>(`${this.apiUrl}/Save`, payload);
  }

  getAllTasksFilter(commonStatus: string,taskStatus : string, page: number, size: number): Observable<any> {
      return this.http.get<any>(`${this.apiUrl}/filtered?commonStatus=${commonStatus}&taskStatus=${taskStatus}&page=${page}&size=${size}`);
  }

  statusUpdate(taskId:string,status: string): Observable<any> {
      const url = `${this.apiUrl}/updateStatus?taskId=${taskId}&status=${status}`;
      return this.http.put<any>(url, {});
  }

}
