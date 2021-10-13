package com.curat.eshopbackend.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping
    public void addNewRecipe(@RequestBody Recipe recipe) {
        recipeService.addNewRecipe(recipe);
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable Integer id) throws Exception {
        return recipeService.getRecipeById(id);
    }

    @DeleteMapping("delete/{id}")
    public Boolean deleteRecipe(@PathVariable Integer id) {
        if( id == null) {
            return Boolean.FALSE;
        }
        return recipeService.deleteRecipe(id);
    }

//    TODO update recipe

}
