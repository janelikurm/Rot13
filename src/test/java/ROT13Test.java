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
}