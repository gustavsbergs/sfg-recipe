package guru.springframwork.sfgrecipe.controllers;

import guru.springframwork.sfgrecipe.domain.Category;
import guru.springframwork.sfgrecipe.domain.UnitOfMeasure;
import guru.springframwork.sfgrecipe.repositories.CategoryRepository;
import guru.springframwork.sfgrecipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> categoryUnitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat id is: " + categoryOptional.get().getId());
        System.out.println("Uom id is " + categoryUnitOfMeasure.get().getId());
        return "index";
    }
}
