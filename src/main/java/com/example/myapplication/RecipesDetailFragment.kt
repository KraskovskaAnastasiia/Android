package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class RecipesDetailFragment : Fragment(R.layout.fragment_recipes_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recipes: Recipes = RecipesDetailFragmentArgs.fromBundle(requireArguments()).recipes

        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val ingredientsTextView: TextView = view.findViewById(R.id.ingredientsTextView)
        val stepsTextView: TextView = view.findViewById(R.id.stepsTextView)
        val imageView: ImageView = view.findViewById(R.id.imageView)

        titleTextView.text = recipes.title
        ingredientsTextView.text = recipes.ingredients
        stepsTextView.text = recipes.steps
        Glide.with(requireContext())
            .load(recipes.imageUrl)
            .into(imageView)
    }
}