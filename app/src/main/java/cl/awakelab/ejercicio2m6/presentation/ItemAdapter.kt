package cl.awakelab.ejercicio2m6.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.awakelab.ejercicio2m6.data.local.Item
import cl.awakelab.ejercicio2m6.databinding.ItemLayoutBinding

class ItemAdapter: RecyclerView.Adapter <ItemAdapter.ItemViewHolder>(){
    lateinit var binding: ItemLayoutBinding
    private val listItem = mutableListOf<Item>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = listItem[position]
        holder.render(item)
    }

    class ItemViewHolder(val b: ItemLayoutBinding) : RecyclerView.ViewHolder(b.root) {
        fun render(item: Item){
            b.tvNombre.text = item.nombre
            b.tvPrecio.text = item.precio.toString()
            b.tvCantidad.text = item.cantidad.toString()
            b.tvTotal.text = (item.precio * item.cantidad).toString()
        }
    }
}