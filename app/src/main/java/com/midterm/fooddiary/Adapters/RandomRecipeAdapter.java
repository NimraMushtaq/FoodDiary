//this file facilitates the display of a list of recipes in a RecyclerView, ensuring efficient item creation and recycling, and handles the binding of data to the appropriate views.
package com.midterm.fooddiary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.midterm.fooddiary.Listeners.RecipeClickListener;
import com.midterm.fooddiary.Models.Recipe;
import com.midterm.fooddiary.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RandomRecipeAdapter extends RecyclerView.Adapter<RandomRecipeViewHolder>{
//Creating objects
    //will be used to store the context and the list of recipes.
    Context context;
    List<Recipe> list;
    RecipeClickListener listener;

    //constructor for the RandomRecipeAdapter class. It takes a Context object and a list of recipes as parameters and initializes the context and list member variables.
    public RandomRecipeAdapter(Context context, List<Recipe> list,RecipeClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener=listener;
    }

    @NonNull
    @Override
    public RandomRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RandomRecipeViewHolder(LayoutInflater.from(context).inflate(R.layout.list_random_recipe, parent, false));

    }
//This method binds the data to the views of the RandomRecipeViewHolder. It sets the values for the recipe title, likes, servings, time, and loads the recipe image using Picasso library.
    @Override
    public void onBindViewHolder(@NonNull RandomRecipeViewHolder holder, int position) {
        holder.textView_title.setText(list.get(position).title);
        holder.textView_title.setSelected(true);
        holder.textView_likes.setText(list.get(position).aggregateLikes+" Likes");
        holder.textView_servings.setText(list.get(position).servings+" Servings");
        holder.textView_time.setText(list.get(position).readyInMinutes+" Minutes");
        Picasso.get().load(list.get(position).image).into(holder.imageView_food);

        holder.random_list_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onRecipeClicked(String.valueOf(list.get(holder.getAdapterPosition()).id));
            }
        });

    }
//returns the number of items in the list, which represents the number of recipes to be displayed.
    @Override
    public int getItemCount() {
        return list.size();
    }
}
class RandomRecipeViewHolder extends RecyclerView.ViewHolder {
CardView random_list_container;
TextView textView_title, textView_servings, textView_likes, textView_time;
ImageView imageView_food;

//Initializing all the Views
    //the constructor for the RandomRecipeViewHolder class.
    public RandomRecipeViewHolder(@NonNull View itemView) {
        super(itemView);
        random_list_container= itemView.findViewById(R.id.random_list_container);
        textView_title= itemView.findViewById(R.id.textView_title);
        textView_servings= itemView.findViewById(R.id.textView_servings);
        textView_likes= itemView.findViewById(R.id.textView_likes);
        textView_time= itemView.findViewById(R.id.textView_time);
        imageView_food= itemView.findViewById(R.id.imageView_food);


    }
}
