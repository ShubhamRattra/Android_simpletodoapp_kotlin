package com.rattra.kotlintodolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.rattra.kotlintodolist.adapters.TodoAdapter
import com.rattra.kotlintodolist.models.Todo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val todos: ArrayList<Todo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todos.add(Todo("First Task",false))

        rvTodos.layoutManager = LinearLayoutManager(this)
        val todoAdapter:TodoAdapter = TodoAdapter(todos)
        rvTodos.adapter = todoAdapter

        btnAdd.setOnClickListener{
            val newTodo = etNewTodo.text.toString()
            todos.add(Todo(newTodo, false))
            todoAdapter.notifyDataSetChanged()
        }
    }
}
