import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class RotApplication {

    private final Scanner scanner = new Scanner(System.in);
    private final RotEncoder rotEncoder = new RotEncoder();

    public static void main(String[] args) {
        new RotApplication().run();
    }

    private void run() {
        String input = askUser("Please insert your input which you want to encrypt or decrypt");
        int encodingStep = parseInt(askUser("Please insert number of rotation"));
        String inputEncoded = rotEncoder.encode(input, encodingStep);
        System.out.println("Your encoded message: " + inputEncoded);
        if (isReverseNeeded()) {
            var inputDecoded = rotEncoder.encode(inputEncoded, -encodingStep);
            System.out.println(inputDecoded);
        }
        System.out.println("Thank you for using our amazing encrypting and decrypting device! :)");
    }

    private String askUser(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    private boolean isReverseNeeded() {
        return askUser("Would you like do reverse this action? Press Y for yes")
                .equalsIgnoreCase("Y");
    }
}
