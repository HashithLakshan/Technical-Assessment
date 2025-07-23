import { Component } from '@angular/core';
import { Task } from '../../shared/task';
import { TaskService } from '../../service/task.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-task-page',
  templateUrl: './task-page.component.html',
  styleUrl: './task-page.component.css',
})
export class TaskPageComponent {
  task: Task = {
    taskId: '',
    taskTitle: '',
    taskDiscription: '',
   
  };

  collectionSize: number = 0;
  page: number = 1;
  pageSize: number = 5;

  taskAssigned: Task[] = [];

  constructor(private taskService: TaskService) {
    this.getAllFilterTasks('ACTIVE', 'ASSIGNED');
  }

  saveTask() {
    let taskId = this.getRandomSixDigitNumber();
    this.task.taskId = taskId;
    console.log(this.task);
    this.taskService.saveTask(this.task).subscribe(
      (response) => {
        if (response.status === true) {
          this.getAllFilterTasks('ACTIVE', 'ASSIGNED');
          this.clearForm();
          Swal.fire('', response.commonMessage, 'success');
        } else {
          if (response.errorMessages.length) {
            for (let i = 0; i < response.errorMessages.length; i++) {
              Swal.fire('', response.errorMessages[i], 'info');
            }
          } else {
            Swal.fire('', response.commonMessage, 'info');
          }
        }
      },
      (error) => {
        Swal.fire('', error.message, 'info');
      }
    );
  }

  getAllFilterTasks(commonStatus: 'ACTIVE', taskStatus: 'ASSIGNED') {
    this.taskService.getAllTasksFilter(commonStatus, taskStatus, this.page - 1, this.pageSize).subscribe(
        (response) => {
          this.taskAssigned = response.payload[0];
          console.log(response.payload.length);

          if (response.pages && response.pages.length > 0) {
            const pagination = response.pages[0];

            this.collectionSize = pagination.totalItems; // Total number of items
            this.pageSize = 5; // Number of items per page (should match backend size)
          } else {
            console.warn('Pagination details not found in response');
          }
        },
        (error) => {
          Swal.fire('', 'Error fetching tasks', 'error');
        }
      );
  }

  updateStatus(taskId: any, status: any) {
    
    this.taskService.statusUpdate(taskId, status).subscribe(
      (response) => {
        if (response.status === true) {
                    this.getAllFilterTasks('ACTIVE', 'ASSIGNED');
          Swal.fire('', response.commonMessage, 'success');
        } else {
          Swal.fire('', response.commonMessage, 'error');
        }
      },
      (error) => {
        Swal.fire('', error.message, 'error');
      }
    );
  }

  clearForm() {
    this.task = {
      taskId: '',
      taskTitle: '',
      taskDiscription: '',
    };
  }

  onPageChange(page: number) {
    this.page = page;
    this.getAllFilterTasks('ACTIVE', 'ASSIGNED');
  }

  getRandomSixDigitNumber(): string {
    return Math.floor(100000 + Math.random() * 900000).toString();
  }
}
