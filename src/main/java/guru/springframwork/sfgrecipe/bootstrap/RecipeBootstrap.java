package guru.springframwork.sfgrecipe.bootstrap;

import guru.springframwork.sfgrecipe.domain.Recipe;
import guru.springframwork.sfgrecipe.domain.UnitOfMeasure;
import guru.springframwork.sfgrecipe.repositories.CategoryRepository;
import guru.springframwork.sfgrecipe.repositories.RecipeRepository;
import guru.springframwork.sfgrecipe.repositories.UnitOfMeasureRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecipeBootstrap {
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }
    private List<Recipe> getRecipes(){
        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
        return recipes;
    }
}
