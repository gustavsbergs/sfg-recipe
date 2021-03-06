package guru.springframwork.sfgrecipe.controllers;

import guru.springframwork.sfgrecipe.commands.RecipeCommand;
import guru.springframwork.sfgrecipe.domain.Recipe;
import guru.springframwork.sfgrecipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@Controller
public class RecipeController {
        private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/show";

    }
    @RequestMapping("recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/recipeform";
    }

    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command){
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/show/" + savedCommand.getId();
    }

}
