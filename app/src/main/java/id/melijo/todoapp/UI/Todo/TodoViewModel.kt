package id.melijo.todoapp.UI.Todo

import android.arch.lifecycle.ViewModel
import id.melijo.todoapp.Data.Database.Todo.TodoEntity
import id.melijo.todoapp.Data.Repository.TodoRepositoryInterface

class TodoViewModel(private val todoRepository: TodoRepositoryInterface)
    : ViewModel() {

    fun insert(todo: TodoEntity) = todoRepository.insert(todo)
    fun getAllTodos() = todoRepository.getAllTodos()

}