package id.melijo.todoapp.Data.Database.Todo

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface TodoDao {
    @Insert
    fun insert(todoEntity: TodoEntity)

    @Query("SELECT * FROM todo_table")
    fun getAllTodos() : LiveData<List<TodoEntity>>
}