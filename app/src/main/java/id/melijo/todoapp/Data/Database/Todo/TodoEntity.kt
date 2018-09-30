package id.melijo.todoapp.Data.Database.Todo

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "todo_table")
data class TodoEntity(@PrimaryKey(autoGenerate = true)
                      @ColumnInfo(name = "todo_id") val id: Long?,

                      @ColumnInfo(name = "todo_title") val title: String,
                      @ColumnInfo(name = "todo_description") val description: String) {
    override fun toString(): String = "$title - $description \n\n"
}