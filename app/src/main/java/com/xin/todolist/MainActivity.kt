package com.xin.todolist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    lateinit var layoutManager: LinearLayoutManager
    lateinit var adaptor: ToDo_Adaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val intent = Intent(this, createToDoActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        updateRecycler()

    }

    fun updateRecycler() {
        var prefs = getSharedPreferences(getString(R.string.Shard_prefs), Context.MODE_PRIVATE)
        var todos1 = prefs.getStringSet(getString(R.string.Todo_String), setOf())

        if (todos1 != null) {
            var todos2 = todos1.toMutableSet()

            layoutManager = LinearLayoutManager(this)
            recyclerView.layoutManager = layoutManager

            adaptor = ToDo_Adaptor(todos2.toList())
            recyclerView.adapter = adaptor
            println(todos2)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.action_delete_all) {
            var prefs = getSharedPreferences(getString(R.string.Shard_prefs), Context.MODE_PRIVATE)
            prefs.edit().putStringSet(getString(R.string.Todo_String), null).apply()

            updateRecycler()
            return true
        }
            return super.onOptionsItemSelected(item)
    }
}
