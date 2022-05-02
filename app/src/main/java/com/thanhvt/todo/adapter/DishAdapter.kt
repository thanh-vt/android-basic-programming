package com.thanhvt.todo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.thanhvt.todo.R
import com.thanhvt.todo.model.Dish

/**
 *
 *
 * @created 5/2/2022 - 10:48 AM
 * @project TodoApp
 * @author pysga
 * @since 1.0
 **/
class DishAdapter(var context: Context, var dishes: ArrayList<Dish>): BaseAdapter() {

    class ViewHolder(row: View) {
        var textviewDishName: TextView
        var imageviewDishUri: ImageView

        init {
            textviewDishName = row.findViewById(R.id.dishName) as TextView
            imageviewDishUri = row.findViewById(R.id.dishImg) as ImageView
        }
    }
    override fun getCount(): Int {
        return dishes.size
    }

    override fun getItem(position: Int): Any {
        return dishes[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder
        if (convertView == null) {
            val layoutInflater: LayoutInflater = LayoutInflater.from(context)
            view = layoutInflater.inflate(R.layout.dish_line, null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = convertView.tag as ViewHolder
        }
        val dish : Dish = getItem(position) as Dish
        viewHolder.textviewDishName.text = dish.name
        viewHolder.imageviewDishUri.setImageResource(dish.imageUri)
        return view!!
    }
}