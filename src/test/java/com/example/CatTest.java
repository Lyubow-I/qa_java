package com.example;
import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CatTest {
    private Feline feline;
    private Cat cat;

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
        cat = new Cat(feline);
    }

    @Test
    public void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Мясо"));
        List<String> food = cat.getFood();
        assertEquals(List.of("Мясо"), food);
        Mockito.verify(feline).eatMeat();
    }
}
