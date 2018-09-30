package id.melijo.todoapp.Data.Database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import id.melijo.todoapp.Data.Database.Todo.TodoEntity
import id.melijo.todoapp.Data.Database.Todo.TodoDao

@Database(entities = arrayOf(TodoEntity::class), version = 1)
abstract class Database: RoomDatabase() {

    abstract fun todoDao() : TodoDao

}