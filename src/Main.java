import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Init.initMethod();
            System.out.println("Выбрать другое? Yes / No ?");
            String str = sc.nextLine();
            if (str.equalsIgnoreCase("No")) {
                break;
            }
    }
}
}
