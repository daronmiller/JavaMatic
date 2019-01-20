import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while(!input.equalsIgnoreCase("q")){
            inputHandler.handleInput(input);
            input = scanner.nextLine();
        }

        scanner.close();
    }

}
