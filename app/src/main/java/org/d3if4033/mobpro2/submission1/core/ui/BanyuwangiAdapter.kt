package org.d3if4033.mobpro2.submission1.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*
import org.d3if4033.mobpro2.submission1.R
import org.d3if4033.mobpro2.submission1.core.domain.model.Banyuwangi
import java.util.*

class BanyuwangiAdapter : RecyclerView.Adapter<BanyuwangiAdapter.ListViewHolder>() {

    private var listData = ArrayList<Banyuwangi>()
    var onItemClick: ((Banyuwangi) -> Unit)? = null

    fun setData(newListData: List<Banyuwangi>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: Banyuwangi) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(data.gambar)
                    .into(iv_item_image)
                tv_item_title.text = data.nama
            }
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}