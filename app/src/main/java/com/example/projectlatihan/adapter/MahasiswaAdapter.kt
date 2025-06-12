package com.example.projectlatihan.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projectlatihan.R
import com.example.projectlatihan.entity.MahasiswaEntity


class MahasiswaAdapter(
    private val list: List<MahasiswaEntity>,
    private val onEdit: (MahasiswaEntity) -> Unit,
    private val onDelete: (MahasiswaEntity) -> Unit
) : RecyclerView.Adapter<MahasiswaAdapter.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvDescription: TextView = view.findViewById(R.id.tvDescription)
        val img: ImageView = view.findViewById(R.id.itemIv)
        val btnEdit: ImageView = view.findViewById(R.id.btnEdit)
        val btnDelete: ImageView = view.findViewById(R.id.btnDelete)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return ViewHolder(v)
    }


    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]


        holder.tvTitle.text = item.namaLengkap
        holder.tvDescription.text = item.alamat


        Glide.with(holder.itemView.context)
            .load(item.gambar)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.img)


        holder.btnEdit.setOnClickListener {
            onEdit(item)
        }


        holder.btnDelete.setOnClickListener {
            onDelete(item)
        }
    }
}

