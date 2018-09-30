package id.melijo.todoapp.Data.Repository

import id.melijo.todoapp.Data.Database.Todo.TodoDao
import id.melijo.todoapp.Data.Database.Todo.TodoEntity
import org.jetbrains.anko.doAsync

class TodoRepository(private val todoDao: TodoDao)
    : TodoRepositoryInterface {

    override fun insert(todo: TodoEntity) {
        doAsync {
            todoDao.insert(todo)
        }
    }

    override fun getAllTodos() = todoDao.getAllTodos()

}