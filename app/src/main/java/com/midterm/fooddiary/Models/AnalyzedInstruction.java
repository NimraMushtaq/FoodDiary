//The purpose of the AnalyzedInstruction class is to represent an analyzed instruction or set of instructions for a specific cooking recipe.By using the AnalyzedInstruction class, you can organize and store the information related to a specific cooking instruction, including the instruction's name and a list of steps.
package com.midterm.fooddiary.Models;

import java.util.ArrayList;

public class AnalyzedInstruction {
    public String name;
    public ArrayList<Step> steps;
}
