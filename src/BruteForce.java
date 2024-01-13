import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.Scanner;

public class BruteForce {
    static void doBruteForce(){
        try {
            Path path = Init.check();
            String line;
            Scanner sc = new Scanner(System.in);
            String message = new String();

            for (int index = 1; index < 38; index++) {
                message = "";
                System.out.println("Ключ: " + index);
                BufferedReader bf = new BufferedReader(new FileReader(path.toFile()));
                while((line = bf.readLine()) != null) {
                    for (int i = 0; i < line.length(); i++) {
                        int charPosition = Init.findIndex(line.charAt(i));
                        int keyVal = (charPosition + index) % 38;
                        char replaceVal = Init.findChar(keyVal);
                        if (i == line.length() - 1) {
                            message += replaceVal + "\n";
                        }
                        message += replaceVal;
                    }
                }

                System.out.print(message);
                System.out.println("Продолжать подбор?: Yes / No");
                if (sc.nextLine().equalsIgnoreCase("no")) {
                    break;
                }
            }
            Init.writeFile(message);

        }  catch (Exception e) {
            e.getStackTrace();
        }
    }
}
