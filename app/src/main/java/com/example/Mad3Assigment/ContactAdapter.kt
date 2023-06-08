package com.example.Mad3Assigment


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.sharedpref.R
import java.lang.ref.WeakReference


class MyAdapter(
    val data: List<Data>,
    private val listener: WeakReference<ContactItemClickListener>
) : Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_design, parent, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = data[position].name
        holder.number.text = data[position].number
        holder.itemView.setOnClickListener {
            listener.get()?.onItemClicked(phone = data[position].number)
        }
    }
    
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image = itemView.findViewById<ImageView>(R.id.image)
        val name = itemView.findViewById<TextView>(R.id.name)
        val number = itemView.findViewById<TextView>(R.id.phonenumber)
    }

}

