package org.example;

public class ROT13 {
    public static void main(String[] args) {
        ROT13 rot13 = new ROT13();

        String s = "Tere";

        s = rot13.rot13(s);
        System.out.println(s);
        s = rot13.rot13(s);
        System.out.println(s);
    }

    public String rot13(String s) {
        StringBuilder result = new StringBuilder();
        for (
                int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'm') c += 13;
            else if (c >= 'A' && c <= 'M') c += 13;
            else if (c >= 'n' && c <= 'z') c -= 13;
            else if (c >= 'N' && c <= 'Z') c -= 13;
            result.append(c);
        }
        return result.toString();
    }
}



