import { InMemoryDbService } from 'angular-in-memory-web-api';

export class TaskInMemory implements InMemoryDbService {
  createDb() {
    let tasks = [{
      title: 'Penser à faire sa valise.',
      description: 'Emmener la crème solaire et les lunettes de soleil.', 
    }];
    return {tasks};
  }
}
