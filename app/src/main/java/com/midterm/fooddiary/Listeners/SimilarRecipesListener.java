package com.midterm.fooddiary.Listeners;

import com.midterm.fooddiary.Models.SimilarRecipeResponse;

import java.util.List;

public interface SimilarRecipesListener {
    void didFetch(List<SimilarRecipeResponse> response,String message);
    void didError(String message);
}
