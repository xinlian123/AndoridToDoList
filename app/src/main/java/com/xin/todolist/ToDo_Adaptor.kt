package com.xin.todolist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo_row.view.*

class ToDo_Adaptor(var todos2: List<String>): RecyclerView.Adapter<ToDo_Adaptor.ToDoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoHolder {
        return ToDoHolder(LayoutInflater.from(parent.context).inflate(R.layout.todo_row, parent,false))//To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {

        return todos2.count() //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ToDoHolder, position: Int) {
        val title = todos2[position]
        holder.bindTodo((title))
        //To change body of created functions use File | Settings | File Templates.
    }

    class ToDoHolder(v:View) : RecyclerView.ViewHolder(v), View.OnClickListener{

        var view: View = v
        var title = ""
        init {
            v.setOnClickListener(this)
        }

        fun bindTodo(title:String){
            this.title = title
            view.textView.text  = title
        }

        override fun onClick(v: View?) {
            val intent = Intent(view.context,CompleteToDoActivity::class.java)
            intent.putExtra("title", title)
            startActivity(view.context,intent,null)
        }

    }


}