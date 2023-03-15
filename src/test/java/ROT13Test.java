import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ROT13Test {

    ROT13 rot13 = new ROT13();

    @Test
    void rot13_Tere() {
        assertEquals("Grer", rot13.rot13("Tere"));
    }
    @Test
    void rot13_Grer() {
        assertEquals("Tere", rot13.rot13("Grer"));
    }
    @Test
    void rot13_empty() {
        assertEquals("", rot13.rot13(""));
    }
    @Test
    void rot13_n() {
        assertEquals("aaa", rot13.rot13("nnn"));
    }
    @Test
    void rot13_m() {
        assertEquals("zzz", rot13.rot13("mmm"));
    }
    @Test
    void rot13_zuzu() {
        assertEquals("mhmh", rot13.rot13("zuzu"));
    }
    @Test
    void rot13_specialCharacters() {
        assertEquals("*1+-/", rot13.rot13("*1+-/"));
    }
    @Test
    void rot13_Tere2() {
        assertEquals("Grer", rot13.rot13v2("Tere"));
    }
    @Test
    void rot13_Grer2() {
        assertEquals("Tere", rot13.rot13v2("Grer"));
    }
    @Test
    void rot13_empty2() {
        assertEquals("", rot13.rot13v2(""));
    }
    @Test
    void rot13_n2() {
        assertEquals("aaa", rot13.rot13v2("nnn"));
    }
    @Test
    void rot13_m2() {
        assertEquals("zzz", rot13.rot13v2("mmm"));
    }
    @Test
    void rot13_zuzu2() {
        assertEquals("mhmh", rot13.rot13v2("zuzu"));
    }
    @Test
    void rot13_specialCharacters2() {
        assertEquals("*1+-/", rot13.rot13v2("*1+-/"));
    }
    @Test
    void rot13_Tere3() {
        assertEquals("Grer", rot13.rot13v3("Tere",13));
    }
    @Test
    void rot13_Grer3() {
        assertEquals("Tere", rot13.rot13v3("Grer",3));
    }
    @Test
    void rot13_empty3() {
        assertEquals("", rot13.rot13v3("",23));
    }
    @Test
    void rot13_n3() {
        assertEquals("aaa", rot13.rot13v3("nnn",21));
    }
    @Test
    void rot13_m3() {
        assertEquals("zzz", rot13.rot13v3("mmm",0));
    }
    @Test
    void rot13_zuzu3() {
        assertEquals("mhmh", rot13.rot13v3("zuzu",26));
    }
    @Test
    void rot13_specialCharacters3() {
        assertEquals("*1+-/", rot13.rot13v3("*1+-/",14));
    }
    @Test
    void rot13_randomString() {

        String randomString = createRandomString();
        assertEquals(randomString, rot13.rot13v2(rot13.rot13v2(randomString)));
    }

    @ParameterizedTest
    @CsvSource({"zzz,mmm", "mhmh,zuzu"})
    public void rot13(String input, String expectedResult) {
        assertEquals(expectedResult,rot13.rot13v2(input));
    }

    private String createRandomString () {
        Random random = new Random();
        int randomInt = random.nextInt(100);

        char[] chars = new char[randomInt];
        for (int i = 0; i < randomInt; i++) {
            int randomChar = random.nextInt(32,128);
            chars[i] = (char)randomChar;
        }
        return String.valueOf(chars);
    }
}