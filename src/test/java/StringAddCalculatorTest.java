import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {
    @Test
    public void splitAndSum_null_또는_빈문자(){
        int result = StringAddCalculator.splitAndSum(null);
        assertEquals(result, 0);

        result = StringAddCalculator.splitAndSum("");
        assertEquals(result, 0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertEquals(result, 1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertEquals(result, 3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertEquals(result, 6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertEquals(result, 6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThrows(RuntimeException.class, () -> StringAddCalculator.splitAndSum("-1,2,3"));
    }

    @Test
    void isBlank(){
        assertEquals("Hello".isBlank(), false);
        assertEquals("Hello ".isBlank(), false);

        assertEquals("".isBlank(), true);
        assertEquals(" ".isBlank(), true);
        assertEquals("\n\t".isBlank(), true);
    }

    @Test
    void isEmpty(){
        assertEquals("Hello".isEmpty(), false);
        assertEquals("Hello ".isEmpty(), false);

        assertEquals("".isEmpty(), true);
        assertEquals(" ".isEmpty(), false);
        assertEquals("\n\t".isEmpty(), false);
    }
}