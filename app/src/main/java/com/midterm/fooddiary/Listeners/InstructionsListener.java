package com.midterm.fooddiary.Listeners;

import com.midterm.fooddiary.Models.InstructionsResponse;

import java.util.List;

public interface InstructionsListener {
    void didFetch(List<InstructionsResponse> response, String message);
    void didError(String message);
}
