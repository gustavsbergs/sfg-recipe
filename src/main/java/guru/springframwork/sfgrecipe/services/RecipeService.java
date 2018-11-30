package guru.springframwork.sfgrecipe.services;

import guru.springframwork.sfgrecipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
