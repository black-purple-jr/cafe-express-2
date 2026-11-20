package me.bpxdevjr.cafe_express_2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import me.bpxdevjr.cafe_express_2.R
import me.bpxdevjr.cafe_express_2.data.Boisson

class MenuAdapter(private val context: Context, private val boissons: List<Boisson>) :
    BaseAdapter() {
    override fun getCount(): Int = boissons.size
    override fun getItem(position: Int): Any = boissons[position]
    override fun getItemId(position: Int): Long = position.toLong()

    private class ViewHolder (vue: View) {
        val image: ImageView = vue.findViewById(R.id.image)
        val nom: TextView = vue.findViewById(R.id.nom)
        val description: TextView = vue.findViewById(R.id.description)
        val prix: TextView = vue.findViewById(R.id.prix)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val vue: View
        var holder: ViewHolder

        if (convertView == null) {
            vue = LayoutInflater.from(context).inflate(R.layout.menu_item, parent, false)
            holder = ViewHolder(vue)
            vue.tag = holder
        } else {
            vue = convertView
            holder = vue.tag as ViewHolder
        }

        val boisson = boissons[position]

        holder.nom.text = boisson.nom
        holder.description.text = boisson.description
        holder.prix.text = boisson.prix.toString()
        holder.image.setImageResource(boisson.image)

        return vue
    }
}