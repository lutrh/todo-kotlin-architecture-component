package id.melijo.todoapp

import android.app.Application
import android.arch.persistence.room.Room
import id.melijo.todoapp.Data.Database.Database
import id.melijo.todoapp.Data.Database.Todo.TodoDao
import id.melijo.todoapp.Data.Repository.TodoRepository
import id.melijo.todoapp.Data.Repository.TodoRepositoryInterface
import id.melijo.todoapp.UI.Todo.TodoViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class TodoApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        bind<Database>() with singleton {
            Room.databaseBuilder(this@TodoApplication, Database::class.java, "todo_database")
                    .fallbackToDestructiveMigration()
                    .build()
        }
        bind<TodoDao>() with singleton { instance<Database>().todoDao() }
        bind<TodoRepositoryInterface>() with singleton { TodoRepository(instance()) }
        bind() from singleton { TodoViewModelFactory(instance()) }

    }

}