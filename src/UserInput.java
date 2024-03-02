import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
    public static int pickNumber() throws IOException {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Введите число: ");
        String userInput = reader.readLine();
        return Integer.parseInt(userInput);
    }
}
