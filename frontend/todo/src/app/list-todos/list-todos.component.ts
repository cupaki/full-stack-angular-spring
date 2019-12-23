import { Component, OnInit } from '@angular/core';
import { TodoDataService } from '../service/data/todo-data.service';
import { Router } from '@angular/router';

export class Todo {
  constructor(
    public id: number,
    public description: string,
    public done: boolean,
    public targetDate: Date
  ) { }
}

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {

  message : string;

  todos: Todo[];
  // = [
  //   new Todo(1, 'Learn to dance', false, new Date()),
  //   new Todo(2, 'Conquer angular', false, new Date()),
  //   new Todo(3, 'Visit India', false, new Date())
 //   {id : 1, description: 'Learn to dance'},
 //   {id : 2, description: 'Conquer angular'},
 //   {id : 3, description: 'Visit India'}
 // ]

  // todo = {
  //   id : 1,
  //   description : 'Learn to dance'
  // }

  constructor(
    private todoService: TodoDataService,
    private router : Router
  ) { }

  ngOnInit() {
    this.refreshTodos();
  }

  refreshTodos(){
    this.todoService.retrieveAllTodos('cupaki').subscribe(
      response => {
        console.log(response);
        this.todos = response;
      }
    )
  }

  addTodo() {
    this.router.navigate(['todos', -1])
  }

  updateTodo(id) {
    console.log(`update ${id}`)
    this.router.navigate(['todos', id]);

  }

  deleteTodo(id) {
    this.todoService.deleteTodo('cupaki', id).subscribe(
      response => {
        console.log(response);
        this.message = `Delete of Todo ${id} Successful!`;
        this.refreshTodos();
      }
    )
  }

}
