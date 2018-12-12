package guru.springframwork.sfgrecipe.converters;

import guru.springframwork.sfgrecipe.commands.UnitOfMeasureCommand;
import guru.springframwork.sfgrecipe.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String DESCRIPTION = "Description";

    UnitOfMeasureToUnitOfMeasureCommand converter;
    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullObject() throws  Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }
    @Test
    public void convert() throws Exception {
        //given
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(ID_VALUE);
        unitOfMeasure.setDescription(DESCRIPTION);

        //when
        UnitOfMeasureCommand unitOfMeasureCommand = converter.convert(unitOfMeasure);

        //then
        assertNotNull(unitOfMeasureCommand);
        assertEquals(ID_VALUE, unitOfMeasureCommand.getId());
        assertEquals(DESCRIPTION, unitOfMeasureCommand.getDescription());
    }
}