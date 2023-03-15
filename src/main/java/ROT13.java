import java.util.Scanner;

public class ROT13 {
    public static void main(String[] args) {
        new ROT13().encrypter();
    }

    private void encrypter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert your input which you want to encrypt or decrypt");
        String userInput = scanner.nextLine();
        userInput = rot13(userInput);
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
}



