//The purpose of this file is to define a listener interface that other classes can implement to receive callbacks when a random recipe API response is fetched successfully or when an error occurs.
package com.midterm.fooddiary.Listeners;

import com.midterm.fooddiary.Models.RandomRecipeApiResponse;

public interface RandomRecipeResponseListener {
    //method named didFetch, which takes two parameters: a RandomRecipeApiResponse object named response and a String named message. This method is responsible for handling the successful fetching of a random recipe API response.
    //method named didError, which takes a String parameter named message. This method is responsible for handling errors that occur during the fetching of a random recipe API response.
    void didFetch(RandomRecipeApiResponse response, String message);
    void didError(String message);
}
