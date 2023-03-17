import java.util.List;

import static java.lang.Character.*;

public class RotEncoder {

    private final List<Character> alphabet = toCharList("abcdefghijklmnopqrstuvwxyz");

    public String rot13(String userInput) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            if (c >= 'a' && c <= 'm') c += 13;
            else if (c >= 'A' && c <= 'M') c += 13;
            else if (c >= 'n' && c <= 'z') c -= 13;
            else if (c >= 'N' && c <= 'Z') c -= 13;
            result.append(c);
        }
        return result.toString();
    }

    public String rot13v2(String input) {
        return encode(input, 13);
    }

    public String encode(String input, int rotations) {
        List<Character> inputAsList = toCharList(input);
        int rotationReminder = (alphabet.size() + rotations % alphabet.size()) % alphabet.size();

        return charsToString(inputAsList.stream()
                .map(c -> encodeChar(rotationReminder, c))
                .toList());
    }

    private char encodeChar(int rotationReminder, Character c) {
        if (!alphabet.contains(toLowerCase(c))) {
            return c;
        }
        return isLowerCase(c) ? encodeLatinChar(rotationReminder, c)
                : toUpperCase(encodeLatinChar(rotationReminder, toLowerCase(c)));
    }

    private Character encodeLatinChar(int rotationReminder, Character c) {
        return alphabet.get((alphabet.indexOf(c) + rotationReminder) % alphabet.size());
    }

    private String charsToString(List<Character> result) {
        StringBuilder builder = new StringBuilder(result.size());
        for (Character ch : result) {
            builder.append(ch);
        }
        return builder.toString();
    }

    private static List<Character> toCharList(String input) {
        return input.chars().mapToObj(c -> (char) c).toList();
    }
}