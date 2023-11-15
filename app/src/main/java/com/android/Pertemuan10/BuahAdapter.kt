package com.android.Pertemuan10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.Pertemuan10.databinding.ItemListBinding

typealias OnClickBuah = (Buah) -> Unit

class BuahAdapter(private val listBuah: List<Buah>, private val onClickBuah: (Buah) -> Unit) :
    RecyclerView.Adapter<BuahAdapter.ItemBuahViewHolder>() {

    inner class ItemBuahViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Buah) {
            with(binding) {
                itemName.text = data.name
                itemPrice.text = data.price

                itemView.setOnClickListener {
                    onClickBuah(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemBuahViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemBuahViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listBuah.size
    }

    override fun onBindViewHolder(holder: ItemBuahViewHolder, position: Int) {
        val buah = listBuah[position]
        holder.bind(buah)
        holder.binding.itemPict.setImageResource(buah.img)

        holder.itemView.setOnClickListener {
            onClickBuah(buah)
        }
    }

}