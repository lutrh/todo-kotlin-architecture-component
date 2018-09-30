package id.melijo.todoapp.UI.Todo


import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import id.melijo.todoapp.Data.Repository.TodoRepositoryInterface

class TodoViewModelFactory(private val todoRepository: TodoRepositoryInterface)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TodoViewModel(todoRepository) as T
    }

}