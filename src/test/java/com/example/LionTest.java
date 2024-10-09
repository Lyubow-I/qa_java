package com.example;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private Feline feline;
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        feline = Mockito.mock(Feline.class);
        lion = new Lion("Самец", feline);
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testGetKittens() {
        Mockito.when(feline.getKittens()).thenReturn(2);
        assertEquals(2, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Мясо"));
        List<String> food = lion.getFood();
        assertEquals(List.of("Мясо"), food);
    }
    @Test(expected = Exception.class)
    public void shouldThrowExceptionForInvalidSex() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Неизвестно", feline);
    }
}
