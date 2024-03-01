package com.example.retrofitparallelcoroutines.ui.main_fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitparallelcoroutines.R
import com.example.retrofitparallelcoroutines.data.domain.model.user.NameModel
import com.example.retrofitparallelcoroutines.databinding.ItemRecyclerUserBinding

class UsersAdapter(
    private val listener: UserListener,
    private val users: MutableList<NameModel> = mutableListOf()
) : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    interface UserListener {
        fun onUserClick(idUser: Int)
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemRecyclerUserBinding.bind(view)
        fun setListener(idUser: Int) {
            binding.root.setOnClickListener {
                listener.onUserClick(idUser)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_recycler_user, parent, false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            tvIdContent.text = users[position].id.toString()
            tvNameContent.text = users[position].name
        }
        holder.setListener(users[position].id)
    }

    override fun getItemCount(): Int = users.count()


    fun refreshData(namesList: MutableList<NameModel>) {
        users.clear()
        users.addAll(namesList)
        notifyDataSetChanged()
    }
}