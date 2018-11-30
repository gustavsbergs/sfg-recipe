package guru.springframwork.sfgrecipe.repositories;

import guru.springframwork.sfgrecipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
