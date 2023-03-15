import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ROT13 {
    public static void main(String[] args) {
        new ROT13().encrypter();
        System.out.println((int) 'a' - 97 + 13);
    }

    private void encrypter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert your input which you want to encrypt or decrypt");
        String userInput = scanner.nextLine();
        userInput = rot13v2(userInput);
        System.out.println(userInput);
        System.out.println("Would you like do reverse this action? Press Y for yes");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            userInput = rot13(userInput);
            System.out.println(userInput);
        }
        System.out.println("Thank you for using our amazing encrypting and decrypting device! :)");
    }

    public String rot13(String userInput) {
        StringBuilder result = new StringBuilder();
        for (
                int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            if (c >= 'a' && c <= 'm') c += 13;
            else if (c >= 'A' && c <= 'M') c += 13;
            else if (c >= 'n' && c <= 'z') c -= 13;
            else if (c >= 'N' && c <= 'Z') c -= 13;
            result.append(c);
        }
        return result.toString();
    }

    public String rot13v2 (String input) {
    List<Character> inputAsList = input.chars().mapToObj(c -> (char)c).toList();
    List<Character> alphabetAsChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".chars().mapToObj(c -> (char)c).toList();

        List<Character> result = inputAsList.stream().map(c -> Character.isUpperCase(c) ? c < 'N' ? alphabetAsChars.get((int)c - 65 + 13) : alphabetAsChars.get((int)c - 65 - 13)
                : c < 'n' ? alphabetAsChars.get((int)c - 71 + 13) : alphabetAsChars.get((int)c - 71 - 13)).toList();

        StringBuilder builder = new StringBuilder(result.size());
        for(Character ch: result)
        {
            builder.append(ch);
        }
        return builder.toString();
    }
}



