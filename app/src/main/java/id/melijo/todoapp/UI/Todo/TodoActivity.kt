package id.melijo.todoapp.UI.Todo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import id.melijo.todoapp.Data.Database.Todo.TodoEntity
import id.melijo.todoapp.R
import kotlinx.android.synthetic.main.activity_todo.*
import kotlinx.android.synthetic.main.content_todo.*
import kotlinx.android.synthetic.main.todo_item.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class TodoActivity : AppCompatActivity(), KodeinAware {

    override val kodein by closestKodein()
    private val todoViewModelFactory: TodoViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        setSupportActionBar(toolbar)
        initializeUi()
    }

    private fun initializeUi() {
        val viewModel = ViewModelProviders.of(this, todoViewModelFactory).get(TodoViewModel::class.java)

        viewModel.getAllTodos().observe(this, Observer { todos ->
            val string = StringBuilder()
            todos?.forEach { todo ->
                string.append(todo.toString())
            }
            tv_todo.text = string.toString()
        })

        bt_add.setOnClickListener {
            val todo = TodoEntity(null, et_todo_title.text.toString(), et_todo_description.text.toString())
            viewModel.insert(todo)
            et_todo_title.setText("")
            et_todo_description.setText("")
        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_todo, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
