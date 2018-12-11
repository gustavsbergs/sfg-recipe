package guru.springframwork.sfgrecipe.converters;

import guru.springframwork.sfgrecipe.commands.IngredientCommand;
import guru.springframwork.sfgrecipe.domain.Ingredient;
import guru.springframwork.sfgrecipe.domain.Recipe;
import guru.springframwork.sfgrecipe.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientToIngredientCommandTest {

    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "burger";
    public static final Long ID_VALUE = new Long(1L);
    public static final Long UOM_ID = new Long(2L);

    IngredientToIngredientCommand converter;
    @Before
    public void setUp() throws Exception{
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void testNullObject(){
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject(){
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    public void convert() throws Exception{
        //when
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setRecipe(RECIPE);
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(UOM_ID);
        ingredient.setUom(unitOfMeasure);

        //given
        IngredientCommand ingredientCommand = converter.convert(ingredient);

        //then
        assertNotNull(ingredientCommand);
        assertNotNull(ingredientCommand.getUnitOfMeasure());
        assertEquals(ID_VALUE, ingredientCommand.getId());
        assertEquals(AMOUNT, ingredientCommand.getAmount());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
        assertEquals(UOM_ID, ingredientCommand.getUnitOfMeasure().getId());

    }

    @Test
    public void convertWithNullUOM() throws Exception{
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);

        //when
        IngredientCommand ingredientCommand = converter.convert(ingredient);

        //then

        assertNotNull(ingredientCommand);
        assertNull(ingredientCommand.getUnitOfMeasure());
        assertEquals(ID_VALUE, ingredientCommand.getId());
        assertEquals(AMOUNT, ingredientCommand.getAmount());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
    }
}