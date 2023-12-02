package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecipesAdapter(private val recipes: List<Recipes>, private val onItemClick: (Recipes) -> Unit) :
    RecyclerView.Adapter<RecipesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipes, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipes = recipes[position]
        holder.bind(recipes)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val ingredientsTextView: TextView = itemView.findViewById(R.id.ingredientsTextView)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(recipes[position])
                }
            }
        }

        fun bind(recipes: Recipes) {
            titleTextView.text = recipes.title
            ingredientsTextView.text = recipes.ingredients
            Glide.with(itemView.context)
                .load(recipes.imageUrl)
                .into(imageView)
        }
    }
}