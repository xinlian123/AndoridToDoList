package com.xin.todolist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_complete_to_do.*

class CompleteToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_to_do)
        var todo = intent.extras
        if (todo != null) {
            var todo2 = todo.getString("title")
            ToDotextView.text = todo2
            completeButton.setOnClickListener{
                var prefs = getSharedPreferences(getString(R.string.Shard_prefs), Context.MODE_PRIVATE)
                var todos1 = prefs.getStringSet(getString(R.string.Todo_String), setOf())

                if (todos1 != null) {
                    var todos2 = todos1.toMutableSet()
                    todos2.remove(todo2)
                    prefs.edit().putStringSet(getString(R.string.Todo_String),todos2).apply()
                    finish()
                }
            }
        }
    }
}
