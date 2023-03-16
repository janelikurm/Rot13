import java.util.List;
import java.util.Scanner;

public class ROTx {
    public static void main(String[] args) {
        ROTx rotX = new ROTx();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert your input which you want to encrypt or decrypt");
        String userStringInput = scanner.nextLine();
        System.out.println("Please insert number of rotation");
        int userRotationInput = scanner.nextInt();
        userStringInput = rotX.rotX(userStringInput, userRotationInput);
        System.out.println(userStringInput);
        System.out.println("Would you like do reverse this action? Press Y for yes");
        if (scanner.next().equalsIgnoreCase("Y")) {
            userStringInput = rotX.rotX(userStringInput,-userRotationInput);
            System.out.println(userStringInput);
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

    public String rot13v2(String input) {
     return rotX(input, 13);
    }

    public String rotX(String input, int rotations) {
        List<Character> inputAsList = input.chars().mapToObj(c -> (char) c).toList();
        List<Character> alphabetAsChars = "abcdefghijklmnopqrstuvwxyz".chars().mapToObj(c -> (char) c).toList();
        int rotationReminder = rotations < 0 ? alphabetAsChars.size() + rotations % alphabetAsChars.size() : rotations % alphabetAsChars.size();

        List<Character> result = inputAsList.stream().map(c -> alphabetAsChars.contains(Character.toLowerCase(c)) ?
                                                                Character.isLowerCase(c) ?
                                                               alphabetAsChars.get((alphabetAsChars.indexOf(c) + rotationReminder) % alphabetAsChars.size()) :
                                                                Character.toUpperCase(alphabetAsChars.get((alphabetAsChars.indexOf(Character.toLowerCase(c)) + rotationReminder) % alphabetAsChars.size())) :
                                                                c)
                                                                .toList();

        StringBuilder builder = new StringBuilder(result.size());
        for (Character ch : result) {
            builder.append(ch);
        }
        return builder.toString();
    }

}