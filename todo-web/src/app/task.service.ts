import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

import { Task } from './task.model';

import 'rxjs/add/operator/toPromise';

const TASKS: Task[] = [{
  title: "Penser à faire les valises.",
  description: "Penser à la crème solaire.",
}];

@Injectable()
export class TaskServices {

  constructor(private http: Http) {}

  getTasks(): Promise<Task[]> {
    return this.http.get("api/tasks")
      .toPromise()
      .then(response => response.json().data as Task[]);
  }

}
