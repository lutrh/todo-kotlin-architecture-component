package id.melijo.todoapp.Data.Repository

import android.arch.lifecycle.LiveData
import id.melijo.todoapp.Data.Database.Todo.TodoEntity

interface TodoRepositoryInterface {
    fun insert(todo: TodoEntity)
    fun getAllTodos() : LiveData<List<TodoEntity>>
}