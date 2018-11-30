package guru.springframwork.sfgrecipe.controllers;

import guru.springframwork.sfgrecipe.domain.Category;
import guru.springframwork.sfgrecipe.domain.UnitOfMeasure;
import guru.springframwork.sfgrecipe.repositories.CategoryRepository;
import guru.springframwork.sfgrecipe.repositories.UnitOfMeasureRepository;
import guru.springframwork.sfgrecipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
