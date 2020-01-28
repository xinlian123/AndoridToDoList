package com.xin.todolist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_to_do.*

class createToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_to_do)

        savebutton.setOnClickListener {
            var title = ""
            var tmp = TitleText.text.toString()
            if (TitleText.getText().toString().isEmpty()) {
                tmp = "Nothing"
            }
            if (Importantox.isChecked) {
                title = "❗" + tmp
            } else {
                title =  tmp
            }

            var prefs = getSharedPreferences(getString(R.string.Shard_prefs), Context.MODE_PRIVATE)
            var todos1 = prefs.getStringSet(getString(R.string.Todo_String), setOf())

            if (todos1 != null) {
                var todos2 = todos1.toMutableSet()

                todos2.add(title)

                prefs.edit().putStringSet(getString(R.string.Todo_String), todos2).apply()
            }
            finish()
        }
    }
}
