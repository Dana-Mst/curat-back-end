package com.curat.eshopbackend.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public void addNewRecipe(Recipe recipe) {
//        TODO date to be added
        recipeRepository.save(recipe);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(Integer id) throws Exception {
        return recipeRepository
                .findById(id)
                .orElseThrow(() -> new Exception(String.format("Recipe with id %d not found!", id)));
    }




}
