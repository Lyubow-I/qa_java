package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTest {
    private final String sex; // Пол
    private final boolean expectedHasMane; // Ожидаемое наличие гривы

    public ParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}
