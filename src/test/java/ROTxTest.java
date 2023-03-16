import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ROTxTest {

    ROTx ROTx = new ROTx();

    @Test
    void rot13_Tere() {
        assertEquals("Grer", ROTx.rot13("Tere"));
    }
    @Test
    void rot13_Grer() {
        assertEquals("Tere", ROTx.rot13("Grer"));
    }
    @Test
    void rot13_empty() {
        assertEquals("", ROTx.rot13(""));
    }
    @Test
    void rot13_n() {
        assertEquals("aaa", ROTx.rot13("nnn"));
    }
    @Test
    void rot13_m() {
        assertEquals("zzz", ROTx.rot13("mmm"));
    }
    @Test
    void rot13_zuzu() {
        assertEquals("mhmh", ROTx.rot13("zuzu"));
    }
    @Test
    void rot13_specialCharacters() {
        assertEquals("*1+-/", ROTx.rot13("*1+-/"));
    }
    @Test
    void rot13_Tere2() {
        assertEquals("Grer", ROTx.rot13v2("Tere"));
    }
    @Test
    void rot13_Grer2() {
        assertEquals("Tere", ROTx.rot13v2("Grer"));
    }
    @Test
    void rot13_empty2() {
        assertEquals("", ROTx.rot13v2(""));
    }
    @Test
    void rot13_n2() {
        assertEquals("aaa", ROTx.rot13v2("nnn"));
    }
    @Test
    void rot13_m2() {
        assertEquals("zzz", ROTx.rot13v2("mmm"));
    }
    @Test
    void rot13_zuzu2() {
        assertEquals("mhmh", ROTx.rot13v2("zuzu"));
    }
    @Test
    void rot13_specialCharacters2() {
        assertEquals("*1+-/", ROTx.rot13v2("*1+-/"));
    }
    @Test
    void rot13_Tere3() {
        assertEquals("Grer", ROTx.rotX("Tere",13));
    }
    @Test
    void rotX_Grer_3() {
        assertEquals("Juhu", ROTx.rotX("Grer",3));
    }
    @Test
    void rotX_empty_23() {
        assertEquals("", ROTx.rotX("",23));
    }
    @Test
    void rotX_nnn_21() {
        assertEquals("iii", ROTx.rotX("nnn",21));
    }
    @Test
    void rotX_mmm_0() {
        assertEquals("mmm", ROTx.rotX("mmm",0));
    }
    @Test
    void rotX_zuzu_26() {
        assertEquals("zuzu", ROTx.rotX("zuzu",26));
    }
    @Test
    void rotX_symbols_14() {
        assertEquals("*1+-/", ROTx.rotX("*1+-/",14));
    }
    @Test
    void rot13_randomString() {

        String randomString = createRandomString();
        assertEquals(randomString, ROTx.rot13v2(ROTx.rot13v2(randomString)));
    }

    @ParameterizedTest
    @CsvSource({"zzz,mmm", "mhmh,zuzu"})
    public void rot13(String input, String expectedResult) {
        assertEquals(expectedResult, ROTx.rot13v2(input));
    }

    @ParameterizedTest
    @CsvSource({"Grer, Juhu, 3", "zzz,aaa, 1", "aaa,zzz, -1"})
    public void rotX(String input, String expectedResult, int rotations) {
        assertEquals(expectedResult, ROTx.rotX(input, rotations));
    }

    @ParameterizedTest
    @MethodSource ("provideDataForRotX")
    void rotX_MS_test (String input, String expectedResult, int rotations) {
        assertEquals(expectedResult, ROTx.rotX(input, rotations));
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

    private static Stream<Arguments> provideDataForRotX() {
        return Stream.of(
                Arguments.of("aAaa", "eEee", 4),
                Arguments.of("meil on päris lahe päev:codeborne+1234 ?ruulib", "iaeh kj läneo hwda läar:ykzaxknja+1234 ?nqqhex", 22),
                Arguments.of("fgdgdfg58856fdgdfgdfgdvcHEJGascfU", "opmpmop58856ompmopmopmelQNSPjbloD", -17),
                Arguments.of("OkmsMa=", "OkmsMa=", 0)
        );
    }
}