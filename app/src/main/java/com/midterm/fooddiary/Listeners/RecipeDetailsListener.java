package com.midterm.fooddiary.Listeners;

import com.midterm.fooddiary.Models.RecipeDetailsResponse;

public interface RecipeDetailsListener {
    void didFetch(RecipeDetailsResponse response,String message);
    void didError(String message);
}
