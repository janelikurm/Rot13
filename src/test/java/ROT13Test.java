import org.junit.jupiter.api.Test;

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
}