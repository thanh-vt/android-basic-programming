package com.thanhvt.todo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.thanhvt.todo.R
import com.thanhvt.todo.model.User


class UserAdapter(private val context: Context, private val users: List<User>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.photoThumbnail)
        val textView: TextView = itemView.findViewById(R.id.photoTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(this.context)
        val photoLineView: View = inflater.inflate(R.layout.user_line, parent, false)
        return ViewHolder(photoLineView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user: User = this.users[position]
        Picasso.with(context)
            .load(user.avatar)
            .placeholder(R.drawable.image_border)
            .error(R.drawable.default_img)
            .into(holder.imageView)
        holder.textView.text = context.getString(R.string.user_full_name, user.firstName, user.lastName)
    }

    override fun getItemCount(): Int {
        return this.users.size
    }
}