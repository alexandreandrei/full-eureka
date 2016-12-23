import { Component, OnInit } from '@angular/core';

import { Task } from './task.model';
import { TaskServices } from './task.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [TaskServices],
})
export class AppComponent implements OnInit {

  tasks: Task[] = [];

  constructor(private taskServices: TaskServices) { }

  ngOnInit() {
    this.taskServices.getTasks().then(tasks => this.tasks = tasks);
  }

}
